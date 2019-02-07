package frc.secondary;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Actuators;

public class HatchIntake {
    private static boolean previousCentering;
    private static boolean previousSuction;
    private static boolean previousSuctionArms;
    private static boolean previousSpear;
    private static int centeringCounter;
    private static int suctionCounter;
    private static int suctionArmsCounter;
    private static int spearCounter;

    public static void init(){
        previousCentering = false;
        previousSuction = false;
        previousSuctionArms = false;
        previousSpear = false;
        centeringCounter = 0;
        suctionCounter = 0;
        suctionArmsCounter = 0;
        spearCounter = 0;
    }

    public static void hatchIntake(boolean centering, boolean suction, boolean suctionArms, boolean spear){
        
        //Centering arms lowing/raising 
        if(centering == true && Actuators.getCenterHatch().get() == Value.kForward){
            if(previousCentering == false){
            Actuators.getCenterHatch().set(Value.kReverse);
            previousCentering = true;
            }
        }
        if(centering == true && Actuators.getCenterHatch().get() == Value.kReverse){
            if(previousCentering == false){
            Actuators.getCenterHatch().set(Value.kForward);
            previousCentering = true;
            }
        }
        //toggle functionality
        else if(previousCentering == true){
            centeringCounter++;
            if(centeringCounter == 16){
                previousCentering = false;
                centeringCounter = 0;
            }
        }
        
        // on, off for suction
        if(suction == true && Actuators.getVacuum().get() == false){
            if(previousSuction == false && suctionCounter == 0){
            Actuators.getVacuum().set(true);
            previousSuction = true;
            }
        }
        if(suction == true && Actuators.getVacuum().get() == true){
            if(previousSuction == false && suctionCounter == 0){
            Actuators.getVacuum().set(false);
            previousSuction = true;
            }
        }
        //toggle functionality
        else if(previousSuction == true){
            suctionCounter++;
            if(suctionCounter == 16){
                previousSuction = false;
                suctionCounter = 0;
            }
        }

        //suction arms lowing/raising
        if(suctionArms == true && Actuators.getArmRaiseLower().get() == Value.kForward){
            if(previousSuctionArms == false && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(Value.kReverse);
            Actuators.getCenterHatch().set(Value.kReverse);
            Actuators.getHatchClampOpen().set(false);
            previousSuctionArms = true;
            previousCentering = true;
            }
        }
        if(suctionArms == true && Actuators.getArmRaiseLower().get() == Value.kReverse){
            if(previousSuctionArms == false && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(Value.kForward);
            Actuators.getVacuum().set(true);
            previousSuctionArms = true;
            }
        }
        //toggle functionality
        else if(previousSuctionArms == true){
            suctionArmsCounter++;
            if(suctionArmsCounter == 16){
                previousSuctionArms = false;
                suctionArmsCounter = 0;
            }
        }

        //spear clamp/release
        if(spear == true && Actuators.getHatchClampOpen().get() == true){
            if(previousSpear == false && spearCounter == 0){
            Actuators.getHatchClampOpen().set(false);
            previousSpear = true;
            }
        }
        if(spear == true && Actuators.getHatchClampOpen().get() == false){
            if(previousSpear== false && spearCounter == 0){
            Actuators.getHatchClampOpen().set(true);
            previousSpear = true;
            }
        }
        //toggle functionality
        else if(previousSpear == true){
            spearCounter++;
            if(spearCounter == 16){
                previousSpear = false;
                spearCounter = 0;
            }
        }
    }
}