/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.secondary.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    Gamepad.init();
    Actuators.init();
    Sensors.init();
    Elevator.init();
    Dash.init();
    //AutomatedVision.init();
    //AutomatedVision.getNetValues();
    //m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    //m_chooser.addOption("My Auto", kCustomAuto);
    //SmartDashboard.putData("Auto choices", m_chooser);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
      Dash.dash();
      Elevator.resetEncoderOnLimitSwitch();
  }


  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the\ switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    HatchIntake.centeringArms(false);
    HatchIntake.clamp(false);
    HatchIntake.spear(false);
    HatchIntake.suctionArms(false);
    HatchIntake.vacuum(false);
    
    //m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    //System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This is a function for all the robot controlls
   */
  public void controls() {
    Gamepad.primary.update();
    Gamepad.secondary.update();
    Actuators.getRingLight().set(true);
    // primary controls
    Drive.drive(Gamepad.primary.getLeftY().get(), Gamepad.primary.getRightX().get(), Gamepad.primary.getA().get(),
        Gamepad.primary.getY().get(), Gamepad.primary.getStart().getPresses());
    // Climb.climb(Gamepad.primary.getBack().getPresses(),  
    // Gamepad.primary.getLeftY().get(), Gamepad.primary.getRightY().get(),
    // Gamepad.primary.getLeftTrigger().get(),
    // Gamepad.primary.getRightTrigger().get());

    // secondary controls
    Elevator.elevator((Gamepad.secondary.getLeftY()), Gamepad.secondary.getTriggers(), Gamepad.secondary.getBack().get(), Gamepad.secondary.getLB().get(), Gamepad.secondary.getRB().get());
    Cargo.cargo(Gamepad.primary.getStart().getPresses(), Gamepad.secondary.getTriggers(),
        Gamepad.secondary.getRightY().get(), (boolean)Sensors.getCargoPresentLift().get(), Gamepad.secondary.getB().get());
    // HatchIntake.centeringArms(Gamepad.secondary.getDPadN().get());
    // HatchIntake.suctionArms(Gamepad.secondary.getDPadE().get());
    // HatchIntake.vacuum(Gamepad.secondary.getDPadS().get());
    //HatchAutomation.spearToggle(Gamepad.secondary.getX().getPresses());
    //HatchAutomation.clampToggle(Gamepad.secondary.getY().getPresses());
    // HatchAutomation.cycleHatch(Gamepad.secondary.getDPadN(),
    // Gamepad.secondary.getDPadE(), Gamepad.secondary.getDPadS());
    HatchAutomation.cycleHatch(Gamepad.secondary.getA(), Gamepad.secondary.getX(), Gamepad.secondary.getY());
    Gamepad.primary.updateLast();
    Gamepad.secondary.updateLast();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    /*switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }*/
    controls();
    AutomatedVision.getNetValues();
    AutomatedVision.track();
  }
  
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    controls();
    AutomatedVision.getNetValues();
    AutomatedVision.track();
  }
 
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    Gamepad.primary.update();
    Gamepad.secondary.update();

    ToggleDrive.toggleDrive(Gamepad.primary.getA().getPresses());
    
    Gamepad.primary.updateLast();
    Gamepad.secondary.updateLast();
  }
}
