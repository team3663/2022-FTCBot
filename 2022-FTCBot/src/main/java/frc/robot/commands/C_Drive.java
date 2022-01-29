// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_TankDrive;

public class C_Drive extends CommandBase {
  /** Creates a new C_Drive. */
  private SS_TankDrive ss_TankDrive = SS_TankDrive.getInstance();

  private static final XboxController driveController = new XboxController(0);
  
  /** Creates a new C_FTC. */
  public C_Drive() {
    addRequirements(ss_TankDrive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(driveController.getYButtonPressed()){
    //   ss_TankDrive.setPower(0.2, 0.2);
    // }
    ss_TankDrive.setPower(0.2, 0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
