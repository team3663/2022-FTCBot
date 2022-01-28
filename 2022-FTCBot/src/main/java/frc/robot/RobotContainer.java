// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.C_Drive;
import frc.robot.subsystems.SS_TankDrive;
import frc.robot.util.XboxGamepad;

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
  
  public static final XboxGamepad DRIVE_CONTROLLER = new XboxGamepad(Constants.Xbox_Driver_Controller, 0.1);
  private SS_TankDrive ss_TankDrive = new SS_TankDrive();

  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //CommandScheduler.getInstance().setDefaultCommand(drivebase, new C_Drive());
    CommandScheduler.getInstance().setDefaultCommand(ss_TankDrive, new C_Drive());
    //updateManager.startLoop(5.0e-3);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Back button zeros the gyroscope
    new Button(DRIVE_CONTROLLER::getBackButton)
    // No requirements because we don't need to interrupt anything
    .whenPressed(m_drivetrainSubsystem::zeroGyroscope);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public static XboxGamepad getXboxController() {
     return DRIVE_CONTROLLER;
  }
}
