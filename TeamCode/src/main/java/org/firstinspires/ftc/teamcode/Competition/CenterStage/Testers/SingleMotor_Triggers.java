package org.firstinspires.ftc.teamcode.Competition.CenterStage.Testers;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Disabled
@TeleOp (name = "Test:Single Motor:Triggers", group = "Lab")

public class SingleMotor_Triggers extends OpMode {
    private DcMotor motor = null;
    double power;
    double powerControl = 0.90;
    double speedMultiply = 0.5;




    @Override
    public void init() {
        motor = hardwareMap.dcMotor.get("motor");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        power = 0;

        telemetry.addLine("Right Trigger to go 'forward'");
        telemetry.addLine("Left Trigger to go 'reverse'");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.right_trigger > 0.1) {
            power = powerControl;
        }
        else if (gamepad1.left_trigger > 0.1) {
            power = -powerControl;
        }
        else {
            power = 0;
        }

        motor.setPower(power);

        update_telemetry();
    }

    public void update_telemetry () {
        telemetry.addData("Right Trigger Value: ", gamepad1.right_trigger);
        telemetry.addData("Left Trigger Value: ", gamepad1.left_trigger);
        telemetry.addData("POWER: ", power);
    }

    public void speedControl () {
        if (gamepad1.dpad_up){
            speedMultiply = 1;
        }
        if(gamepad1.dpad_left){
            speedMultiply = 0.25;
    }
        if(gamepad1.dpad_down){
            speedMultiply = 0.5;
        }
        if(gamepad1.dpad_right){
            speedMultiply = 0.75;
        }
    }

}
