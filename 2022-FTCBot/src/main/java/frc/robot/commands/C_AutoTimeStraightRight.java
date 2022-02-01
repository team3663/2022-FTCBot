// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SS_TankDrive;

public class C_AutoTimeStraightRight extends SequentialCommandGroup {
  // private final SS_TankDrive ss_TankDrive = new SS_TankDrive();
  /**
   * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
   * around for time (equivalent to time to turn around) and drive forward again. This should mimic
   * driving out, turning around and driving back.
   *
   * @param drivetrain The drive subsystem on which this command will run
   */
  public C_AutoTimeStraightRight(SS_TankDrive ss_driveBase) {
    addCommands(
      new C_DriveTimeSpeedRotation(ss_driveBase, 2, 0, 3.0),
      new C_DriveTimeSpeedRotation(ss_driveBase, 2, 1, 3.0)
    );
  }
}
