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
    public static final int RECORDED_VALUES_AMOUNT = 49;
    public static final int RECORDER_SLEEP_TIME = 20;
    public static final int SECONDARY_OFFSET = 24;
    public static final int AXIS_START_INDEX = 1;
    public static final int BUTTON_START_INDEX = 7;
    public static final int DPAD_START_INDEX = 17;

	public static final int TIME_INDEX = 0; 
    public static final int PRIMARY_LEFT_JOY_X = 1;
    public static final int PRIMARY_LEFT_JOY_Y = 2;
    public static final int PRIMARY_LEFT_TRIGGER = 3;
    public static final int PRIMARY_RIGHT_TRIGGER = 4;
    public static final int PRIMARY_RIGHT_JOY_X = 5;
    public static final int PRIMARY_RIGHT_JOY_Y = 6;
    public static final int PRIMARY_BUTTON_A = 7;
    public static final int PRIMARY_BUTTON_B = 8;
    public static final int PRIMARY_BUTTON_X = 9;
    public static final int PRIMARY_BUTTON_Y = 10;
    public static final int PRIMARY_BUTTON_LB = 11;
    public static final int PRIMARY_BUTTON_RB = 12;
    public static final int PRIMARY_BUTTON_START = 13;
    public static final int PRIMARY_BUTTON_BACK = 14;
    public static final int PRIMARY_BUTTON_LS = 15;
    public static final int PRIMARY_BUTTON_RS = 16;
    public static final int PRIMARY_DPAD_N = 17;
    public static final int PRIMARY_DPAD_NE = 18;
    public static final int PRIMARY_DPAD_E = 19;
    public static final int PRIMARY_DPAD_SE = 20;
    public static final int PRIMARY_DPAD_S = 21;
    public static final int PRIMARY_DPAD_SW = 22;
    public static final int PRIMARY_DPAD_W = 23;
    public static final int PRIMARY_DPAD_NW = 24;
    public static final int SECONDARY_LEFT_JOY_X = 25;
    public static final int SECONDARY_LEFT_JOY_Y = 26;
    public static final int SECONDARY_LEFT_TRIGGER = 27;
    public static final int SECONDARY_RIGHT_TRIGGER = 28;
    public static final int SECONDARY_RIGHT_JOY_X = 29;
    public static final int SECONDARY_RIGHT_JOY_Y = 30;
    public static final int SECONDARY_BUTTON_A = 31;
    public static final int SECONDARY_BUTTON_B = 32;
    public static final int SECONDARY_BUTTON_X = 33;
    public static final int SECONDARY_BUTTON_Y = 34;
    public static final int SECONDARY_BUTTON_L = 35;
    public static final int SECONDARY_BUTTON_R = 36;
    public static final int SECONDARY_BUTTON_START = 37;
    public static final int SECONDARY_BUTTON_BACK = 38;
    public static final int SECONDARY_BUTTON_LS = 39;
    public static final int SECONDARY_BUTTON_RS = 40;
    public static final int SECONDARY_DPAD_N = 41;
    public static final int SECONDARY_DPAD_NE = 42;
    public static final int SECONDARY_DPAD_E = 43;
    public static final int SECONDARY_DPAD_SE = 44;
    public static final int SECONDARY_DPAD_S = 45;
    public static final int SECONDARY_DPAD_SW = 46;
    public static final int SECONDARY_DPAD_W = 47;
    public static final int SECONDARY_DPAD_NW = 48;

    //Sensor Ports
    public static final int LIFT_LOWERED_LIMIT_SWITCH = 10;
    public static final int HATCH_PRESENT_ENCODER = 11;
    public static final int CARGO_PRESENT_ARM = 12;
    public static final int CARGO_PRESENT_LIFT = 13;
    //Limit Switch Constants
    public static final com.ctre.phoenix.motorcontrol.FeedbackDevice QUAD_ENCODER = com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder;
    public static final int MAX_FORWARD_LIFT_LIMIT = 1024;
    public static final int MAX_REVERSE_LIFT_LIMIT = -1024;
    public static final boolean FORWARD_LIMIT_ENABLED = false;
    public static final boolean REVERSE_LIMIT_ENABLED = false;
    public static final boolean LIFT_MOTOR_PHASE = false;

}