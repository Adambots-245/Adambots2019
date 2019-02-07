package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;

public class Gamepad {
	private Joystick joy;
	//// CONSTANTS -------------------------------------------------------------
	/**
	 * Primary Driver Controller Port Number.
	 */
	private static final int PRIMARY_DRIVER = 1;
	/**
	 * Secondary Driver Controller Port Number.
	 */
	private static final int SECONDARY_DRIVER = 2;
	/**
	 * XBOX 360 South Face Button
	 */
	private static final int BUTTON_A = 1;
	/**
	 * XBOX 360 East Face Button
	 */
	private static final int BUTTON_B = 2;
	/**
	 * XBOX 360 West Face Button
	 */
	private static final int BUTTON_X = 3;
	/**
	 * XBOX 360 North Face Button
	 */
	private static final int BUTTON_Y = 4;
	/**
	 * XBOX 360 Left Bumper (Top)
	 */
	private static final int BUTTON_LB = 5;
	/**
	 * XBOX 360 Right Bumper (Top)
	 */
	private static final int BUTTON_RB = 6;
	/**
	 * XBOX 360 Back Button
	 */
	private static final int BUTTON_BACK = 7;
	/**
	 * XBOX 360 Start Button
	 */
	private static final int BUTTON_START = 8;
	/**
	 * XBOX 360 Left Horizontal Axis (Left=-1, Right=1)
	 */
	private static final int AXIS_LEFT_X = 0;
	/**
	 * XBOX 360 Left Vertical Axis (Up=1, Down=-1)
	 */
	private static final int AXIS_LEFT_Y = 1;
	/**
	 * XBOX 360 Trigger Axis (LEFT)
	 */
	public static final int LEFT_AXIS_TRIGGERS = 2;
	/**
	 * XBOX 360 Trigger Axis (RIGHT)
	 */
	public static final int RIGHT_AXIS_TRIGGERS = 3;
	/**
	 * XBOX 360 Right Horizontal Axis (Left=-1, Right=1)
	 */
	private static final int AXIS_RIGHT_X = 4;
	/**
	 * XBOX 360 Right Vertical Axis (Up=1, Down=-1)
	 */
	private static final int AXIS_RIGHT_Y = 5;
	/**
	 * XBOX 360 DPad Horizontal Axis (Left=-1, Right=1)
	 */
	private static final int AXIS_DPAD_HORIZONTAL = 6;
	/**
	 * XBOX 360 DPad Vertical Axis (Up=-1, Right=1)
	 */
	private static final int AXIS_DPAD_VERTICAL = 7;
	

	// Control Instances
	public static Gamepad primary;
	public static Gamepad secondary;

	// Constructor
	/**
	 * Creates new Joystick instance on the correct driver
	 * port.
	 *
	 * @param port
	 *            The joystick port number.
	 */
	private Gamepad(int port) {
		joy = new Joystick(port);
	}

	// initializes the primary and secondary drivers
	public static void init() {
		primary = new Gamepad(PRIMARY_DRIVER);
		secondary = new Gamepad(SECONDARY_DRIVER);
	}

	// deadzoning
	private double deaden(double u) {
		return Math.abs(u) < .15 ? 0 : u;
	}

	// getting joystick values
	public double getTriggers() {
		return deaden(joy.getRawAxis(LEFT_AXIS_TRIGGERS) - joy.getRawAxis(RIGHT_AXIS_TRIGGERS));
	}
	
	public double getLeftTrigger() {
		return deaden(joy.getRawAxis(LEFT_AXIS_TRIGGERS));
	}

	public double getRightTrigger() {
		return deaden(joy.getRawAxis(RIGHT_AXIS_TRIGGERS));
	}
	
	public double getLeftX() {
		return deaden(joy.getRawAxis(AXIS_LEFT_X));
	}

	public double getLeftY() {
		return deaden(-joy.getRawAxis(AXIS_LEFT_Y));
	}

	public double getRightX() {
		return deaden(joy.getRawAxis(AXIS_RIGHT_X));
	}

	public double getRightY() {
		return deaden(-joy.getRawAxis(AXIS_RIGHT_Y));
	}

	public boolean getLB() {
		return joy.getRawButton(BUTTON_LB);
	}

	public boolean getRB() {
		return joy.getRawButton(BUTTON_RB);
	}

	public boolean getA() {
		return joy.getRawButton(BUTTON_A);
	}

	public boolean getB() {
		return joy.getRawButton(BUTTON_B);
	}

	public boolean getX() {
		return joy.getRawButton(BUTTON_X);
	}

	public boolean getY() {
		return joy.getRawButton(BUTTON_Y);
	}

	public boolean getStart() {
		return joy.getRawButton(BUTTON_START);
	}

	public boolean getBack() {
		return joy.getRawButton(BUTTON_BACK);
	}
	
	public boolean getDPadLeft() {
		return joy.getRawAxis(AXIS_DPAD_HORIZONTAL) < -0.05;
	}

	public boolean getDPadRight() {
		return joy.getRawAxis(AXIS_DPAD_HORIZONTAL) > 0.05;
	}
	public boolean getDPadDown() {
		return joy.getRawAxis(AXIS_DPAD_VERTICAL) < -0.05;
	}

	public boolean getDPadUp() {
		return joy.getRawAxis(AXIS_DPAD_VERTICAL) > 0.05;
	}

	// Rumble
	public void rumble(double l, double r, int time) {
		long rumbleStartTime;		
		rumbleStartTime = System.currentTimeMillis();
			while (System.currentTimeMillis() - rumbleStartTime <= time) {
				joy.setRumble(RumbleType.kLeftRumble, l);
				joy.setRumble(RumbleType.kRightRumble, r);
			}
			rumbleStartTime = System.currentTimeMillis();			
			joy.setRumble(RumbleType.kLeftRumble, 0);
			joy.setRumble(RumbleType.kRightRumble, 0);
			
		}
	
}