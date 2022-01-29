// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SS_TankDrive extends SubsystemBase {
  /** Creates a new SS_TankDrive. */
  private static SS_TankDrive instance;

  private static final TalonSRX leftMotor = new TalonSRX(Constants.LEFT_DRIVE);
  private static final TalonSRX rightMotor = new TalonSRX(Constants.RIGHT_DRIVE);
  
  // private CANSparkMax leftMotor = new CANSparkMax(Constants.LEFT_FTC_CANID, MotorType.kBrushed);
  // private CANSparkMax rightMotor = new CANSparkMax(Constants.RIGHT_FTC_CANID, MotorType.kBrushed);

  /** Creates a new SS_FTC. */
  public SS_TankDrive() {
    
  }

  public static SS_TankDrive getInstance() {
    if (instance == null) {
      instance = new SS_TankDrive();
    }
    return instance;
  }
  

  public void setSpeed(double speed){
    //leftMotor.
    //leftMotor.set(speed);
    //rightMotor.set(-speed);
    //flywheelPid.setReference(RPM * correctionMultiplier, ControlType.kVelocity);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double power, double rotation) {
    if(rotation > 0) {
      setPower(power, (-2 * rotation + 1) * power);
    } else if (rotation < 0) {
      setPower((2 * rotation + 1) * power, power);
    } else {
      setPower(power, power);
    }
  }

  public void setPower(double leftPower, double rightPower) {
    leftMotor.set(ControlMode.PercentOutput, leftPower);
    rightMotor.set(ControlMode.PercentOutput, rightPower);
  }
}
