package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

@TeleOp(name="ProgramBot")
public class ProgramBot_TeleOp extends ProgramBot {
        double leftStickYVal;
        double leftStickXVal;
        double rightStickXVal;
        double rightStickYVal;


        double frontLeftSpeed;
        double frontRightSpeed;
        double rearLeftSpeed;
        double rearRightSpeed;

        double powerThreshold = 0;
        double speedMultiply = 1;


        // Construct the physical robot object
        public ProgramBot ProgramBot_New = new ProgramBot();
        @Override
        public void init() {
            ProgramBot_New.initBot(hardwareMap);
        }

        public void init_loop() {}

        public void start() {}

        @Override
        public void loop() {
            speedControl();
            drive();
            telemetryOutput();

        }
        public void drive() {

            leftStickYVal = -gamepad1.left_stick_y;
            leftStickYVal = Range.clip(leftStickYVal, -1, 1);
            leftStickXVal = gamepad1.left_stick_x;
            leftStickXVal = Range.clip(leftStickXVal, -1, 1);
            rightStickXVal = gamepad1.right_stick_x;
            rightStickXVal = Range.clip(rightStickXVal, -1, 1);

            frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
            frontLeftSpeed = Range.clip(frontLeftSpeed, -1, 1);

            frontRightSpeed = leftStickYVal - leftStickXVal - rightStickXVal;
            frontRightSpeed = Range.clip(frontRightSpeed, -1, 1);

            rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
            rearLeftSpeed = Range.clip(rearLeftSpeed, -1, 1);

            rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;
            rearRightSpeed = Range.clip(rearRightSpeed, -1, 1);

            if (frontLeftSpeed <= powerThreshold && frontLeftSpeed >= -powerThreshold) {
                frontLeftSpeed = 0;
                ProgramBot_New.frontLeftMotor.setPower(frontLeftSpeed);
            } else {
                ProgramBot_New.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
            }

            if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold) {
                frontRightSpeed = 0;
                ProgramBot_New.frontRightMotor.setPower(frontRightSpeed);
            } else {
                ProgramBot_New.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
            }

            if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
                rearLeftSpeed = 0;
                ProgramBot_New.rearLeftMotor.setPower(rearLeftSpeed);
            } else {
                ProgramBot_New.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
            }

            if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold) {
                rearRightSpeed = 0;
                ProgramBot_New.rearRightMotor.setPower(rearRightSpeed);
            } else {
                ProgramBot_New.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
            }
        }
        // Telemetry Controls Method for EndGame Extension/Lifting and Rotation
        public void telemetryOutput() {

            telemetry.addData("pwr", "FL mtr: " + frontLeftSpeed);
            telemetry.addData("pwr", "FR mtr: " + frontRightSpeed);
            telemetry.addData("pwr", "RL mtr: " + rearLeftSpeed);
            telemetry.addData("pwr", "RR mtr: " + rearRightSpeed);
            telemetry.update();
        }
        // Driving Speed Control Method
        public void speedControl() {

        }
    }

