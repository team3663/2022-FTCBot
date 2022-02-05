// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.C_AutoAlign;
import frc.robot.commands.CG_AutoTimeStraightLeft;
import frc.robot.commands.CG_AutoTimeStraightRight;
import frc.robot.commands.C_Drive;
import frc.robot.Constants.*;
import frc.robot.subsystems.SS_TankDrive;
import frc.robot.utils.XboxGamepad;
import frc.robot.drivers.Limelight;
import frc.robot.drivers.Vision;

// import edu.wpi.first.wpilibj.GenericHID;
// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.Util.XboxGamepad;
// import frc.robot.commands.ExampleCommand;
// import frc.robot.subsystems.ExampleSubsystem;
// import frc.robot.subsystems.SS_DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Get Limelight
  // public static final Limelight limeLight = Limelight.getInstance();
  // Get Vision (Limelight) 
  private static final Vision vision = new Vision();

  // Setup Driver Controller
  public static XboxGamepad driverController = new XboxGamepad(OIConstants.XBOX_DRIVER_CONTROLLER_ID, 0.1);

  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final SS_TankDrive ss_driveBase = new SS_TankDrive();
  private final Command c_AutoAlign = new C_AutoAlign(ss_driveBase);
  private final Command c_Drive = new C_Drive(ss_driveBase,
                              () -> driverController.getRawAxis(OIConstants.L_Y_AXIS),
                              () -> driverController.getRawAxis(OIConstants.R_X_AXIS)
                            );

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // set default commands for all subsystems
    // ss_driveBase.setDefaultCommand(c_Drive);
    ss_driveBase.setDefaultCommand(c_AutoAlign);

    // set up SmartDashboard options for autonomous modes
    // Setup SmartDashboard options
    m_chooser.setDefaultOption("Auto Routine Time: Straight-Left", new CG_AutoTimeStraightLeft(ss_driveBase));
    m_chooser.setDefaultOption("Auto Routine Time: Straight-Right", new CG_AutoTimeStraightRight(ss_driveBase));

    SmartDashboard.putData(m_chooser);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(driverController, OIConstants.A_BUTTON)
            .whenHeld(new C_AutoAlign(ss_driveBase), true);
    // new JoystickButton(driverController, OIConstants.A_BUTTON)
    //         .whileActiveOnce(new C_AutoAlign(ss_driveBase), true);
    new JoystickButton(driverController, OIConstants.B_BUTTON)
            .whileActiveOnce(new CG_AutoTimeStraightLeft(ss_driveBase), true);
    // new JoystickButton(driverController, OIConstants.B_BUTTON)
    //         .whenPressed(new CG_AutoTimeStraightLeft(ss_driveBase), true);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return null;
    return m_chooser.getSelected();
  }

  public static Vision getVision() {
    return vision;
  }
}
