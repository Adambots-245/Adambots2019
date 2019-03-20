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
     public static final int CARGO_ARM_SENSOR_PORT = 4;
     public static final int CARGO_LIFT_SENSOR_PORT = 3;
    
    //PCM ports
    public static final int RAISE_CENTERING_HATCH = 1;
    public static final int LOWER_CENTERING_HATCH = 2;
    public static final int ADVANCE_CARGO_HATCH_DELVERY = 3; //1.0
    //public static final int RETURN_CARGO_HATCH_DELIVERY = 3;
    public static final int VACUUM_ON = 0;
    public static final int OPEN_HATCH_CLAMP = 1; //pcm 1
    public static final int RAISE_HATCH_VACUUM_ARM = 4; //5?
    public static final int LOWER_HATCH_VACUUM_ARM = 5; //4?
    
    public static final int SHIFT_HIGH_SPEED = 6;
    public static final int SHIFT_LOW_SPEED = 7;

    public static final int RING_LIGHT = 7; //pcm 1

    //PID Constants
    /**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	public static final int PID_SLOT = 0;

	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int PID_LOOP = 0;

	/**
	 * Set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails. 
     * in milliseconds
	 */
    public static final int PID_TIMEOUT = 0;

    public static final double LIFT_F_VALUE = 1;
    public static final double LIFT_P_VALUE = .01;
    public static final double LIFT_I_VALUE = 0;
    public static final double LIFT_D_VALUE = 0;

    //lift slowdown thresholds
    public static final int LIFT_LOWER_SPEED_ENCODER_THRESHOLD = 40000;
    public static final int LIFT_UPPER_SPEED_ENCODER_THRESHOLD = 15000;
    public static final double LIFT_SLOW_MODIFIER = .5;
    public static final double LIFT_NORMAL_MODIFIER = 1;

    //motor speeds
    public static final double STOP_MOTOR_SPEED = 0.0;
    public static final double HALF_MOTOR_SPEED = 0.45;
    public static final double MAX_MOTOR_SPEED = 1;
    public static final double LIFT_MAX_MOTOR_SPEED = 1;

    //autoshift thresholds
    public static final double SHIFT_TURN_THRESHOLD = 100;
    public static final double SHIFT_UP_THRESHOLD = 250;
    public static final double SHIFT_DOWN_THRESHOLD = 230;
    public static final double SHIFT_TIME_THRESHOLD = .5;
    
    //arm thresholds
    public static final double ARM_DOWN_POSITION_THRESHOLD = .3;
    public static final double ARM_POTENTIOMETER_MAX = 0.5;
    public static final double ARM_POTENTIOMETER_MIN = 0;
    public static final double ARM_INTAKE_STOP_DELAY_TIME = .25;
    
    //Limiters
    //TODO: Actually define climb amp limit and timeout
    public static final double MAX_LIFT_SPEED = 0.0;
    public static final int CLIMB_AMP_LIMIT = 40;
    public static final int CLIMB_TIMEOUT = 500;
    
    //set elevator hold speed
    public static final double ELEVATOR_HOLD_SPEED = .1;
    //Misc
    public static final int LIFT_LEVEL_1 = 200;
    public static final int LIFT_LEVEL_2 = 28000;
    public static final int LIFT_LEVEL_3 = 54000; 

    public static final double MAX_CLIMB_SPEED = 0.9;
    public static final double MIN_CLIMB_SPEED = -0.9;

    //Sensor Ports
    public static final int LIFT_LOWERED_LIMIT_SWITCH = 0;
    public static final int HATCH_PRESENT_PORT = 1;
    public static final int CARGO_PRESENT_ARM = 2;
    public static final int CARGO_PRESENT_LIFT = 3;
    //Limit Switch Constants
    public static final com.ctre.phoenix.motorcontrol.FeedbackDevice QUAD_ENCODER = com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder;
    public static final int MAX_FORWARD_LIFT_LIMIT = 1024;
    public static final int MAX_REVERSE_LIFT_LIMIT = -1024;
    public static final boolean FORWARD_LIMIT_ENABLED = false;
    public static final boolean REVERSE_LIMIT_ENABLED = false;
    public static final boolean LIFT_MOTOR_PHASE = false;

}