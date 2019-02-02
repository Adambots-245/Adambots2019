package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Button {
    private Button buttonObj;

    private int port;
    private Joystick joy;
    private boolean store;
    private boolean last;

    public Button(){
        buttonObj = new Button();
    }

    public Button(Joystick joy, int port){
        buttonObj = new Button(joy, port);
        this.port = port;
        this.joy = joy;
        last = false;
    }
    public void update(){
        store = joy.getRawButton(port);
    }
    public boolean get(){
        return store;
    }
    public boolean updateLast(){
        last = store;
        //System.out.println(last);
        return last;
    }
    public boolean isToggled(){
        boolean toggled = false;
        if (!last && store){
            toggled = true;
        }
        return toggled;
    }
}