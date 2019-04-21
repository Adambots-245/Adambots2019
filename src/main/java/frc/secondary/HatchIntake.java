package frc.secondary;

import frc.robot.Actuators;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class HatchIntake {
    /* 
    private static DoubleSolenoid.Value previousCentering;
    private static boolean previousSuction;
    private static DoubleSolenoid.Value previousSuctionArms;
    private static boolean previousSpear;
    private static int centeringCounter;
    private static int suctionCounter;
    private static int suctionArmsCounter;
    private static int spearCounter;
    */
    //private static boolean vacuumState;
    private static boolean spearState;
    private static boolean clampState;
    
    public static void init() {

    }

    // public static void centeringArms(boolean pos) {
    //     if (!pos) {
    //         Actuators.getCenterHatch().set(Value.kForward);
    //     } else {
    //         Actuators.getCenterHatch().set(Value.kReverse);
    //     }
    // }

    // public static void suctionArms(boolean pos) {
    //     if (pos) {
    //         Actuators.getArmRaiseLower().set(Value.kForward);
    //     } else {
    //         Actuators.getArmRaiseLower().set(Value.kReverse);
    //     }
    // }

    // public static void vacuum(boolean pos) {
    //     Actuators.getVacuum().set(pos);
    //     vacuumState = pos;
    // }

    public static void spear(boolean pos) {
        Actuators.getSpearExtend().set(pos);
        spearState = pos;
    }

    public static void clamp(boolean pos) {
        Actuators.getHatchClampOpen().set(pos);
        clampState = pos;
    }
    public static boolean spearState(){
        return spearState;
    }
    public static boolean clampState(){
        return clampState;
    }
    // public static boolean vacuumState(){
    //     return vacuumState;
    // }
    
//    public static void hatchIntake(boolean centering, boolean suctionArms, boolean suction, boolean spear){

        /*
        //Centering arms lowing/raising 
        if(centering && Actuators.getCenterHatch().get() == DoubleSolenoid.Value.kForward){
            if(previousCentering == DoubleSolenoid.Value.kReverse){
            Actuators.getCenterHatch().set(DoubleSolenoid.Value.kReverse);
            previousCentering = DoubleSolenoid.Value.kForward;
            }
        }
        if(centering && Actuators.getCenterHatch().get() == DoubleSolenoid.Value.kReverse){
            if(previousCentering == DoubleSolenoid.Value.kReverse){
            Actuators.getCenterHatch().set(DoubleSolenoid.Value.kForward);
            previousCentering = DoubleSolenoid.Value.kForward;
            }
        }
        //toggle functionality
        else if(previousCentering == DoubleSolenoid.Value.kForward){
            centeringCounter++;
            if(centeringCounter == 16){
                previousCentering = DoubleSolenoid.Value.kReverse;
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
        if(suctionArms && Actuators.getArmRaiseLower().get() == DoubleSolenoid.Value.kForward){
            if(previousSuctionArms == DoubleSolenoid.Value.kReverse && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(DoubleSolenoid.Value.kReverse);
            Actuators.getCenterHatch().set(DoubleSolenoid.Value.kReverse);
            Actuators.getHatchClampOpen().set(false);
            previousSuctionArms = DoubleSolenoid.Value.kForward;
            previousCentering = DoubleSolenoid.Value.kForward;
            }
        }
        if(suctionArms && Actuators.getArmRaiseLower().get() == DoubleSolenoid.Value.kReverse){
            if(previousSuctionArms == DoubleSolenoid.Value.kReverse && suctionArmsCounter == 0){
            Actuators.getArmRaiseLower().set(DoubleSolenoid.Value.kForward);
            Actuators.getVacuum().set(true);
            previousSuctionArms = DoubleSolenoid.Value.kForward;
            }
        }
        //toggle functionality
        else if(previousSuctionArms == DoubleSolenoid.Value.kForward){
            suctionArmsCounter++;
            if(suctionArmsCounter == 16){
                previousSuctionArms = DoubleSolenoid.Value.kReverse;
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
        }*/
//    }
}