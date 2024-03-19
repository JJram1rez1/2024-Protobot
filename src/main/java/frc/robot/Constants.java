// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class OperatorConstants {
    /*  Assign controllers their respective ports */
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class DeviceIds{

    /*  Drive Base Subsystem Ids */

    // Drive Motor Controller Ids
    public static final int kFrontRightId = 10;
    public static final int kFrontLeftId = 11;
    public static final int kBackRightId = 12;
    public static final int kBackLeftId = 13;

    /*  Ground Intake Susbystem Ids */
    
    // Ground Intake Motor Ids
    public static final int kRightGroundIntake = 50;
    public static final int kLeftGroundIntake = 51;
  }

  public static class GroundIntakeConstants{

    /*  Ground Intake Constants */
    public static final double kStopMotor = 0.0;

    public static final double kIntakeNote = 0.4;

    public static final double kIdleConstant = 0.25;

    public static final double kFullSend = 1.0;
    }
  }

