// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class DriveBase extends SubsystemBase {
  /* Device Declaration */

  // Declare Controller
  CommandXboxController m_driverControl = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);

  // Declare Motors
  WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.DeviceIds.kFrontRightId);
  WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.DeviceIds.kBackRightId);
  WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.DeviceIds.kFrontLeftId);
  WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.DeviceIds.kBackLeftId);

  // Declare Differential Drive
  DifferentialDrive m_drive;

  /** Creates a new DriveBase. */
  public DriveBase() {
    
    /* Motor Configuration */

    // Motor Safety
    rightFrontMotor.setSafetyEnabled(false);
    leftFrontMotor.setSafetyEnabled(false);

    // Motor Control
    rightFrontMotor.setInverted(false);
    leftFrontMotor.setInverted(true);

    //  Set Back Motors to follow front Motors
    rightBackMotor.follow(rightFrontMotor);
    leftBackMotor.follow(leftFrontMotor);



    m_drive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

  }

  public void curvatureDrive(){
    m_drive.curvatureDrive(
      MathUtil.applyDeadband(m_driverControl.getLeftY()*-1, 0.05),
      MathUtil.applyDeadband(m_driverControl.getRightX(), 0.05), 
      m_driverControl.getHID().getRightBumper());

    // m_drive.curvatureDrive(m_driverControl.getLeftY()*-1, m_driverControl.getRightX(), m_driverControl.getHID().getRightBumper()); Old Working Code
  }

  public void arcadeDrive(double speed, double rotation){
    m_drive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    curvatureDrive();
  }
  public Command exampleCommand(){
    
    return this.runOnce(() -> { /* Command Logic */});
  }
}
