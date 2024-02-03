package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

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

//            Bot.drivePIDForward(1500, 0.3, 0.1,0, 0.4);

            Bot.resetHeading();
            Bot.driveForwardToPosition(0.5, 2);
            sleep(100);
            Bot.rotateLeft(0.5, 2);

            sleep(100);
            Bot.gyroCorrection(0.5, 90);

            requestOpModeStop();

        }
        idle();
    }
}
