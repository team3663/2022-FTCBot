// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import frc.robot.utils.TalonSRXController;

public class SS_TankDrive extends SubsystemBase {
  // Set up the drive motor controlles
  private final TalonSRXController m_leftDriveMotor = new TalonSRXController(CANConstants.L_MOTOR_CONTROLLER_CAN_ID);
  private final TalonSRXController m_rightDriveMotor = new TalonSRXController(CANConstants.R_MOTOR_CONTROLLER_CAN_ID);

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);

  // set up the encoders for the drive motor controllers  
  // private final Encoder m_leftDriveEncoder = new Encoder(1, 2);  // FIXME: need actual encoder parameters
  // private final Encoder m_rightDriveEncoder = new Encoder(3, 4); // FIXME: need actual encoder parameters

  /** Creates a new SS_FTC. */
  public SS_TankDrive() {
    m_leftDriveMotor.setInverted(true);
    m_rightDriveMotor.setInverted(false);
    // m_leftDriveEncoder.setReverseDirection(false); // FIXME: need actual encoder parameters
    // m_rightDriveEncoder.setReverseDirection(true); // FIXME: need actual encoder parameters
  }

  public void arcadeDrive(double xAxisSpeed, double zAxisRotate) {
    m_diffDrive.arcadeDrive(xAxisSpeed, -zAxisRotate);
  }

  public void setPower(double leftPower, double rightPower) {
    m_leftDriveMotor.set(ControlMode.PercentOutput, leftPower);
    m_rightDriveMotor.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
