package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;

public class Gamepad {
	private Joystick joy;
	private Button[] buttonArray = new Button[11];
	private Axis[] axisArray = new Axis[6];
	private DPad[] dpadArray = new DPad[8];

	// private Button A;
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
	 * XBOX 360 Left Stick Click Button
	 */
	private static final int BUTTON_LEFT_STICK = 9;
	/**
	 * XBOX 360 Right Stick Click Button
	 */
	private static final int BUTTON_RIGHT_STICK = 10;

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

	// the ID/port for the whole DPad
	// POV returns an angle in degrees 0-315 at 45 intervals
	private static final int AXIS_DPAD_POV = 0;

	// all dpadAarray positions
	// N is north/up, W is west/left, etc.
	private static final int DPAD_N_POV_PORT = 0;
	private static final int DPAD_NE_POV_PORT = 1;
	private static final int DPAD_E_POV_PORT = 2;
	private static final int DPAD_SE_POV_PORT = 3;
	private static final int DPAD_S_POV_PORT = 4;
	private static final int DPAD_SW_POV_PORT = 5;
	private static final int DPAD_W_POV_PORT = 6;
	private static final int DPAD_NW_POV_PORT = 7;

	// Control Instances
	public static Gamepad primary;
	public static Gamepad secondary;
	public static Gamepad virtualPrimary;
	public static Gamepad virtualSecondary;

	// Constructor
	/**
	 * Creates new Joystick instance on the correct driver port.
	 *
	 * @param port The joystick port number.
	 */
	private Gamepad(int port) {
		joy = new Joystick(port);
		buttonArray[0] = new Button(); // creating null button for 0th index in buttonArray
		for (int i = 1; i <= buttonArray.length - 1; i++) {
			buttonArray[i] = new Button(joy, i);
		}
		for (int i = 0; i <= axisArray.length - 1; i++) {
			axisArray[i] = new Axis(joy, i);
		}
		for (int i = 0; i <= dpadArray.length - 1; i++) {
			dpadArray[i] = new DPad(joy, AXIS_DPAD_POV, i * 45);
		}
	}

	// initializes the primary and secondary drivers
	public static void init() {
		primary = new Gamepad(PRIMARY_DRIVER);
		secondary = new Gamepad(SECONDARY_DRIVER);

	}

	// updates every button and trigger value ('store' variable in each object
	// class)
	public void update() {
		for (int i = 1; i <= buttonArray.length - 1; i++) {
			buttonArray[i].update();
		}
		for (int i = 0; i <= axisArray.length - 1; i++) {
			axisArray[i].update();
		}
		for (int i = 0; i <= dpadArray.length - 1; i++) {
			dpadArray[i].update();
		}

	}

	public void update(double[] inputs, boolean primary) {
		int offset = 0;
		if (!primary) offset = Constants.SECONDARY_OFFSET;
		
		for (int i = 1; i < buttonArray.length; i++) {
			buttonArray[i].update(inputs[i + Constants.BUTTON_START_INDEX + offset]);
		}
		for (int i = 0; i < axisArray.length; i++) {
			axisArray[i].update(inputs[i + Constants.AXIS_START_INDEX + offset]);
		}
		for (int i = 0; i < dpadArray.length; i++) {
			dpadArray[i].update(inputs[i + Constants.DPAD_START_INDEX + offset]);
		}

	}

	public void updateLast() {
		for (int i = 1; i <= buttonArray.length - 1; i++) {
			buttonArray[i].updateLast();
		}
		for (int i = 0; i <= axisArray.length - 1; i++) {
			axisArray[i].updateLast();
		}
		for (int i = 0; i <= dpadArray.length - 1; i++) {
			dpadArray[i].updateLast();
		}
	}

	// deadzoning
	protected static double deaden(double u) {
		return Math.abs(u) < .15 ? 0 : u;
	}

	// getting joystick values
	public double getTriggers() {
		return deaden(getLeftTrigger().get() - getRightTrigger().get());
	}

	public Axis getLeftTrigger() {
		return axisArray[LEFT_AXIS_TRIGGERS];
	}

	public Axis getRightTrigger() {
		return axisArray[RIGHT_AXIS_TRIGGERS];
	}

	public Axis getLeftX() {
		return axisArray[AXIS_LEFT_X];
	}

	public Axis getLeftY() {
		return axisArray[AXIS_LEFT_Y];
	}

	public Axis getRightX() {
		return axisArray[AXIS_RIGHT_X];
	}

	public Axis getRightY() {
		return axisArray[AXIS_RIGHT_Y];
	}

	// Button getters
	public Button getLB() {
		return buttonArray[BUTTON_LB];
	}

	public Button getRB() {
		return buttonArray[BUTTON_RB];
	}

	public Button getA() {
		return buttonArray[BUTTON_A];
	}

	public Button getB() {
		return buttonArray[BUTTON_B];
	}

	public Button getX() {
		return buttonArray[BUTTON_X];
	}

	public Button getY() {
		return buttonArray[BUTTON_Y];
	}

	public Button getStart() {
		return buttonArray[BUTTON_START];
	}

	public Button getBack() {
		return buttonArray[BUTTON_BACK];
	}

	public Button getLeftStickButton(){
		return buttonArray[BUTTON_LEFT_STICK];
	}

	public Button getRightStickButton(){
		return buttonArray[BUTTON_RIGHT_STICK];
	}

	// DPad getters
	public DPad getDPadN() {
		return dpadArray[DPAD_N_POV_PORT];
	}

	public DPad getDPadNE() {
		return dpadArray[DPAD_NE_POV_PORT];
	}

	public DPad getDPadE() {
		return dpadArray[DPAD_E_POV_PORT];
	}

	public DPad getDPadSE() {
		return dpadArray[DPAD_SE_POV_PORT];
	}

	public DPad getDPadS() {
		return dpadArray[DPAD_S_POV_PORT];
	}

	public DPad getDPadSW() {
		return dpadArray[DPAD_SW_POV_PORT];
	}

	public DPad getDPadW() {
		return dpadArray[DPAD_W_POV_PORT];
	}

	public DPad getDPadNW() {
		return dpadArray[DPAD_NW_POV_PORT];
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