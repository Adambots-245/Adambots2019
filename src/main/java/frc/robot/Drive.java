package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;

public class Drive {
    private static Timer timer = new Timer();

    public static void init() {
        timer.start();
    }

    public static void drive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh, int override) {
        //if override has been pressd an even # of times, then manual shifting. else autoshift
        if (override % 2 == 1) {
            tankDrive(speed, turnSpeed, shiftLow, shiftHigh);
        } else {
            shiftDrive(speed, turnSpeed);
        }
    }

    public static void tankDrive(double speed, double turnSpeed, boolean shiftLow, boolean shiftHigh) {

        // Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
        boolean state = false;
        if (shiftHigh) {
            state = true;
        } else if (shiftLow) {
            state = false;
        } else {
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
        double currentTime = timer.get();
        // Makes sure speed does not go above max
        double leftSpeed = Math.min(speed + turnSpeed, Constants.MAX_MOTOR_SPEED);
        double rightSpeed = Math.min(speed - turnSpeed, Constants.MAX_MOTOR_SPEED);
        if ((Math.abs(Actuators.getLeft1Motor().getSelectedSensorVelocity()
                - Actuators.getRight1Motor().getSelectedSensorVelocity()) < Constants.TURN_THRESHOLD)
                && (currentTime > Constants.TIME_THRESHOLD)) {
            if (Math.abs(Actuators.getLeft1Motor().getSelectedSensorVelocity()) > Math
                    .abs(Actuators.getRight1Motor().getSelectedSensorVelocity()))
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
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);
    }

}