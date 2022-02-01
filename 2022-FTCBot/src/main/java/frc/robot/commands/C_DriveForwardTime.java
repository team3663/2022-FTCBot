// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_TankDrive;

public class C_DriveForwardTime extends CommandBase {
  private final SS_TankDrive ss_TankDrive;
  private final double m_time;

  public C_DriveForwardTime(SS_TankDrive tankDrive, double time) {
    ss_TankDrive = tankDrive;
    m_time = time;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_TankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("C_DriveForwardTime.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_TankDrive.setPower(0, 0);
    System.out.println("C_DriveForwardTime.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
