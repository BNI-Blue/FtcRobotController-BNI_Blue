package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerImpl;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.CompBot;

@TeleOp (name = "A_TeleOp_CompBot_Centerstage")
public class CompetitionTeleOp extends OpMode {
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

    public double wormgearPower = 1;

    public double viperSlidePower = .7;

    public double viperSlideMaxTicks = 250;
    public double viperSlideMinTicks = 1;
    public double wormgearMaxTicks = 100;
    public double wormgearMinTicks = 1;





    public CompBot CompetitionBot = new CompBot();

    public void init () {
        CompetitionBot.initRobot(hardwareMap);
    }
    public void init_loop() {  }


    public void start() {

    }

    public void loop(){
        speedControl();
        pixelMechanismControl();
        drive();
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
            CompetitionBot.frontLeftMotor.setPower(frontLeftSpeed);
        } else {
            CompetitionBot.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
        }

        if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold){
            frontRightSpeed = 0;
            CompetitionBot.frontRightMotor.setPower(frontRightSpeed);
        } else {
            CompetitionBot.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
        }

        if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
            rearLeftSpeed = 0;
            CompetitionBot.rearLeftMotor.setPower(rearLeftSpeed);
        } else {
            CompetitionBot.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
        }

        if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold){
            rearRightSpeed = 0;
            CompetitionBot.rearRightMotor.setPower(rearRightSpeed);
        } else {
            CompetitionBot.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
        }
    }

    public void pixelMechanismControl() {



        if (gamepad2.right_stick_y > 0.1){
            CompetitionBot.linearSlideUp(viperSlidePower);
        }
        else if (gamepad2.right_stick_y < -0.1) {
            CompetitionBot.linearSlideDown(viperSlidePower);
        }
        else {
            CompetitionBot.viperSlideRight.setPower(0);
        }

        if (Math.abs(CompetitionBot.viperSlideRight.getCurrentPosition()) > viperSlideMaxTicks) {
            CompetitionBot.viperSlideRight.setPower(0);
        }

        else if (Math.abs(CompetitionBot.viperSlideRight.getCurrentPosition()) <= viperSlideMinTicks) {
            CompetitionBot.viperSlideRight.setPower(0);
        }

        if (gamepad2.left_stick_y > 0.1) {
            CompetitionBot.rightWormgearLeft(wormgearPower);
        }
        else if (gamepad2.left_stick_y < -0.1) {
            CompetitionBot.rightWormgearRight(wormgearPower);
        }
        else {
            CompetitionBot.wormgearRight.setPower(0);
        }


    }
    public void telemetryOutput() {

        telemetry.addData("pwr", "FL mtr: " + frontLeftSpeed);
        telemetry.addData("pwr", "FR mtr: " + frontRightSpeed);
        telemetry.addData("pwr", "RL mtr: " + rearLeftSpeed);
        telemetry.addData("pwr", "RR mtr: " + rearRightSpeed);
        telemetry.update();
    }

    public void speedControl() {

        if (gamepad1.dpad_up) {
            speedMultiply = 0.5;
        }

        else if (gamepad1.dpad_down) {
            speedMultiply = 1;
        }
    }



}
