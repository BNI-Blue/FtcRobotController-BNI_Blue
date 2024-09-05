package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

@Disabled
@Autonomous(name = "Blue:Testing:Encoder")

public class EncoderTesting extends AutoBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while (opModeIsActive()) {

//            CameraDetection();
            stopCamera();
//            Bot.drivePIDForward(12,.4,.1,.1,.1);
//            Bot.drivePIDForward(1500, 0.3, 0.1,0, 0.4);

            Bot.resetHeading();
//            Bot.driveForwardToPosition(0.5, 2);
            sleep(100);
//            Bot.rotateLeft(0.5, 2);

            Bot.driveGyroStraight(10, .5, "FORWARD");

            sleep(100);
            //Bot.gyroCorrection(0.5, 90);

            requestOpModeStop();

        }
        idle();
    }
}
