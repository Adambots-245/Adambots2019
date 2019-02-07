package frc.secondary;

import frc.robot.Actuators;
import edu.wpi.first.wpilibj.Timer;

public class HatchAutomation {

    private static Timer timer = new Timer();
    public static void init(){
        timer.start();
    }

    /*private enum State {
        s_ARMS_UP;
        S_CENT_ARM_DOWN;
    }
    public static void setArmsPosition(int currentState) {
		switch (currentState) {
            case 1:
                if (Actuators.getArmRaiseLower(true)){
                    Actuators.getCenterHatch().set(true);
                    //newState(State.S_2);
                }
                break;
                
            case S_2 :
                if (Actuators.getCenterHatch(true)) {
                    Actuators.getVacuum().set(true);
                    //newState.();
                }
                break;
                
            case 3:
                if (Actuators.getVacuum(true)) {
                    
                }
                break;
            }

            case 4:
                if (Actuators.getArmRaiseLower(false) && timer.get() > 1) {

                }
                break;
	} */
}