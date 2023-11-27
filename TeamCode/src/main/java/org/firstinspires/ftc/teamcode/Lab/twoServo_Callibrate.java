package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Grabber Arm - USE FOR CENTERSTAGE")

public class twoServo_Callibrate extends OpMode {

    private Servo grabberArmLeft = null;
    private double grabberLeftArmPos = 0.5;
    // closed = .2
    // open = 0.622
    private double leftClose = 0.468;
    private double leftOpen = 0.592;

    private double incVal = 0.001;
    private Servo grabberArmRight = null;
    private double grabberRightArmPos = 0.5;
    // closed = 0.8
    // open = 0.4
    private double rightClose = 0.367;
    private double rightOpen = 0.269;


    @Override
    public void init () {
        grabberArmLeft = hardwareMap.servo.get("pixel_claw_left");
        grabberArmLeft.setPosition(grabberLeftArmPos);
        grabberArmRight = hardwareMap.servo.get("pixel_claw_right");
        grabberArmRight.setPosition((grabberRightArmPos));
    }

    @Override
    public void loop () {
        if (gamepad1.right_bumper) {
            grabberLeftArmPos += incVal;
            grabberLeftArmPos = Range.clip(grabberLeftArmPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad1.left_bumper){
            grabberLeftArmPos -= incVal;
            grabberLeftArmPos = Range.clip(grabberLeftArmPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }
//        if (gamepad1.y) {
//            grabberLeftArmPos = .4;
//        }
//        if (gamepad1.b) {
//            grabberLeftArmPos = .35;
//        }
//        if (gamepad1.a) {
//            grabberLeftArmPos = .32;
//        }
        if (gamepad1.right_trigger > 0.2) {
            grabberLeftArmPos = leftClose;
        }
        if (gamepad1.left_trigger > 0.2) {
            grabberLeftArmPos = leftOpen;
        }


        grabberArmLeft.setPosition(grabberLeftArmPos);

        if (gamepad2.right_bumper) {
            grabberRightArmPos += incVal;
            grabberRightArmPos = Range.clip(grabberRightArmPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad2.left_bumper){
            grabberRightArmPos -= incVal;
            grabberRightArmPos = Range.clip(grabberRightArmPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }

        if (gamepad2.right_trigger > 0.2) {
            grabberRightArmPos = rightClose;
        }
        if (gamepad2.left_trigger > 0.2) {
            grabberRightArmPos = rightOpen;
        }

//        if (gamepad2.y) {
//            grabberRightArmPos = .4;
//        }
//        if (gamepad2.b) {
//            grabberRightArmPos = .35;
//        }
//        if (gamepad2.a) {
//            grabberRightArmPos = .32;
//        }


        grabberArmRight.setPosition(grabberRightArmPos);
        updateTelemetry();
    }


    public void updateTelemetry () {
        telemetry.addLine("RB: increase, LB: Decrease");
        telemetry.addLine("x = set to .90, y = set to 0.10");
        telemetry.addData("Grabber Left Arm Position:", grabberArmLeft.getPosition());
        telemetry.addData("Grabber Left Arm Position:", grabberLeftArmPos);
        telemetry.addData("Grabber Right Arm Position", grabberArmRight.getPosition());
        telemetry.addData("Grabber Right Arm Position", grabberRightArmPos);
        telemetry.update();
    }
}