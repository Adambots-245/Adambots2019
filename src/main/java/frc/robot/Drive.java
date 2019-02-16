package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import frc.secondary.*;

public class Drive{
    private static Timer timer = new Timer();

    public static void init(){
        timer.start();
    }

    public static void ghostDrive(double[] inputs) {
        Drive.tankDrive(inputs[Constants.PRIMARY_LEFT_JOY_Y], inputs[Constants.PRIMARY_RIGHT_JOY_Y]);
        Cargo.cargoInOut(-(inputs[Constants.SECONDARY_LEFT_TRIGGER] - inputs[Constants.SECONDARY_RIGHT_TRIGGER]));
        Cargo.moveArm(inputs[Constants.SECONDARY_RIGHT_JOY_Y]);
    }

    public static void tankDrive(double speed, double turnSpeed) {
        
        //Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);

        //Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);        
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
        
    }

    public static void shiftGear(double speed, boolean shiftHigh, boolean shiftLow) {

        //automatic shifting
        //not implemented
        boolean override = false;
        double currentTime = timer.get();
        
        if (override == false) {
            if ((Math.abs(Actuators.getLeft1Motor().getSelectedSensorVelocity() - Actuators.getRight1Motor().getSelectedSensorVelocity()) < Constants.TURN_THRESHOLD) && (currentTime > Constants.TIME_THRESHOLD)) {
                if (Math.abs(Actuators.getLeft1Motor().getSelectedSensorVelocity()) > Math.abs(Actuators.getRight1Motor().getSelectedSensorVelocity()))
                    speed = Math.abs(Actuators.getLeft1Motor().getSelectedSensorVelocity());
                else
                    speed = Math.abs(Actuators.getRight1Motor().getSelectedSensorVelocity());
            
                if (speed > Constants.SHIFT_UP_THRESHOLD) {
                    Actuators.getShiftHighGear().set(true);
                    timer.reset();
                }
            
                if (speed < Constants.SHIFT_DOWN_THRESHOLD) {
                    Actuators.getShiftHighGear().set(false);
                    timer.reset();
                }
            }
        
        } else {
            Actuators.getShiftHighGear().set(false);	
        }
        
        if (Gamepad.secondary.getX()) {
            override = !override;
        } 

    }

}