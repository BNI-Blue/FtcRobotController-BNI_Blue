package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.SpikeAndBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;

@Disabled
@Autonomous (name = "Blue:Audience:Middle:Cam")
public class BlueAudienceMiddleCam extends AutoBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);
        sleep(5000);
        telemetry.addData("POSITION:", propPosition);
        telemetry.update();
        waitForStart();
        Bot.resetHeading();

        while (opModeIsActive()) {

            CameraDetection();
            //propPosition = TeamPropPosition.ONE;
            positionToDropBlueAudMiddle();


            requestOpModeStop();

        }
        idle();
    }
}
