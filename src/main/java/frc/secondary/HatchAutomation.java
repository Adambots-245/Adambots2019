package frc.secondary;

//import frc.robot.Actuators;
import frc.robot.Button;
//import frc.robot.Sensors;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class HatchAutomation {

    private static Timer timer = new Timer();
    private static int floorIntakeState;
    private static int wallIntakeState;
    private static int outtakeState;
    private static int spearIntakeState;
    

    public static void init() {
        timer.start();
        resetAll();
    }

    /*public static boolean toggle(Boolean btn){
        

    }*/
    public static void resetAll() {
        HatchIntake.centeringArms(false);
        HatchIntake.clamp(false);
        HatchIntake.spear(false);
        HatchIntake.suctionArms(false);
        HatchIntake.vacuum(false);
    }
    public static void timedHatch(Button floorIntakeButton, Button wallIntakeButton, Button outtakeButton){

    }
    public static void cycleHatch(Button floorIntakeButton, Button wallIntakeButton, Button spearButton){
        if (floorIntakeButton.isToggled()) {
            wallIntakeState = 0;
            spearIntakeState = 0;
            floorIntakeState++;
            if (floorIntakeState == 5){
                floorIntakeState = 1;
                
            }
            cycleFloorIntake(false);
        }
        if (wallIntakeButton.isToggled()) {
            floorIntakeState = 0;
            spearIntakeState = 0;
            wallIntakeState++;
            if (wallIntakeState == 3){
                wallIntakeState = 1;
            }
            cycleWallIntake(false);
        }
        if (spearButton.isToggled()) {
            floorIntakeState = 0;
            wallIntakeState = 0;
            spearIntakeState++;
            if (spearIntakeState == 3){
                spearIntakeState = 1;
            }
            setSpearState(false);
        } 
    }
    public static int getFloorState(){
        return floorIntakeState;
    }
    public static int getClampState(){
        return wallIntakeState;
    }
    public static int getSpearState(){
        return spearIntakeState;
    }
    public static void timedFloorIntake(Button intakeToggleButton) {

        if (intakeToggleButton.getPresses() % 2 == 1) {
            if (intakeToggleButton.isToggled()) {
                setHatchFloorIntakeState(true);
                timer.reset();
            }
            /*
             * if (time < stageOneStopTime) {goto stage one}
             * else if ()
             */
        }

    }

    public static void toggleSpear(int presses) {
        boolean pos = false;
        if (presses % 2 == 1) {
            pos = true;
        }
        if (Math.abs(Elevator.getLiftSpeed()) > 0.1){
            pos = false;
        }
        HatchIntake.spear(pos);
    }

    public static void toggleClamp(int presses){
        boolean pos = false;
        if (presses % 2 == 1) {
            pos = true;
        }
        HatchIntake.clamp(pos);
    }

    public static void cycleFloorIntake(boolean isToggled) {
        setHatchFloorIntakeState(isToggled);
    }

    public static void timedWallIntake(Button intakeToggleButton) {
        if (intakeToggleButton.getPresses() % 2 == 1) {
            // logic to start/cut sequence
            // at the end of the sequence, reset presses so it doesn't loop
        }
    }

    public static void cycleWallIntake(boolean isToggled) {
        setHatchWallIntakeState(isToggled);
    }

    public static void timedOuttake(Button intakeToggleButton) {
        if (intakeToggleButton.getPresses() % 2 == 1) {
            // logic to start/cut sequence
            // at the end of the sequence, reset presses so it doesn't loop
        }
    }

    public static void cycleOuttake(boolean isToggled) {
        setHatchOuttake(isToggled);
    }
    public static void setHatchFloorIntakeState(boolean toggleState) {
        System.out.println("floor state is " + floorIntakeState + " Timer is " + timer.get());
        switch (floorIntakeState) {
        case 0:
            // do nothing
            if (toggleState || timer.get() > 2.0) {
              floorIntakeState++;
              timer.reset();
             }
        break;
        case 1:
            // return to normal state (arms up, vacuum off, unclamp)
            HatchIntake.centeringArms(true);
            HatchIntake.vacuum(false);
            HatchIntake.clamp(true);
            HatchIntake.spear(false);
            // next state
            if (toggleState || timer.get() > 2.0) {
                floorIntakeState++;
                timer.reset();
                }
            break;
        /*case 2:
            // ca down, elevator down
            HatchIntake.centeringArms(true);
            //elevator down

            // next state
            /*if (Sensors.getDIValue(Sensors.getHatchPresent())) {
                floorIntakeState++;
                timer.reset();
            } else if (toggleState || timer.get() > 2.0) {
                floorIntakeState++;
                timer.reset();
                timer.start();
            }
            break;
            */
        case 2:
            // sa down, v on, unclamp
            HatchIntake.suctionArms(true);
            HatchIntake.vacuum(true);
            HatchIntake.clamp(true);
            if (toggleState || timer.get() > 2.0) {
                floorIntakeState++;
                timer.reset();
             //   timer.start();
            }
            break;
        case 3:
            // sa up, ca up
            HatchIntake.suctionArms(false);
            HatchIntake.centeringArms(false);

            if (toggleState || timer.get() > 2.0) {
                floorIntakeState++;
                timer.reset();
                }
            break;
        case 4:
            // spear clamp
            HatchIntake.clamp(false);
            HatchIntake.vacuum(false);
            if (toggleState) {
                floorIntakeState = 0;
            }
            break;
        }
            /* if (toggleState || timer.get() > 2.0) {
                floorIntakeState++;
                timer.reset();
                }
            break; */
        /*case 5:
            // v off
            HatchIntake.vacuum(false);
            if (toggleState) {
                floorIntakeState = 0;
            }
            break;
        } */

    }
    public static void setSpearState(boolean toggleState) {

        switch (spearIntakeState) {
            case 0:
                // do nothing
                if (toggleState) {
                    spearIntakeState++;
                }
                break;
                case 1:
                HatchIntake.vacuum(false);
                HatchIntake.spear(true);
                if (toggleState) {
                    spearIntakeState++;
                }
                break;
                case 2:
                HatchIntake.vacuum(false);
                HatchIntake.spear(false);
                if (toggleState) {
                    spearIntakeState = 1;
                }
            
                break;}
        
    }

    public static void setHatchWallIntakeState(boolean toggleState) {
        System.out.println("wall state is " + wallIntakeState);
        switch (wallIntakeState) {
        case 0:
            // do nothing
            if (toggleState) {
                wallIntakeState++;
            }
            break;
        case 1:
            // unclamp
            HatchIntake.vacuum(false);
            HatchIntake.clamp(true);
            if (toggleState) {
                wallIntakeState++;
            }
            break;
        /*case 2:
            // spear out
            HatchIntake.spear(true);
            if (toggleState) {
                wallIntakeState++;
            }
            break;*/
        case 2:
            // clamp
            HatchIntake.vacuum(false);
            HatchIntake.clamp(false);
            if (toggleState) {
                wallIntakeState = 1;
            }
            break;/*
        case 4:
            // spear in
            HatchIntake.clamp(false);
            HatchIntake.spear(false);
            if (toggleState) {
                wallIntakeState = 0;
            }
            break;*/
        }
    }

    public static void setHatchOuttake(boolean toggleState) {
        System.out.println("outtake state is " + outtakeState);
        switch (outtakeState) {
        case 0:
            // do nothing
            if (toggleState) {
                outtakeState++;
            }
            break;
        case 1:
            // spear out
            HatchIntake.spear(true);
            if (toggleState) {
                outtakeState++;
            }
            break;
        case 2:
            // unclamp
            HatchIntake.clamp(true);
            if (toggleState) {
                outtakeState++;
            }
            break;
        case 3:
            // spear in
            HatchIntake.spear(false);
            if (toggleState) {
                outtakeState = 0;
            }
            break;
        }
    }
}