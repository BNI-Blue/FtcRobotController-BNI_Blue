package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot_New;

//import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot_Acker;

    //@Disabled
    @TeleOp(name = "BlueBot:TeleOp ")
    public class BlueBot_TeleOp extends OpMode {
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

        public double pixelArmRotatorPower = 0.95;
        public double pixelArmPower = 0.7;
        public double endGameArmPower = 0.95;
        public double endGameUpPosition = 0.7;
        public double endGameDownPosition = 0.2;

        // Construct the physical robot object
        public BlueBot_New BlueBot = new BlueBot_New();

        @Override
        public void init () {
            BlueBot.initRobot(hardwareMap);
        }

        public void init_loop() {}

        public void start() {}

        @Override
        public void loop(){
            speedControl();
            drive();
            pixelArmControl();
            endGameControl();
            telemetryOutput();
        }

        public void drive() {

            leftStickYVal = gamepad1.left_stick_y;
            leftStickYVal = Range.clip(leftStickYVal, -1, 1);
            leftStickXVal = -gamepad1.left_stick_x;
            leftStickXVal = Range.clip(leftStickXVal, -1, 1);
            rightStickXVal = -gamepad1.right_stick_x;
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
                BlueBot.frontLeftMotor.setPower(frontLeftSpeed);
            } else {
                BlueBot.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
            }

            if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold){
                frontRightSpeed = 0;
                BlueBot.frontRightMotor.setPower(frontRightSpeed);
            } else {
                BlueBot.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
            }

            if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
                rearLeftSpeed = 0;
                BlueBot.rearLeftMotor.setPower(rearLeftSpeed);
            } else {
                BlueBot.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
            }

            if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold){
                rearRightSpeed = 0;
                BlueBot.rearRightMotor.setPower(rearRightSpeed);
            } else {
                BlueBot.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
            }
        }

        // TeleOp Control Method for Pixel Arm Extension/Retraction and Rotation
        public void pixelArmControl() {

            // Pixel Arm Extension and Retraction
            if (gamepad2.right_stick_y > 0.1) {
                BlueBot.extendPixelArm(pixelArmPower);
            }
            else if (gamepad2.right_stick_y < -0.1) {
                BlueBot.retractPixelArm(pixelArmPower);
            }
            else {
                BlueBot.stopPixelArm();
            }

            // Pixel Arm Rotation
            if (gamepad2.left_stick_y < -0.1) {
                BlueBot.rotatePixelArmUp(pixelArmRotatorPower);
            }
            else if (gamepad2.left_stick_y > 0.1) {
                BlueBot.rotatePixelArmDown(pixelArmRotatorPower);
            }
            else {
                BlueBot.stopPixelArmRotation();
            }
        }

        // EndGame Control Method for EndGame Extension/Lifting and Rotation
        public void endGameControl() {

            // End Game Extension/Retraction
            if (gamepad2.left_trigger > 0.1) {
                BlueBot.extendEndGameArm(endGameArmPower);
            }
            else if (gamepad2.right_trigger > 0.1) {
                BlueBot.retractEndGameArm(endGameArmPower);
            }
            else {
                BlueBot.stopPixelArmRotation();
            }

            // End Game Rotation
            if (gamepad2.y) {
                BlueBot.rotateEndGameArmUp(endGameUpPosition);
            }
            if (gamepad2.x) {
                BlueBot.retractEndGameArm(endGameDownPosition);
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

            if (gamepad1.dpad_up) {
                speedMultiply = 0.5;
            }

            else if (gamepad1.dpad_down) {
                speedMultiply = 1;
            }
        }



    }

