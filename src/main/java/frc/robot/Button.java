package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Button {
    // private Button buttonObj;

    protected int port;
    protected Joystick joy;
    protected boolean store;
    protected boolean last;
    protected int presses;

    // if no parameters are given, this method creates a Button object
    public Button() {
        // buttonObj = new Button();
    }

    // creates a new Button object
    public Button(Joystick joy, int port) {
        // buttonObj = new Button(joy, port);
        this.port = port;
        this.joy = joy;
        this.last = false;
        this.presses = 0;
    }

    // stores the value of the button to boolean store
    public void update() {
        store = joy.getRawButton(port);
        isToggled();
    }

    // returns the boolean value of the button (true or false)
    public boolean get() {
        return store;
    }

    // stores last value of the button for toggle
    public void updateLast() {
        last = store;
        // System.out.println(last);
    }

    // check if the button went from unpressed to pressed (meaning the button has
    // been toggled)
    public boolean isToggled() {
        boolean toggled = false;
        if (!last && store) {
            toggled = true;
            presses++;
        }
        return toggled;
    }

    // resets the total # of presses to 0 if needed
    public void resetPresses() {
        presses = 0;
    }

    // returns the total # of presses
    public int getPresses() {
        return presses; // publish me to shuffleboard for height status
    }
}