package frc.robot;



public class Constants{

    //CAN ports
    public static final int LEFT_DRIVE_MOTOR_TALONSRX = 0;
    public static final int LEFT_DRIVE_MOTOR_VICTORSPX1 = 1;
    public static final int RIGHT_DRIVE_MOTOR_VICTORSPX1 = 2;
    public static final int RIGHT_DRIVE_MOTOR_VICTORSPX2 = 3;
    public static final int LIFT_MOTOR_TALONSRX = 4;
    public static final int LIFT_MOTOR_VICTORSPX = 5;
    public static final int CLIMBING_ARM_CARGO_ACQUISITION = 6;
    public static final int LINEAR_ACTUATOR_MOTOR = 7;
    public static final int INFEED_BAG_MOTOR_ARM = 8;
    public static final int INFEED_BAG_MOTOR_LIFT1 = 9;
    public static final int INFEED_BAG_MOTOR_LIFT2 = 10;


    //Pneumatics
    //PCM ports
    public static final int RAISE_CENTERING_HATCH = 0;
    public static final int LOWER_CENTERING_HATCH = 1;
    public static final int ADVANCE_CARGO_HATCH_DELVERY = 2;
    public static final int RETURN_CARGO_HATCH_DELIVERY = 3;
    public static final int VACUUM_ON = 4;
    public static final int OPEN_HATCH_CLAMP = 5;
    public static final int RAISE_HATCH_VACUUM_ARM = 6;
    public static final int LOWER_HATCH_VACUUM_ARM = 7;

    //Limiters
    public static final double MAX_LIFT_SPEED = 0.0; //TODO: Update this value to the actual max elevator speed
}