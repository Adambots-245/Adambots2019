package frc.secondary;

import frc.robot.Actuators;
import edu.wpi.first.wpilibj.Timer;

public class HatchAutomation {

    private static Timer timer = new Timer();
    public static void init(){
        timer.start();
    }
    public static void timedFloorIntake(int intakeToggles){
        if (intakeToggles % 2 == 1){
            //logic to start/cut sequence
            //at the end of the sequence, reset presses so it doesn't loop 
        }
    }
    public static void cycleFloorIntake(boolean isToggled, int intakeToggles){
        if (isToggled){
            // logic to increment stage with presses
            // and call the setIntake method here, not outside of the if so it isn't called everytime this method is called
        }
    }
    public static void timedWallIntake(int intakeToggles){
        if (intakeToggles % 2 == 1){
            //logic to start/cut sequence
            //at the end of the sequence, reset presses so it doesn't loop 
        }
    }
    public static void cycleWallIntake(boolean isToggled, int intakeToggles){
        if (isToggled){
            // logic to increment stage with presses
            // and call the setIntake method here, not outside of the if so it isn't called everytime this method is called
        }
    }
    
    public static void timedOuttake(int intakeToggles){
        if (intakeToggles % 2 == 1){
            //logic to start/cut sequence
            //at the end of the sequence, reset presses so it doesn't loop 
        }
    }
    public static void cycleOuttake(boolean isToggled, int intakeToggles){
        if (isToggled){
            // logic to increment stage with presses
            // and call the setIntake method here, not outside of the if so it isn't called everytime this method is called
        }
    }
    public static void setHatchFloorIntakeState(int state){
        switch(state){
            case 0:
            // return to normal state (arms up, vacuum off, unclamp) 
            break;
            case 1:
            // ca down, elevator down
            break;
            case 2:
            // sa down, v on, unclamp
            break;
            case 3:
            // sa up, ca up
            break;
            case 4:
            // spear clamp
            break;
            case 5:
            // v off
            break;
        }
        
    } 
    public static void setHatchWallIntakeState(int state){
        switch (state){
            case 0:
            // change nothing
            break;
            case 1:
            // unclamp
            break;
            case 2:
            // spear out
            break;
            case 3:
            // clamp
            break;
            case 4:
            // spear in
            break;
        }
    }
    public static void setHatchOuttake(int state){
        switch (state){
            case 0:
            // spear out
            break;
            case 1:
            // unclamp
            break;
            case 2:
            // spear in
            break;
        }
    }
}