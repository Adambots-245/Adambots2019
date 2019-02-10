package frc.secondary;

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

    public static void hatchIntake(boolean centering, boolean suctionArms, boolean suction, boolean spear){
        
        //Centering arms lowing/raising 
        if(centering && Actuators.getCenterHatch().get() == true){
            if(previousCentering == false){
            Actuators.getCenterHatch().set(false);
            previousCentering = true;
            }
        }
        if(centering && Actuators.getCenterHatch().get() == false){
            if(!previousCentering){
            Actuators.getCenterHatch().set(true);
            previousCentering = true;
            }
        }
        //toggle functionality
        else if(previousCentering){
            centeringCounter++;
            if(centeringCounter == 16){
                previousCentering = false;
                centeringCounter = 0;
            }
        }
        
        // on, off for suction
        if(suction && !Actuators.getVacuum().get()){
            if(previousSuction == false && suctionCounter == 0){
            Actuators.getVacuum().set(true);
            previousSuction = true;
            }
        }
        if(suction && Actuators.getVacuum().get()){
            if(previousSuction == false && suctionCounter == 0){
            Actuators.getVacuum().set(false);
            previousSuction = true;
            }
        }
        //toggle functionality
        else if(previousSuction){
            suctionCounter++;
            if(suctionCounter == 16){
                previousSuction = false;
                suctionCounter = 0;
            }
        }

        //suction arms lowing/raising
        if(suctionArms && Actuators.getArmRaiseLower().get() == true){
            if(!previousSuctionArms && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(false);
            Actuators.getCenterHatch().set(false);
            Actuators.getHatchClampOpen().set(false);
            previousSuctionArms = true;
            previousCentering = true;
            }
        }
        if(suctionArms && Actuators.getArmRaiseLower().get() == false){
            if(!previousSuctionArms && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(true);
            Actuators.getVacuum().set(true);
            previousSuctionArms = true;
            }
        }
        //toggle functionality
        else if(previousSuctionArms){
            suctionArmsCounter++;
            if(suctionArmsCounter == 16){
                previousSuctionArms = false;
                suctionArmsCounter = 0;
            }
        }
    
        //spear clamp/release
        if(spear && Actuators.getHatchClampOpen().get()){
            if(!previousSpear && spearCounter == 0){
            Actuators.getHatchClampOpen().set(false);
            previousSpear = true;
            }
        }
        if(spear && !Actuators.getHatchClampOpen().get()){
            if(!previousSpear && spearCounter == 0){
            Actuators.getHatchClampOpen().set(true);
            previousSpear = true;
            }
        }
        //toggle functionality
        else if(previousSpear){
            spearCounter++;
            if(spearCounter == 16){
                previousSpear = false;
                spearCounter = 0;
            }
        }
    }
}