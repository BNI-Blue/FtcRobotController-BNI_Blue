package org.firstinspires.ftc.teamcode.Competition.CenterStage.MotorTest;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp (name = "Test:Single Motor:Triggers", group = "Lab")
//Use 1 port, switch which motor is in the port to test it

public class SingleMotor_Triggers extends OpMode {
    private DcMotor motor = null;
    double forwardMotorPower = 0.4;
    double reverseMotorPower = 0.5;


    @Override
    public void init() {
        motor = hardwareMap.dcMotor.get("motor");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        telemetry.addLine("Left Trigger to go 'forward'");
        telemetry.addLine("Right Trigger to go 'reverse'");
        telemetry.update();
    }

    @Override
    public void loop() {
        forwardSpeedControl();
        reverseSpeedControl();
        motorControl();
        update_telemetry();
    }

    public void update_telemetry () {
        telemetry.addData("Forward Motor Power: ", forwardMotorPower);
        telemetry.addData("Reverse Motor Power: ", reverseMotorPower);
        telemetry.update();
    }

    public void motorControl() {

        if (gamepad1.left_trigger > 0.1){
            motor.setPower(forwardMotorPower);
        }
        else if (gamepad1.right_trigger > 0.1) {
            motor.setPower(-reverseMotorPower);
        }
        else{
            motor.setPower(0);
        }
    }


    public void forwardSpeedControl(){
        if(gamepad1.dpad_up){
            forwardMotorPower = 0.377;
        }
        if(gamepad1.dpad_left){
            forwardMotorPower = 0.38;
        }
        if(gamepad1.dpad_down){
            forwardMotorPower = 0.376;//correct speed
        }
        if(gamepad1.dpad_right){
            forwardMotorPower = 0.378;
        }
    }

    public void reverseSpeedControl(){
        if(gamepad1.a){
            reverseMotorPower = 0.45;
        }
        if (gamepad1.b){
            reverseMotorPower = 0.46;
        }
        if(gamepad1.x){
            reverseMotorPower = 0.47;//correct speed
        }
        if(gamepad1.y){
            reverseMotorPower = 0.48;
        }
    }


}
