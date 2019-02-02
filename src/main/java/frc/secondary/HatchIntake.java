package frc.secondary;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Actuators;

public class HatchIntake {
    // private static boolean previousCentering;
    // private static boolean previousSuction;
    // private static boolean previousSuctionArms;
    // private static boolean previousSpear;
    // private static boolean 

    // public static void init(){
    //     previousCentering = false;
    //     previousSuction = false;
    //     previousSuctionArms = false;
    //     previousSpear = false;

    // }

    public static void hatchIntake(boolean centering, boolean suction, boolean suctionArms, boolean spear){
       
        //Centering arms lowing/raising 
        if(centering == true && Actuators.getCenterHatch().get() == Value.kForward){
            Actuators.getCenterHatch().set(Value.kReverse);
        }
        if(centering == true && Actuators.getCenterHatch().get() == Value.kReverse){
            Actuators.getCenterHatch().set(Value.kForward);
        }
       
        // on, off for suction
        if(suction == true && Actuators.getVacuum().get() == false){
            Actuators.getVacuum().set(true);
        }
        if(suction == true && Actuators.getVacuum().get() == true){
            Actuators.getVacuum().set(false);
        }

        //suction arms lowing/raising
        if(suctionArms == true && Actuators.getArmRaiseLower().get() == Value.kForward){
            Actuators.getArmRaiseLower().set(Value.kReverse);
        }
        if(suctionArms == true && Actuators.getArmRaiseLower().get() == Value.kReverse){
            Actuators.getArmRaiseLower().set(Value.kForward);
        }

        //spear clamp/release
        if(spear == true && Actuators.getHatchClampOpen().get() == true){
            Actuators.getHatchClampOpen().set(false);
        }
        if(spear == true && Actuators.getHatchClampOpen().get() == false){
            Actuators.getHatchClampOpen().set(true);
        }
    }
}