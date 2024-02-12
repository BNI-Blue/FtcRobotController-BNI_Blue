package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.SpikeAndBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;

@Autonomous (name = "Blue:Audience:Wall:Cam")
public class BlueAudienceWallCam extends AutoBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

//        Bot.initRobot(hardwareMap);
        Bot.initRobot(hardwareMap);
//        initCamera();
        initCamera();
//        Bot.setLinearOp(this);
        Bot.setLinearOp(this);
        startPipeline(pipeline);
//        startPipeline(pipeline);



//        telemetry.addLine("Turning on Camera, please wait...");
//        telemetry.update();
//        sleep(1000);
//        CameraDetection();
//        sleep(3000);
//        telemetry.addData("POSITION: ", propPosition);
//        telemetry.addLine("WAITING FOR START >");
//        telemetry.update();
        waitForStart();
        Bot.resetHeading();

        while (opModeIsActive()) {

            CameraDetection();
            //propPosition = TeamPropPosition.THREE;
            positionToDropBlueAudWall();


            requestOpModeStop();

        }
        idle();
    }
}
