package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.SpikeAndBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;

@Disabled
@Autonomous(name = "Red:Audience:Wall:Cam")
public class RedAudienceWallCam extends AutoRedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while(opModeIsActive()){
            Bot.resetHeading();
            sleep(200);

            CameraDetection();
            //propPosition = TeamPropPosition.FOUR;
            positionToDropRedAudWall();

            requestOpModeStop();
        }
        idle();
    }
}
