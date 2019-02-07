package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.*;
public class Actuators{

    //Motors through motor controllers
    private static TalonSRX Left1Motor;
    private static VictorSPX Left2Motor;
    private static VictorSPX Right1Motor;
    private static VictorSPX Right2Motor;
    private static TalonSRX ClimbMotor;
    private static TalonSRX LinearActuator;
    private static VictorSPX InfeedArmMotor;
    private static VictorSPX ArmInOutLift1;
    private static VictorSPX ArmInOutLift2;
    private static TalonSRX LiftMotor1;
    private static VictorSPX LiftMotor2;


    // Pneumatics

    private static Solenoid Vacuum;
    private static Solenoid ArmRaiseLower;
    private static Solenoid CenterHatch;
    private static Solenoid HatchClampOpen;
    private static Solenoid CargoHatchDelivery;
    private static Solenoid ShiftHighGear;


    public static void init(){

    //TODO: add 3rd motor, talk to Mars
    Left1Motor = new TalonSRX(Constants.LEFT_DRIVE_MOTOR_TALONSRX);
    Left2Motor = new VictorSPX(Constants.LEFT_DRIVE_MOTOR_VICTORSPX1);
    Right1Motor = new VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX1);
    Right2Motor = new VictorSPX(Constants.RIGHT_DRIVE_MOTOR_VICTORSPX2);
    //Right3Motor = new VictorSPX(deviceNumber);

    //set follower motors
    Left2Motor.follow(Left1Motor);
    Right2Motor.follow(Right1Motor);
    
    //reverse motors
    Left1Motor.setInverted(true);
    Left2Motor.setInverted(true);
    Right1Motor.setInverted(false);
    Right2Motor.setInverted(false);

    //set drive motors to coast
    Left1Motor.setNeutralMode(NeutralMode.Coast);
    Left2Motor.setNeutralMode(NeutralMode.Coast);
    Right1Motor.setNeutralMode(NeutralMode.Coast);
    Right2Motor.setNeutralMode(NeutralMode.Coast);

    ClimbMotor = new TalonSRX(Constants.CLIMBING_ARM_CARGO_ACQUISITION);
    LinearActuator = new TalonSRX(Constants.LINEAR_ACTUATOR_MOTOR);
    InfeedArmMotor = new VictorSPX(Constants.INFEED_BAG_MOTOR_ARM);
    ArmInOutLift1 = new VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT1);
    ArmInOutLift2 = new VictorSPX(Constants.INFEED_BAG_MOTOR_LIFT2);
    LiftMotor1 = new TalonSRX(Constants.LIFT_MOTOR_TALONSRX);
    LiftMotor2 = new VictorSPX(Constants.LIFT_MOTOR_VICTORSPX);

    Vacuum = new Solenoid(Constants.VACUUM_ON);
    ArmRaiseLower = new Solenoid(Constants.RAISE_HATCH_VACUUM_ARM, Constants.LOWER_HATCH_VACUUM_ARM);
    CenterHatch = new Solenoid(Constants.RAISE_CENTERING_HATCH, Constants.LOWER_CENTERING_HATCH);
    HatchClampOpen = new Solenoid(Constants.OPEN_HATCH_CLAMP);
    CargoHatchDelivery = new Solenoid(Constants.ADVANCE_CARGO_HATCH_DELVERY, Constants.RETURN_CARGO_HATCH_DELIVERY);
    ShiftHighGear = new Solenoid(Constants.SHIFT_HIGH_SPEED);

    public static TalonSRX getClimbMotor() {
        return ClimbMotor;
    }
    
    public static TalonSRX getLinearActuator() {
        return LinearActuator;
    }


    
    public static TalonSRX getLiftMotor1() {
        return LiftMotor1;
    }
    
    public static Solenoid getShiftHighGear(){
        return ShiftHighGear;
    }

    public static Solenoid getCenterHatch(){
        return CenterHatch;
    }

    public static Solenoid getVacuum(){
        return Vacuum;
    }

    public static Solenoid getArmRaiseLower(){
        return ArmRaiseLower;
    }

    public static Solenoid getHatchClampOpen(){
        return HatchClampOpen;
    }
    public static TalonSRX getLeft1Motor(){
        return Left1Motor;
    }

    public static TalonSRX getLeft2Motor(){
        return Left2Motor;
    }

    public static TalonSRX getRight1Motor(){
        return Right1Motor;
    }

    public static TalonSRX getRight2Motor(){
        return Right2Motor;
    }

}