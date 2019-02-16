package frc.robot;



public class Constants{

    //CAN ports
    public static final int LEFT_DRIVE_MOTOR_TALONSRX = 0;
    public static final int LEFT_DRIVE_MOTOR_VICTORSPX1 = 1;
    public static final int RIGHT_DRIVE_MOTOR_TALONSRX = 2;
    public static final int RIGHT_DRIVE_MOTOR_VICTORSPX1 = 3;
    public static final int LIFT_MOTOR_TALONSRX = 4;
    public static final int LIFT_MOTOR_VICTORSPX = 5;
    public static final int CLIMBING_ARM_CARGO_ACQUISITION = 6;
    public static final int LINEAR_ACTUATOR_MOTOR = 7;
    public static final int INFEED_BAG_MOTOR_ARM = 8;
    public static final int INFEED_BAG_MOTOR_LIFT1 = 9;
    public static final int INFEED_BAG_MOTOR_LIFT2 = 10;
    public static final int LEFT_DRIVE_MOTOR_VICTORSPX2 = 11;
    public static final int RIGHT_DRIVE_MOTOR_VICTORSPX2 = 12;

     //Analog Input ports
     public static final int ARM_POTENTIOMETER_PORT = 0;

     //Digital Input ports
     //TODO: Properly name these according to what they actually are (photo eye, limit switch...)
     public static final int LIFT_SENSOR_PORT = 0;
     public static final int HATCH_SENSOR_PORT = 1;
     public static final int CARGO_ARM_SENSOR_PORT = 2;
     public static final int CARGO_LIFT_SENSOR_PORT = 3;
    
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
    
    public static final int SHIFT_HIGH_SPEED = 0;


    //motor speeds
    public static final double STOP_MOTOR_SPEED = 0.0;
    public static final double HALF_MOTOR_SPEED = 0.45;
    public static final double MAX_MOTOR_SPEED = 0.9;

    //autoshift thresholds
    public static final double TURN_THRESHOLD = 5;
    public static final double SHIFT_UP_THRESHOLD = 10;
    public static final double SHIFT_DOWN_THRESHOLD = 8;
    public static final double TIME_THRESHOLD = 3;
    public static final double ARM_POTENTIOMETER_MAX = 0.5;
    public static final double ARM_POTENTIOMETER_MIN = 0;
    
    //TODO: UPDATE ALL VALUES BELOW TO THEIR TRUE, ACCURATE VALUES
    //Limiters
    public static final double MAX_LIFT_SPEED = 0.0;
    
    //Misc
    public static final int LIFT_LEVEL_1 = 0;
    public static final int LIFT_LEVEL_2 = 30000;
    public static final int LIFT_LEVEL_3 = 60000; 

    //Limiters TODO: UPDATE MAX AND MIN CLIMB SPEEDS TO CORRECT VALUES
    public static final double MAX_CLIMB_SPEED = 0.9;
    public static final double MIN_CLIMB_SPEED = -0.9;

    // Recorder constants
    public static final int MAX_INDEX = 750;
    public static final int RECORDED_VALUES_AMOUNT = 38;
    public static final int RECORDER_SLEEP_TIME = 20;

	public static final int TIME_INDEX = 0; 
    public static final int PRIMARY_LEFT_JOY_X = 1;
    public static final int PRIMARY_LEFT_JOY_Y = 2;
    public static final int PRIMARY_RIGHT_JOY_X = 3;
    public static final int PRIMARY_RIGHT_JOY_Y = 4;
    public static final int PRIMARY_LEFT_TRIGGER = 5;
    public static final int PRIMARY_RIGHT_TRIGGER = 6;
    public static final int PRIMARY_A = 7;
    public static final int PRIMARY_B = 8;
    public static final int PRIMARY_X = 9;
    public static final int PRIMARY_Y = 10;
    public static final int PRIMARY_START = 11;
    public static final int PRIMARY_BACK = 12;
    public static final int PRIMARY_LB = 13;
    public static final int PRIMARY_RB = 14;
    public static final int PRIMARY_DPAD_UP = 15;
    public static final int PRIMARY_DPAD_DOWN = 16;
    public static final int PRIMARY_DPAD_LEFT = 17;
    public static final int PRIMARY_DPAD_RIGHT = 18;

}