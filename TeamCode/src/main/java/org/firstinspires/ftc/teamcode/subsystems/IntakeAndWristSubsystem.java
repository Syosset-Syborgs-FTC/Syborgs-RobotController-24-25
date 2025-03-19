package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeAndWristSubsystem {
    private final CRServo intake;
    private final CRServo wrist;
    Telemetry telemetry;

    public final double INTAKE_COLLECT = -1.0;
    public final double INTAKE_OFF = 0.0;
    public final double INTAKE_DEPOSIT = 0.5;
    public final double WRIST_FOLDED_IN = 0.2;
    public final double WRIST_FOLDED_OUT = 0.5;
    public final double WRIST_NEUTRAL = 0.4;
    private double intakePower = INTAKE_OFF;
    private double wristPosition = WRIST_NEUTRAL;
    public IntakeAndWristSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        intake = hardwareMap.crservo.get("IN");
        wrist = hardwareMap.crservo.get("WR");

        intake.setPower(INTAKE_OFF);

        wrist.setPower(wristPosition);
    }
    public void handleMovementAutonomous(double intakePower) {
        intake.setPower(intakePower);
    }
    @SuppressWarnings("unused")
    public void handleMovementTeleOp(Gamepad gamepad1, Gamepad gamepad2) {
        readControls(gamepad2);

        intake.setPower(intakePower);
        wrist.setPower(wristPosition);
    }
    public void updateTelemetry() {
         telemetry.addData("Intake Power", intake.getPower());
         telemetry.addData("Wrist Position", wrist.getPower());
    }
    private void readControls(Gamepad gamepad) {
     if (gamepad.left_trigger > 0.5) {
            // open
            intake.setPower(0);
        }
        if (gamepad.right_trigger > 0.5) {
            // close
            intake.setPower(1);
        }
        if (gamepad.left_bumper) {
            // up
            wrist.setPower(0);
        }
        if (gamepad.right_bumper) {
            // down
            wrist.setPower(1);
        }

    }
}
