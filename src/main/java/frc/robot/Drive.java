package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Drive {
    private static Timer timer = new Timer();
    private static boolean state;
    private static boolean currentShift;
    private static boolean lastShift;
    private static int downShiftState;
    private static int upShiftState;
    private static boolean autoShiftState;
    public static void init() {
        timer.start();
        state = false;
        currentShift = false;
        lastShift = false;
        downShiftState = 0;
        upShiftState = 0;
    }
    public static boolean getAutoShiftState(){
        return autoShiftState;
    }
    public static Value shiftingValue(boolean state){
        Value value;
        if (state) {
            value = Value.kForward;
        } else {
            value = Value.kReverse;
        }
        return value;
    }

    public static void drive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh, int override) {
        // if override has been pressd an even # of times, then manual shifting. else
        // autoshift
        if (override % 2 == 0) {
            //System.out.println("tank");
            autoShiftState = false;
            tankDrive(speed, turnSpeed, shiftLow, shiftHigh);
        } else {
            //System.out.println("shift");
            autoShiftState = true;
            shiftDrive(speed, turnSpeed);
        }
        //System.out.println("Left Velocity: " + -
        //Actuators.getLeft2Motor().getSelectedSensorVelocity());
        //System.out.println("Right Velocity: " + Actuators.getRight2Motor().getSelectedSensorVelocity());
    }
    public static void autonMotor(double error){
        double f_leftSpeed = Constants.MAX_MOTOR_SPEED;
        double f_rightSpeed = Constants.MAX_MOTOR_SPEED;
        System.out.println("Error:" + error);
        if(error > 0.1){
            f_rightSpeed = (Constants.MAX_MOTOR_SPEED - Constants.MAX_MOTOR_SPEED * Math.abs(error));
            System.out.println("Right Speed:" + f_rightSpeed);     
        }
        else if(error < -0.1){
            f_leftSpeed = (Constants.MAX_MOTOR_SPEED - Constants.MAX_MOTOR_SPEED * Math.abs(error));
            System.out.println("Left Speed:" + f_leftSpeed);
        }
        else{
            f_leftSpeed = Constants.MAX_MOTOR_SPEED;
            f_rightSpeed = Constants.MAX_MOTOR_SPEED;
        }
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, Math.max(f_rightSpeed, -Constants.MAX_MOTOR_SPEED));
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, Math.max(f_leftSpeed, -Constants.MAX_MOTOR_SPEED));
    }

    public static void tankDrive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh) {

        // Makes sure speed does not go above max
         speed = speed * -1; // fix forward = back
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
    //double leftSpeed = Gamepad.primary.getLeftY().get();
    //      double rightSpeed = -Gamepad.primary.getLeftY().get();
    //    leftSpeed = Gamepad.primary.getRightX().get();
    //    rightSpeed = -Gamepad.primary.getRightX().get();
        if (shiftHigh) {
            state = true;
        } else if (shiftLow) {
            state = false;
        }
        // Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
   
        Actuators.getShiftHighGear().set(shiftingValue(state));
    }

    public static void shiftDrive(double speed, double turnSpeed) {
        // automatic shifting
        // not implemented
        double leftVelocity = -1 * Actuators.getLeft1Motor().getSelectedSensorVelocity();
        double rightVelocity = Actuators.getRight1Motor().getSelectedSensorVelocity();
        double currentTime = timer.get();
        double avgVelocity;
        // Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
        if ((Math.abs(leftVelocity - rightVelocity) < Constants.SHIFT_TURN_THRESHOLD)
                && (currentTime > Constants.SHIFT_TIME_THRESHOLD)) {
            avgVelocity = Math.abs((leftVelocity + rightVelocity) / 2);
            if (avgVelocity > Constants.SHIFT_UP_THRESHOLD) {
                currentShift = true;
                timer.reset();
            }

            if (avgVelocity < Constants.SHIFT_DOWN_THRESHOLD) {
                currentShift = false;
                timer.reset();
            }
        }
        else if (currentTime > Constants.SHIFT_TIME_THRESHOLD){
            currentShift = false;
        }
        if (currentShift && !lastShift){
            upShiftState++; 
        }
        else if (!currentShift && lastShift){
            downShiftState++;
        }
        else{
            upShiftState = 0;
            downShiftState = 0;
        }

        if (upShiftState == 1 || downShiftState == 1){
            rightSpeed = Constants.STOP_MOTOR_SPEED;
            leftSpeed = Constants.STOP_MOTOR_SPEED;
        }
        else{
            Actuators.getShiftHighGear().set(shiftingValue(currentShift));
        }
        lastShift = currentShift;
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
    }

    public static void rotate(double speed){
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, speed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, -speed);
    }
}