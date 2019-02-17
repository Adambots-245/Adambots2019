package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;

public class Drive {
    private static Timer timer = new Timer();
    private static boolean state;

    public static void init() {
        timer.start();
        state = false;
    }

    public static void drive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh, int override) {
        // if override has been pressd an even # of times, then manual shifting. else
        // autoshift
        if (override % 2 == 0) {
            System.out.println("tank");
            tankDrive(speed, turnSpeed, shiftLow, shiftHigh);
        } else {
            System.out.println("shift");
            shiftDrive(speed, turnSpeed);
        }
        System.out.println("Left Velocity: " + -
        Actuators.getLeft2Motor().getSelectedSensorVelocity());
        System.out.println("Right Velocity: " + Actuators.getRight2Motor().getSelectedSensorVelocity());
    }

    public static void tankDrive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh) {

        // Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
        if (shiftHigh) {
            state = true;
        } else if (shiftLow) {
            state = false;
        }
        // Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
        Actuators.getShiftHighGear().set(state);
    }

    public static void shiftDrive(double speed, double turnSpeed) {
        // automatic shifting
        // not implemented
        double leftVelocity = -1 * Actuators.getLeft2Motor().getSelectedSensorVelocity();
        double rightVelocity = Actuators.getRight2Motor().getSelectedSensorVelocity();
        double currentTime = timer.get();
        double avgVelocity;
        // Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
        if ((Math.abs(leftVelocity - rightVelocity) < Constants.SHIFT_TURN_THRESHOLD)
                && (currentTime > Constants.SHIFT_TIME_THRESHOLD)) {
            avgVelocity = (leftVelocity + rightVelocity) / 2;
            if (avgVelocity > Constants.SHIFT_UP_THRESHOLD) {
                Actuators.getShiftHighGear().set(true);
                timer.reset();
            }

            if (avgVelocity < Constants.SHIFT_DOWN_THRESHOLD) {
                Actuators.getShiftHighGear().set(false);
                timer.reset();
            }
        }
        else if (currentTime > Constants.SHIFT_TIME_THRESHOLD){
            Actuators.getShiftHighGear().set(false);
        }
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
    }
}