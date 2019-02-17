package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.*;

public class Actuators {

    // Motors through motor controllers
    private static TalonSRX Left1Motor;
    private static VictorSPX Left2Motor;
    private static TalonSRX Right1Motor;
    private static VictorSPX Right2Motor;
    private static VictorSPX Left3Motor;
    private static VictorSPX Right3Motor;
    private static TalonSRX ClimbMotor;
    private static TalonSRX LinearActuator;
    private static VictorSPX InfeedArmMotor;
    private static VictorSPX ArmInOutLift1;
    private static VictorSPX ArmInOutLift2;
    private static TalonSRX LiftMotor1;
    private static VictorSPX LiftMotor2;

    // Pneumatics

    private static Solenoid Vacuum;
    private static DoubleSolenoid ArmRaiseLower;
    private static DoubleSolenoid CenterHatch;
    private static Solenoid HatchClampOpen;
    private static Solenoid CargoHatchDelivery;
    private static Solenoid ShiftHighGear;

    public static void init() {

        // TODO: add 3rd motor, talk to Mars
        Left1Motor = new TalonSRX(Constants.LEFT_DRIVE_MOTOR_TALONSRX);
        Left2Motor = new VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX1);
        Left3Motor = new VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX2);
        Right1Motor = new TalonSRX(Constants.RIGHT_DRIVE_MOTOR_TALONSRX);
        Right2Motor = new VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX1);
        Right3Motor = new VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX2);

        ClimbMotor = new TalonSRX(Constants.CLIMBING_ARM_CARGO_ACQUISITION);
        LinearActuator = new TalonSRX(Constants.LINEAR_ACTUATOR_MOTOR);
        InfeedArmMotor = new VictorSPX(Constants.INFEED_BAG_MOTOR_ARM);
        ArmInOutLift1 = new VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT1);
        ArmInOutLift2 = new VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT2);
        LiftMotor1 = new TalonSRX(Constants.LIFT_MOTOR_TALONSRX);
        LiftMotor2 = new VictorSPX(Constants.LIFT_MOTOR_VICTORSPX);

        Vacuum = new Solenoid(Constants.VACUUM_ON);
        ArmRaiseLower = new DoubleSolenoid(Constants.RAISE_HATCH_VACUUM_ARM, Constants.LOWER_HATCH_VACUUM_ARM);
        CenterHatch = new DoubleSolenoid(Constants.RAISE_CENTERING_HATCH, Constants.LOWER_CENTERING_HATCH);
        HatchClampOpen = new Solenoid(Constants.OPEN_HATCH_CLAMP);
        CargoHatchDelivery = new Solenoid(Constants.ADVANCE_CARGO_HATCH_DELVERY);
        ShiftHighGear = new Solenoid(1, Constants.SHIFT_HIGH_SPEED);

        // set follower motors
        Left2Motor.follow(Left1Motor);
        Left3Motor.follow(Left1Motor);
        Right2Motor.follow(Right1Motor);
        Right3Motor.follow(Right1Motor);

        ArmInOutLift2.follow(ArmInOutLift1);
        // reverse motors
        Left1Motor.setInverted(true);
        Left2Motor.setInverted(true);
        Left3Motor.setInverted(true);
        Right1Motor.setInverted(false);
        Right2Motor.setInverted(false);
        Right3Motor.setInverted(false);

        ArmInOutLift2.setInverted(true);
        // set drive motors to coast
        Left1Motor.setNeutralMode(NeutralMode.Coast);
        Left2Motor.setNeutralMode(NeutralMode.Coast);
        Left3Motor.setNeutralMode(NeutralMode.Coast);
        Right1Motor.setNeutralMode(NeutralMode.Coast);
        Right2Motor.setNeutralMode(NeutralMode.Coast);
        Right3Motor.setNeutralMode(NeutralMode.Coast);


        // set follower motors
        ArmInOutLift2.follow(ArmInOutLift1);
        LiftMotor2.follow(LiftMotor1);

       
    }

    public static TalonSRX getClimbMotor() {
        return ClimbMotor;
    }

    public static TalonSRX getArmInOutLift1() {
        return LinearActuator;
    }

    public static TalonSRX getLinearActuator() {
        return LinearActuator;
    }

    public static VictorSPX getInfeedArmMotor() {
        return InfeedArmMotor;
    }

    public static TalonSRX getLiftMotor1() {
        return LiftMotor1;
    }

    public static Solenoid getShiftHighGear() {
        return ShiftHighGear;
    }

    public static DoubleSolenoid getCenterHatch() {
        return CenterHatch;
    }

    public static Solenoid getVacuum() {
        return Vacuum;
    }

    public static DoubleSolenoid getArmRaiseLower() {
        return ArmRaiseLower;
    }

    public static Solenoid getHatchClampOpen() {
        return HatchClampOpen;
    }

    public static Solenoid getSpearExtend() {
        return CargoHatchDelivery;
    }

    public static TalonSRX getLeft1Motor() {
        return Left1Motor;
    }

    public static VictorSPX getLeft2Motor() {
        return Left2Motor;
    }

    public static VictorSPX getLeft3Motor() {
        return Left3Motor;
    }

    public static TalonSRX getRight1Motor() {
        return Right1Motor;
    }

    public static VictorSPX getRight2Motor() {
        return Right2Motor;
    }

    public static VictorSPX getRight3Motor() {
        return Right3Motor;
    }

}