package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.*;
public class Actuators{

    //Motors through motor controllers
    private static WPI_TalonSRX Left1Motor;
    private static WPI_VictorSPX Left2Motor;
    private static WPI_VictorSPX Right1Motor;
    private static WPI_VictorSPX Right2Motor;
    private static WPI_TalonSRX ClimbMotor;
    private static WPI_TalonSRX LinearActuator;
    private static WPI_VictorSPX InfeedArmMotor;
    private static WPI_VictorSPX ArmInOutLift1;
    private static WPI_VictorSPX ArmInOutLift2;
    private static WPI_TalonSRX LiftMotor1;
    private static WPI_VictorSPX LiftMotor2;


    // Pneumatics

    private static Solenoid Vacuum;
    private static DoubleSolenoid ArmRaiseLower;
    private static DoubleSolenoid CenterHatch;
    private static Solenoid HatchClampOpen;
    private static DoubleSolenoid CargoHatchDelivery;


    public void init(){

    //TODO: add 3rd motor, talk to Mars
    Left1Motor = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_TALONSRX);
    Left2Motor = new WPI_VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX1);
    Right1Motor = new WPI_VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX1);
    Right2Motor = new WPI_VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX2);
    //Right3Motor = new VictorSPX(deviceNumber);
    ClimbMotor = new WPI_TalonSRX(Constants.CLIMBING_ARM_CARGO_ACQUISITION);
    LinearActuator = new WPI_TalonSRX(Constants.LINEAR_ACTUATOR_MOTOR);
    InfeedArmMotor = new WPI_VictorSPX(Constants.INFEED_BAG_MOTOR_ARM);
    ArmInOutLift1 = new WPI_VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT1);
    ArmInOutLift2 = new WPI_VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT2);
    LiftMotor1 = new WPI_TalonSRX(Constants.LIFT_MOTOR_TALONSRX);
    LiftMotor2 = new WPI_VictorSPX(Constants.LIFT_MOTOR_VICTORSPX);

    Vacuum = new Solenoid(Constants.VACUUM_ON);
    ArmRaiseLower = new DoubleSolenoid(Constants.RAISE_HATCH_VACUUM_ARM, Constants.LOWER_HATCH_VACUUM_ARM);
    CenterHatch = new DoubleSolenoid(Constants.RAISE_CENTERING_HATCH, Constants.LOWER_CENTERING_HATCH);
    HatchClampOpen = new Solenoid(Constants.OPEN_HATCH_CLAMP);
    CargoHatchDelivery = new DoubleSolenoid(Constants.ADVANCE_CARGO_HATCH_DELVERY, Constants.RETURN_CARGO_HATCH_DELIVERY);



    }


    public static WPI_VictorSPX getRight1Motor() {
        return Right1Motor;
    }
    public static WPI_VictorSPX getRight2Motor() {
        return Right2Motor;
    }
    public static WPI_TalonSRX getLeft1Motor() {
        return Left1Motor;
    }

    public static WPI_VictorSPX getLeft2Motor() {
        return Left2Motor;
    }


}


















