// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.ArmConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class LiftArmSubsystem extends SubsystemBase {
  /** Main arm motor are using a NEO motor connected with CAN  */
  private final SparkMax m_armLiftMotor = new SparkMax(ArmConstants.kCanid_ArmLift,MotorType.kBrushless );
  
// public ArmSubsystem() {}

  public void MoveArm(double speed) {
    // main command for moving the arm
    speed = speed * ArmConstants.kArmSpeed; // modify speed based on max output constant
    m_armLiftMotor.set(speed);
  }


}
