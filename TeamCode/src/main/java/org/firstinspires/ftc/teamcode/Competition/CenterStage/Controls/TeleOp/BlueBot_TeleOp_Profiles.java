package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

//
//@Disabled
@TeleOp(name = "BlueBot:TeleOp")
public class BlueBot_TeleOp_Profiles extends OpMode {
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

    // Constants for driver profiles
    private static final int PROFILE_1 = 1;  //Charlie
    private static final int PROFILE_2 = 2;  // Evan
    private int currentProfile = PROFILE_1;

    public double pixelArmRotatorPower = 0.95;
    public double pixelArmPower = 0.7;
    public double endGameArmPower = 1;
    public double endGameUpPosition = 1;
    public double endGameDownPosition = 0;

    // Construct the physical robot object
    public BlueBot BlueBot = new BlueBot();

    @Override
    public void init () {
        BlueBot.initRobot(hardwareMap);
    }

    public void init_loop() {}

    public void start() {}

    @Override
    public void loop(){
        speedControl();
        changeDriverProfile();
        drive();
        pixelArmControl();
        endGameControl();
        clawControl();
        telemetryOutput();
        launcherControl();

    }


    public void changeDriverProfile() {
        if (gamepad1.dpad_right) {
            currentProfile = PROFILE_1;
        }
        else if (gamepad1.dpad_left) {
            currentProfile = PROFILE_2;
        }

    }
    public void drive () {

        // Joystick values
        leftStickYVal = -gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);
        //double rightStickYVal = gamepad1.right_stick_y;
        //rightStickYVal = Range.clip(rightStickYVal, -1, 1);

        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);
        rightStickXVal = gamepad1.right_stick_x;
        rightStickXVal = Range.clip(rightStickXVal, -1, 1);

        switch (currentProfile) {

            // Name of Driver using Profile 1
            case PROFILE_1:
                // leftStickXVal controls rotation, and rightStickXVal controls strafing.
                frontLeftSpeed = leftStickYVal + rightStickXVal + leftStickXVal;    // Vertical + Rotation + Staffing
                frontRightSpeed = leftStickYVal - rightStickXVal - leftStickXVal;   // Vertical - Rotation - Strafing(sign in front is the way the motor is turning in relation to the others)
                rearLeftSpeed = leftStickYVal - rightStickXVal + leftStickXVal;
                rearRightSpeed = leftStickYVal + rightStickXVal - leftStickXVal;
                break;
            // Name of Driver using Profile 2
            case PROFILE_2:
                //leftStickXVal controls strafing, and rightStickXVal controls rotation.
                frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
                frontRightSpeed = leftStickYVal - leftStickXVal - rightStickXVal;
                rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
                rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;
                break;

            // Default Driver Profile
            default:
                frontLeftSpeed = 0;
                frontRightSpeed = 0;
                rearLeftSpeed = 0;
                rearRightSpeed = 0;
                break;
        }

        // Clipping motor speeds to [-1, 1]
        frontLeftSpeed = Range.clip(frontLeftSpeed, -1, 1);
        frontRightSpeed = Range.clip(frontRightSpeed, -1, 1);
        rearLeftSpeed = Range.clip(rearLeftSpeed, -1, 1);
        rearRightSpeed = Range.clip(rearRightSpeed, -1, 1);

        // Setting motor powers (with threshold check)
        setMotorPower(BlueBot.frontLeftMotor, frontLeftSpeed, powerThreshold, speedMultiply);
        setMotorPower(BlueBot.frontRightMotor, frontRightSpeed, powerThreshold, speedMultiply);
        setMotorPower(BlueBot.rearLeftMotor, rearLeftSpeed, powerThreshold, speedMultiply);
        setMotorPower(BlueBot.rearRightMotor, rearRightSpeed, powerThreshold, speedMultiply);
    }


    public void setMotorPower(DcMotor motor, double speed, double threshold, double multiplier) {
        if (speed <= threshold && speed >= -threshold) {
            motor.setPower(0);
        } else {
            motor.setPower(speed * multiplier);
        }
    }

    // TeleOp Control Method for Pixel Arm Extension/Retraction and Rotation
    public void pixelArmControl() {

        // Pixel Arm Extension and Retraction
        if (gamepad2.right_stick_y < -0.1) {
            BlueBot.extendPixelArm(pixelArmPower);
        }
        else if (gamepad2.right_stick_y > 0.1) {
            BlueBot.retractPixelArm(pixelArmPower * 0.7);
        }
        else {
            BlueBot.stopPixelArm();
        }

        // Pixel Arm Rotation
        if (gamepad2.left_stick_y < -0.1) {
            BlueBot.rotatePixelArmUp(pixelArmRotatorPower);
        }
        else if (gamepad2.left_stick_y > 0.1) {
            BlueBot.rotatePixelArmDown(gamepad2.left_stick_y * 1);
        }
        else {
            BlueBot.stopPixelArmRotation();
        }
    }
    // EndGame Control Method for EndGame Extension/Lifting and Rotation
    public void endGameControl() {

        // End Game Extension/Retraction
        if (gamepad2.dpad_up) {
            BlueBot.extendEndGameArm(endGameArmPower);
        }
        else if (gamepad2.dpad_down) {
            BlueBot.retractEndGameArm(endGameArmPower);
        }
        else {
            BlueBot.stopEndGameArm();
        }

        // End Game Rotation
        if (gamepad2.dpad_right) {
            BlueBot.rotateEndGameArmUp(endGameUpPosition);
        }
        else if (gamepad2.dpad_left) {
            BlueBot.rotateEndGameArmDown(endGameDownPosition);
        }
        else {
            BlueBot.endGameRotator.setPower(0);
        }



        }
    //game pad 1 - left stick driving - strafe instead of going forward
    //end game arm isn't working
    public void clawControl(){
        if(gamepad2.left_trigger > 0.1){
            BlueBot.openPixelClaw();
        }
        if(gamepad2.right_trigger > 0.1){
            BlueBot.closePixelClaw();
        }
        telemetry.addData("left arm", BlueBot.pixelClawLeft.getPosition());
        telemetry.addData("right arm", BlueBot.pixelClawRight.getPosition());
        telemetry.update();
    }

    public void launcherControl (){
        if (gamepad2.x) {
            BlueBot.launchAirPlanePusher();
        }
        else {
            BlueBot.restAirPlanePusher();
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
//

    // Driving Speed Control Method
    public void speedControl() {

        if (gamepad1.left_bumper) {
            speedMultiply = 0.5;
        }

        else if (gamepad1.right_bumper) {
            speedMultiply = 1;
        }
    }
}

