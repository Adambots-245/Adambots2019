package frc.secondary;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.*;

public class Cargo {
    private static Timer timer = new Timer();
    private static boolean armPhotoEyeOpenLast = false;

    public static void init() {
        timer.start();
    }

    public static void cargo(int modeTogglePresses, double intakeSpeed, double armSpeed) {
        if (modeTogglePresses % 2 == 0) {
            cargoIntakeWheels(intakeSpeed);
            moveArm(armSpeed);
        }
    }
    //stops intake motor after intakeDelayTime seconds if the photoeye is blocked
    //otherwise sets the intake speed to intakeSpeed 
    public static void cargoIntakeWheels(double intakeSpeed){
        boolean armPhotoEyeOpenCurrent = Sensors.getDIValue(Sensors.getCargoPresentArm());
        boolean armPhotoEyeToggled = false;
        double armPos = Sensors.getArmPotentiometerValue();
        double maxArmPos = Constants.ARM_POTENTIOMETER_MAX;
        boolean positive = intakeSpeed > 0; 
        double armThresholdPos = maxArmPos - Constants.ARM_DOWN_POSITION_THRESHOLD;
        double intakeDelayTime = Constants.ARM_INTAKE_STOP_DELAY_TIME;
        double speed = 0;
        if (armPhotoEyeOpenCurrent && !armPhotoEyeOpenLast){
            armPhotoEyeToggled = true;
        }
        if (armPhotoEyeToggled){
            timer.reset();
        }
        if (!armPhotoEyeOpenCurrent && armPos > armThresholdPos && timer.get() >= intakeDelayTime && positive){
            speed = Constants.STOP_MOTOR_SPEED;
        }
        else{
            speed = intakeSpeed;
        }
        Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, speed);
        armPhotoEyeOpenLast = armPhotoEyeOpenCurrent;
    }

    // If sensor is blocked, stop the intake and move the arm
    // If not, set the intake to the input of the triggers
    public static void combinedCargoIntake(double speed) {
        if (Sensors.getDIValue(Sensors.getCargoPresentArm())) {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, Constants.STOP_MOTOR_SPEED);
            moveArm(speed);
        } else {
            Actuators.getInfeedArmMotor().set(ControlMode.PercentOutput, speed);
        }
    }

    // Moves the arm so long as it is within the threshold
    private static void moveArm(double speed) {
        boolean positive = speed > 0; //arm is moving down
        boolean limitSwitchPressed = Sensors.getDIValue(Sensors.getArmLimitSwitch());
        double armPos = Sensors.getArmPotentiometerValue();
        double maxArmPos = Constants.ARM_POTENTIOMETER_MAX;
        double armSpeed;
        if ((positive && armPos >= maxArmPos) || (!positive && limitSwitchPressed)) {
            armSpeed = Constants.STOP_MOTOR_SPEED;
        } else {
            armSpeed = speed;
        }
        Actuators.getClimbMotor().set(ControlMode.PercentOutput, armSpeed);
    }

    //resets the potentiometer if limit switch is pressed
    public static void resetArmPotentiometerOnLimitSwitch(){
        if (Sensors.getDIValue(Sensors.getArmLimitSwitch())){
            Sensors.resetArmPotentiometer();
        }
    }
}