package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;

public class Actuators {

    // Motors through motor controllers
    private static WPI_TalonSRX Left1Motor;
    private static WPI_VictorSPX Left2Motor;
    private static WPI_TalonSRX Right1Motor;
    private static WPI_VictorSPX Right2Motor;
    private static WPI_VictorSPX Left3Motor;
    private static WPI_VictorSPX Right3Motor;
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
    private static Solenoid CargoHatchDelivery;
    private static DoubleSolenoid ShiftHighGear;
    private static Solenoid RingLight;

    public static void init() {

        
        Left1Motor = new WPI_TalonSRX(Constants.LEFT_DRIVE_MOTOR_TALONSRX);
        Left2Motor = new WPI_VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX1);
        Left3Motor = new WPI_VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX2);
        Right1Motor = new WPI_TalonSRX(Constants.RIGHT_DRIVE_MOTOR_TALONSRX);
        Right2Motor = new WPI_VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX1);
        Right3Motor = new WPI_VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX2);

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
        HatchClampOpen = new Solenoid(1, Constants.OPEN_HATCH_CLAMP);
        CargoHatchDelivery = new Solenoid(Constants.ADVANCE_CARGO_HATCH_DELVERY);
        ShiftHighGear = new DoubleSolenoid(Constants.SHIFT_HIGH_SPEED, Constants.SHIFT_LOW_SPEED);
        RingLight = new Solenoid(1, Constants.RING_LIGHT);

        // set follower motors
        Left2Motor.follow(Left1Motor);
        Left3Motor.follow(Left1Motor);
        Right2Motor.follow(Right1Motor);
        Right3Motor.follow(Right1Motor);

        ArmInOutLift2.follow(ArmInOutLift1);
        // reverse motors
        Left1Motor.setInverted(false);
        Left2Motor.setInverted(false);
        Left3Motor.setInverted(false);
        Right1Motor.setInverted(true);
        Right2Motor.setInverted(true);
        Right3Motor.setInverted(true);

        InfeedArmMotor.setInverted(true);

        ArmInOutLift2.setInverted(true);
        // set drive motors to coast
        Left1Motor.setNeutralMode(NeutralMode.Coast);
        Left2Motor.setNeutralMode(NeutralMode.Coast);
        Left3Motor.setNeutralMode(NeutralMode.Coast);
        Right1Motor.setNeutralMode(NeutralMode.Coast);
        Right2Motor.setNeutralMode(NeutralMode.Coast);
        Right3Motor.setNeutralMode(NeutralMode.Coast);

        //set brake motors
        LiftMotor1.setNeutralMode(NeutralMode.Brake);
        LiftMotor2.setNeutralMode(NeutralMode.Brake);
        ArmInOutLift1.setNeutralMode(NeutralMode.Brake);
        ArmInOutLift2.setNeutralMode(NeutralMode.Brake);
        ClimbMotor.setNeutralMode(NeutralMode.Brake);
        
        // set follower motors
        ArmInOutLift2.follow(ArmInOutLift1);
        LiftMotor2.follow(LiftMotor1);

        //limits
        boolean enableDriveSoftLimit = false;
        Right1Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Right1Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);
        Right2Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Right2Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);
        Right3Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Right3Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);
        Left1Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Left1Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);
        Left2Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Left2Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);
        Left3Motor.configForwardSoftLimitEnable(enableDriveSoftLimit);
        Left3Motor.configReverseSoftLimitEnable(enableDriveSoftLimit);

        LiftMotor1.configReverseSoftLimitEnable(enableDriveSoftLimit);
        LiftMotor2.configReverseSoftLimitEnable(enableDriveSoftLimit);

        InfeedArmMotor.configReverseSoftLimitEnable(false);
        InfeedArmMotor.configForwardSoftLimitEnable(false);
        double liftMaxMotorSpeed = Constants.LIFT_MAX_MOTOR_SPEED; 
        LiftMotor1.configPeakOutputForward(liftMaxMotorSpeed);
        LiftMotor1.configPeakOutputReverse(-liftMaxMotorSpeed);
        LiftMotor2.configPeakOutputForward(liftMaxMotorSpeed);
        LiftMotor2.configPeakOutputReverse(-liftMaxMotorSpeed);

        //PID Config
        LiftMotor1.selectProfileSlot(Constants.PID_SLOT, Constants.PID_LOOP);
        LiftMotor1.config_kF(Constants.PID_SLOT, Constants.LIFT_F_VALUE, Constants.PID_TIMEOUT);
        LiftMotor1.config_kP(Constants.PID_SLOT, Constants.LIFT_P_VALUE, Constants.PID_TIMEOUT);
        LiftMotor1.config_kI(Constants.PID_SLOT, Constants.LIFT_I_VALUE, Constants.PID_TIMEOUT);
        LiftMotor1.config_kD(Constants.PID_SLOT, Constants.LIFT_D_VALUE, Constants.PID_TIMEOUT);
       
    }

    public static WPI_TalonSRX getClimbMotor() {
        return ClimbMotor;
    }

    public static WPI_VictorSPX getArmInOutLift1() {
        return ArmInOutLift1;
    }

    public static WPI_TalonSRX getLinearActuator() {
        return LinearActuator;
    }

    public static WPI_VictorSPX getInfeedArmMotor() {
        return InfeedArmMotor;
    }

    public static WPI_TalonSRX getLiftMotor1() {
        return LiftMotor1;
    }

    public static DoubleSolenoid getShiftHighGear() {
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

    public static Solenoid getRingLight() {
        return RingLight;
    }

    public static WPI_TalonSRX getLeft1Motor() {
        return Left1Motor;
    }

    public static WPI_VictorSPX getLeft2Motor() {
        return Left2Motor;
    }

    public static WPI_VictorSPX getLeft3Motor() {
        return Left3Motor;
    }

    public static WPI_TalonSRX getRight1Motor() {
        return Right1Motor;
    }

    public static WPI_VictorSPX getRight2Motor() {
        return Right2Motor;
    }

    public static WPI_VictorSPX getRight3Motor() {
        return Right3Motor;
    }

}