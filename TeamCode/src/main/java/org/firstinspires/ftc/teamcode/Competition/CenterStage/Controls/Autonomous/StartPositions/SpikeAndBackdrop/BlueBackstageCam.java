package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.SpikeAndBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

@Autonomous(name = "Blue:Backstage:Start:Cam")
public class BlueBackstageCam extends AutoBlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while (opModeIsActive()) {

            CameraDetection();

            positionToDropBlueBack();

//            placePixelBackdrop();

            sleep(1000);
            requestOpModeStop();

        }
        idle();
    }
}
