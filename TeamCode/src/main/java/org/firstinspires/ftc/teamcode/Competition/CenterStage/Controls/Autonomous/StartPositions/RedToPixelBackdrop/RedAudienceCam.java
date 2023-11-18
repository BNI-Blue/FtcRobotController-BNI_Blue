package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.RedToPixelBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

@Autonomous(name = "Red:Audience:Start:Cam")
public class RedAudienceCam extends AutoRedAlliance {
    @Override
    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while(opModeIsActive()){
            CameraDetection();

            positionToDropRedAud();
            sleep(3000);
            requestOpModeStop();
        }
        idle();
    }
}
