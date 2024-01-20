package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

@Autonomous(name = "Red:Cam:Test")
public class RedBackstageStart_CamTest extends AutoRedAlliance {@Override
public void runOpMode() throws InterruptedException {

    //Initialize Robot, Initialize Camera, and Integrate Linear OP
    Bot.initRobot(hardwareMap);
    initCamera();
    Bot.setLinearOp(this);

    // Start OpenCV Pipeline Processing
    startPipeline(pipeline);
    telemetry.addLine("Starting Vision Pipeline");
    telemetry.update();

    // Wait for Start Button to be pressed... No position detection yet due to randomization
    waitForStart();

    while (opModeIsActive()) {

        // First detection after randomization
        propPosition = pipeline.getAnalysis();
        telemetry.addData("Position Detected: ", propPosition);
        telemetry.update();
        sleep(1000);

        // Backup detection after first detection
        propPosition = pipeline.getAnalysis();
        telemetry.addData("Position Detected: ", propPosition);
        telemetry.update();
        sleep(1000);

        // Stop Camera Detection
        stopCamera();
        telemetry.addLine("Stopping Camera");
        telemetry.update();
        sleep(1000);

        //Bot.driveForward(.5, .5);
        telemetry.addLine("Drive Forward");
        telemetry.update();
        sleep(1000);

        //Bot.rotateRightNew(0.5, 3.1);
        telemetry.addLine("Rotate Right");
        telemetry.update();
        sleep(1000);

        //Bot.driveForward(.5,3.6);
        telemetry.addLine("Drive Forward");
        telemetry.update();
        sleep(1000);


        sleep(3000);

        requestOpModeStop();

    }

    idle();
}
}
