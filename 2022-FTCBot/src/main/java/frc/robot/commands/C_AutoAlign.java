// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import org.ejml.interfaces.decomposition.LUSparseDecomposition;

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.drivers.Vision;
// import frc.robot.drivers.Limelight;
import frc.robot.subsystems.SS_TankDrive;

public class C_AutoAlign extends CommandBase {
  private SS_TankDrive driveBase;
  private Vision vision;

  public C_AutoAlign(SS_TankDrive driveBase) {
    vision = RobotContainer.getVision();
    this.driveBase = driveBase;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    vision.setLEDMode(vision.LED_ON);
    System.out.println("C_AutoAlign started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(vision.getValidTarget()){
      if(vision.getXOffset() > 2 && vision.getXOffset() < 27){
        driveBase.arcadeDrive(0, 0.5);
      } else if(vision.getXOffset() < -2 && vision.getXOffset() > -27){
        driveBase.arcadeDrive(0, -0.5);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    vision.setLEDMode(vision.LED_OFF); // TODO: Should LED be turned OFF when done or left ON???
    driveBase.arcadeDrive(0, 0);
    System.out.println("C_AutoAlign ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // command finishes when target is in the 'cross-hair'
    return vision.getXOffset() < 2 && vision.getXOffset() > -2;
  }
}
