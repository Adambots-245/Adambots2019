package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class ToggleDrive {

    public static void toggleDrive(int presses) {
        double leftSpeed;
        double rightSpeed;
        if (presses % 2 == 0) {
            leftSpeed = .5 * Constants.MAX_MOTOR_SPEED;
            rightSpeed = .5 * Constants.MAX_MOTOR_SPEED;
        }
        else{
            leftSpeed = 0;
            rightSpeed = 0;
        }
        // Sets the speeds
        Actuators.getLeft1Motor().set(ControlMode.PercentOutput, leftSpeed);
        Actuators.getRight1Motor().set(ControlMode.PercentOutput, rightSpeed);

    }
}