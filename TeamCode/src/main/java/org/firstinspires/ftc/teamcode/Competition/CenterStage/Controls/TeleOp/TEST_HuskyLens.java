package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;
@Disabled
@TeleOp (name = "TEST_HuskyLens")
public class TEST_HuskyLens extends LinearOpMode {

    public final int READ_PERIOD = 1;

    public HuskyLens huskyLens;

    @Override
    public void runOpMode(){
        huskyLens = hardwareMap.get(HuskyLens.class,"huskylens");

        Deadline rateLimit = new Deadline(READ_PERIOD, TimeUnit.SECONDS);

        rateLimit.expire();


        if (!huskyLens.knock()) {
            telemetry.addData(">>", "Problem communicating with " + huskyLens.getDeviceName());
        }
        else {
            telemetry.addData(">>", "Press start to continue");
        }

        huskyLens.selectAlgorithm(HuskyLens.Algorithm.OBJECT_RECOGNITION);

        while (opModeIsActive()) {
            if (!rateLimit.hasExpired()) {
                continue;
            }

            rateLimit.reset();




            HuskyLens.Block[] blocks = huskyLens.blocks();
            telemetry.addData("Block count", blocks.length);
            for (int i = 0; i < blocks.length; i++) {
                telemetry.addData("Block", blocks[i].toString());
            }
            telemetry.update();
        }
    }


}
