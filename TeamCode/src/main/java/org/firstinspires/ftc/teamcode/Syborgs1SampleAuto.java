package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IMUFactory;
import org.firstinspires.ftc.teamcode.subsystems.IntakeAndWristSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlideSubsystem;
@SuppressWarnings("unused")
@Autonomous(name="Syborgs1SampleAuto")
public class Syborgs1SampleAuto extends LinearOpMode {
    DriveSubsystem drive;
    IMU imu;
    ArmSubsystem arm;
    SlideSubsystem slide;
    IntakeAndWristSubsystem intakeAndWrist;
    @Override

    public void runOpMode() {
        waitForStart();
        initSubsystems();
        sleep(3000);
        drive.handleMovementAuto(25, 0);
        drive.handleMovementAuto(0, 23);
        arm.setPositionAuto(arm.ARM_SCORE_SAMPLE_IN_HIGH);
        sleep(1000);
        drive.handleMovementAuto(19, 0);
        slide.handleMovementAuto(slide.SLIDE_SCORING_IN_HIGH_BASKET);
        intakeAndWrist.handleMovementAutonomous(intakeAndWrist.INTAKE_DEPOSIT);
        sleep(3000);
        drive.handleMovementAuto(-7, 0);
        slide.handleMovementAuto(slide.SLIDE_COLLAPSED);
        arm.setPositionAuto(arm.ARM_COLLECT);
    }  
    public void initSubsystems() {
        imu = IMUFactory.initIMU(hardwareMap);
        drive = new DriveSubsystem(hardwareMap, telemetry, imu);
        arm = new ArmSubsystem(hardwareMap, telemetry);
        slide = new SlideSubsystem(hardwareMap, telemetry);
        intakeAndWrist = new IntakeAndWristSubsystem(hardwareMap, telemetry);
    }
}