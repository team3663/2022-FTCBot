// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
//import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.drivers.Limelight;
import frc.robot.subsystems.SS_TankDrive;

public class C_AutoAlign extends CommandBase {
  private SS_TankDrive driveBase;
  private Limelight vision;
  
  private boolean m_printOnceAlready = false;

  /** Creates a new C_AutoAlign. */
  public C_AutoAlign(SS_TankDrive driveBase) {
    // vision = new Limelight();
    vision = RobotContainer.limeLight;
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveBase = driveBase;
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("C_AutoAlign started.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.arcadeDrive(0.0, 0.5);
    // System.out.println("----------------------!vision.getValidTarget(): " + !vision.getValidTarget());
    // if(vision == null && !vision.getValidTarget()){
       //driveBase.setPower("left", 0.2);
      //driveBase.arcadeDrive(0., -.2);
    // }
    // if(!vision.getValidTarget()){
    //   driveBase.setPower("left", 0.2);
    // }
    //driveBase.setPower("left", 0.2);
    //while not horozontal turn right if xoffset is < 27 && > 0 else turn left
    //while not vertical back up if yoffset is < 20.5 && > 0 else drive foreward
    // System.out.println("oooooooooooo>>>>>>>>>>> vision.getValidTarget() : " + vision.getValidTarget());
    // driveBase.arcadeDrive(0, 0.2);
    // if(vision.getValidTarget()){
      // driveBase.arcadeDrive(0, -0.2);
      // System.out.println("oooooooooooo>>>>>>>>>>> vision.getValidTarget() : " + vision.getValidTarget());
    //   if(vision.getXOffset() < 27 && vision.getXOffset() > 2){
    //     driveBase.setPower(0.2, -0.2);
    //  }//else if(vision.getXOffset() > -27 && vision.getYOffset() < -2){
      //   driveBase.setPower("right", -0.2);
      // }
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.arcadeDrive(0, 0);
    System.out.println("C_AutoAlign ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}