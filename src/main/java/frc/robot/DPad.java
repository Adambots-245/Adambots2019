package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class DPad extends Button {
    // private DPad dpadObj;

    private int direction;

    // if no parameters are given, this method creates a DPad object
    public DPad() {
        // dpadObj = new DPad();
    }

    // creates a new DPad object
    public DPad(Joystick joy, int port, int direction) {
        // dpadObj = new DPad(joy, port, direction);
        this.port = port;
        this.joy = joy;
        this.direction = direction;
        last = false;
        presses = 0;
    }

    // stores a boolean value for if the dpad is pressed
    @Override
    public void update() {
        int DPadValue = joy.getPOV(port);
        store = (DPadValue == direction);
        isToggled();
        // System.out.println(direction + ", " + DPadValue + ", " + store);
    }
}