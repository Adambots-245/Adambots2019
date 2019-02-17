package frc.secondary;

import frc.robot.Actuators;
import frc.robot.Button;
import frc.robot.Sensors;
import edu.wpi.first.wpilibj.Timer;

public class HatchAutomation {

    private static Timer timer = new Timer();
    private static int floorIntakeState;
    private static int wallIntakeState;
    private static int outtakeState;

    public static void init() {
        timer.start();
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
        switch (floorIntakeState) {
        case 0:
        break;
        case 1:
            // return to normal state (arms up, vacuum off, unclamp)
            // next state
            if (toggleState) {
                floorIntakeState++;
                timer.reset();
            }
            break;
        case 2:
            // ca down, elevator down
            // next state
            if (Sensors.getDIValue(Sensors.getHatchPresent())) {
                floorIntakeState++;
                timer.reset();
            } else if (toggleState) {
                floorIntakeState++;
                timer.reset();
            }
            break;
        case 3:
            // sa down, v on, unclamp
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 4:
            // sa up, ca up
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 5:
            // spear clamp
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 6:
            // v off
            if (toggleState) {
                floorIntakeState = 0;
            }
            break;
        }

    }

    public static void setHatchWallIntakeState(boolean toggleState) {
        switch (wallIntakeState) {
        case 0:
            // do nothing
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 1:
            // unclamp
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 2:
            // spear out
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 3:
            // clamp
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 4:
            // spear in
            if (toggleState) {
                floorIntakeState = 0;
            }
            break;
        }
    }

    public static void setHatchOuttake(boolean toggleState) {
        switch (outtakeState) {
        case 0:
            // do nothing
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 1:
            // spear out
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 2:
            // unclamp
            if (toggleState) {
                floorIntakeState++;
            }
            break;
        case 3:
            // spear in
            if (toggleState) {
                floorIntakeState = 0;
            }
            break;
        }
    }
}