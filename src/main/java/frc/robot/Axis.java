package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Axis {
    private Axis axisObj;

    private int port;
    private Joystick joy;
    private double store;
    private boolean last;
    private int presses;
    private boolean isPressed;

    //if no parameters are given, this method creates an Axis object
    public Axis(){
        axisObj = new Axis();
    }
    //creates a new Axis object
    public Axis(Joystick joy, int port){
        axisObj = new Axis(joy, port);
        this.port = port;
        this.joy = joy;
        last = false;
        presses = 0;
    }
    //stores the double value of the Axis and stores boolean isPressed for presses and toggles 
    public void update(){
        store = joy.getRawAxis(port);
        if (Math.abs(store) > .05){
            isPressed = true;
        }
        else{
            isPressed = false;
        }
    }
    //returns double value of the axis
    public double get(){
        return store;
    }
    //stores the current isPressed to last for toggle 
    public void updateLast(){
        last = isPressed;
        //System.out.println(last);
    }
    //checks if the isPressed state goes from unpressed to pressed (meaning the button has been toggled)
    public boolean isToggled(){
        boolean toggled = false;
        if (!last && isPressed){
            toggled = true;
            presses ++;
        }
        return toggled;
    }
    //resets the total # of presses to 0 if needed
    public void resetPresses(){
        presses = 0;
    }
    //returns the total # of presses
    public int getPresses(){
        return presses;
    }
}