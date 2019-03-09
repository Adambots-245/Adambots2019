package frc.secondary;

import frc.robot.*;
//import frc.secondary.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class AutomatedVision{

    //should instantiate version of network table on robot and then instantiate the ange entry 
    //as an object
    private static double angleConstant;
    private static double minAngle = -10;
    private static double maxAngle = 10;
    private static double totalAngle = 27;
    private static double returnedError;
    private static double returnedAngle;
	private static Integer returnedDistance;
	private static Double returnedWidth;

    // add initial variable to stop or start processing
    public static void getNetValues(){

        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("/vision/datatable");

        NetworkTableEntry pipe = table.getEntry("values");
        //System.out.println("Pipe:" + pipe.getString(""));

        /*angle = table.getEntry("angle");
        error = table.getEntry("error");
        double returnedAngle = angle.getDouble(0.0);
        double returnedError = error.getDouble(0.0);
        */
        String str = pipe.getString(""); 
        String [] arrOfStr = str.split(":"); 
    
        for(String a:arrOfStr){ 
            String [] keyValuePair = a.split("=");
            
            switch (keyValuePair[0]){
                case "angle":
                    returnedAngle = Double.valueOf(keyValuePair[1]);
                    break;
                case "distance":
                    returnedDistance = Integer.valueOf(keyValuePair[1]);
                    break;
                case "width":
                    returnedWidth = Double.valueOf(keyValuePair[1]);
                    break;
                case "error":
                    returnedError = Double.valueOf(keyValuePair[1]);
            }

        }

        //System.out.println("Angle: " + returnedAngle);
    }

    public static void init(){
        NetworkTableInstance instance = NetworkTableInstance.getDefault();
        NetworkTable table = instance.getTable("default");
        
    }

    public static void track(){
        //add actual angle value
        // call actual button to begin process
        // && !Gamepad.primary.getA().get()
        if(Gamepad.primary.getB().get() && returnedAngle != 90){
            System.out.println("WERE HERE");
            System.out.println(returnedAngle);
            //while((){
            Drive.autonMotor(returnedError);
            //}
            
           
            }
                /*else if(returnedAngle < minAngle){
                    Drive.tankDrive(-Constants.MAX_MOTOR_SPEED/2, returnedError, false, false);
                    System.out.println("got 6");
                    System.out.println(returnedAngle);
                }
                else if(returnedAngle > maxAngle){
                    Drive.tankDrive(-Constants.MAX_MOTOR_SPEED/2, -returnedError, false, false);
                    System.out.println("got 7");
                    System.out.println(returnedAngle);
                }*/


            }
        
    }
