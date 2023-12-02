package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.RedToPixelBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
@Disabled
@Autonomous(name = "Red:Backstage:Start:Cam")
public class RedBackstageCam extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while (opModeIsActive()){

            CameraDetection();

            positionToDropRedBack();

            sleep(3000);
            requestOpModeStop();

        }
        idle();
    }
}
