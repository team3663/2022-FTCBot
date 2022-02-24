// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.drivers.Vision;
import frc.robot.subsystems.SS_TankDrive;

public class C_PositionBot extends CommandBase {
  /** Creates a new C_PositionBot. */
  private SS_TankDrive driveBase;
  private DigitalInput limitSwitch;
  private Vision vision;
  private int distance;

  public C_PositionBot(SS_TankDrive driveBase, int switchID) {
    vision = RobotContainer.getVision();
    this.driveBase = driveBase;
    limitSwitch = new DigitalInput(switchID);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    vision.setLEDMode(vision.LED_ON);
    System.out.println("C_PositionBot started.");
    distance = 10;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(vision.getXOffset() > 2 && vision.getXOffset() < 27){
      driveBase.arcadeDrive(0, 0.5);
    } else if(vision.getXOffset() < -2 && vision.getXOffset() > -27){
      driveBase.arcadeDrive(0, -0.5);
    }

    if(vision.getXOffset() < 2 && vision.getXOffset() > -2){
      if(vision.getDistance() < distance){
        driveBase.arcadeDrive(-0.5, 0);
        System.out.print("DISTANCE" + vision.getDistance());
      } else if(vision.getDistance() > distance){
        driveBase.arcadeDrive(0.5, 0);
        System.out.print("DISTANCE" + vision.getDistance());
      }
      if(vision.getDistance() == distance){
        if(vision.getXOffset() > 2 && vision.getXOffset() < 27){
          driveBase.arcadeDrive(0, 0.5);
        } else if(vision.getXOffset() < -2 && vision.getXOffset() > -27){
          driveBase.arcadeDrive(0, -0.5);
        }
      }
    } 
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.arcadeDrive(0, 0);
    System.out.println("C_PositionBot ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

