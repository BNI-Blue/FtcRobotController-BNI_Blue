package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "single grabber arm", group = "LAB")


public class SingleServo_Calibrate extends OpMode {

    private Servo myServo = null;

    //change back to 0.5 for any other servo, but should be 0.2 for ring_mag
    private double servoPos = 0.5;

    private double incVal = 0.001;

    @Override
    public void init () {
        //"servo_ring_pusher" = ring pusher
        //"ring_mag" = mag servo
        myServo = hardwareMap.servo.get("plane_pusher");
        myServo.setPosition(servoPos);
    }

    @Override
    public void loop () {
        if (gamepad1.right_bumper) {
            servoPos += incVal;
            servoPos = Range.clip(servoPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad1.left_bumper){
            servoPos -= incVal;
            servoPos = Range.clip(servoPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }


        if (gamepad1.a) {
            myServo.setPosition(0.2);
        }
        else if (gamepad1.b) {
            myServo.setPosition(0.9);
        }

        myServo.setPosition(servoPos);
        updateTelemetry();
    }

    public void updateTelemetry () {
        telemetry.addLine("RB: increase, LB: Decrease");
        telemetry.addLine("x = set to .90, y = set to 0.10");
        telemetry.addData("TestS ervo Positiom: ", myServo.getPosition());
        telemetry.addData("Servo Variable Position: ", servoPos);
        telemetry.update();
    }
}


//mag arm down = 0
// mag up = 0.171