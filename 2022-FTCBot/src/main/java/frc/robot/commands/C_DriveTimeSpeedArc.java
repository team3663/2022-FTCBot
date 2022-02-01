// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_TankDrive;
// import frc.robot.Constants.*;

public class C_DriveTimeSpeedArc extends CommandBase {
  private final SS_TankDrive ss_driveBase;
  private final double m_speed;
  private final double m_arcRadius;
  private final double m_timeMilli;
  private double m_startTimeMilli = 0;

  public C_DriveTimeSpeedArc(SS_TankDrive tankDrive, double speed, double radius, double timeMilli) {
    ss_driveBase = tankDrive;
    m_speed = speed;
    m_arcRadius = radius;
    m_timeMilli = timeMilli;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ss_driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
        // reset start time 
        m_startTimeMilli = Timer.getFPGATimestamp();
        System.out.println("C_DriveTimeSpeedArc.java started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // calculate rotation  ω = r × v / |r|²
    // 1 RPM = 0.10472 rad/s = 0.01667 Hz,
    // or the other way round: 1 Hz = 6.283 rad/s = 60 RPM.
    double rotate = m_arcRadius * m_speed / (m_arcRadius * m_arcRadius);
    ss_driveBase.arcadeDrive(m_speed, rotate);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ss_driveBase.setPower(0, 0);
    System.out.println("C_DriveTimeSpeedArc.java ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
