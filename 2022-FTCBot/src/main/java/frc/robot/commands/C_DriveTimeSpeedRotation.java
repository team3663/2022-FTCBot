// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_TankDrive;
// import frc.robot.Constants.*;

public class C_DriveTimeSpeedRotation extends CommandBase {
  private final SS_TankDrive ss_driveBase;
  private final double m_speed;
  private final double m_rotate;
  private final double m_timeMilli;
  private double m_startTimeMilli = 0;

  public C_DriveTimeSpeedRotation(SS_TankDrive driveBase, double speed, double rotate, double timeMilli) {
    ss_driveBase = driveBase;
    m_speed = speed;
    m_rotate = rotate;
    m_timeMilli = timeMilli;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // reset start time 
    m_startTimeMilli = Timer.getFPGATimestamp();
    System.out.println("C_DriveTimeSpeedRotation.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ss_driveBase.arcadeDrive(m_speed, m_rotate);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_driveBase.setPower(0, 0);
    System.out.println("C_DriveTimeSpeedRotation.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return false;
    double time = Timer.getFPGATimestamp();
    // System.out.println(time - m_startTimeMilli);
    return time - m_startTimeMilli >= m_timeMilli;
  }
}
