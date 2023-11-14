package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.RedToPixelBackdrop;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

public class AutoRedTwoPixelBackdrop extends RedTwoPixelBackdrop{

    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        initCamera();
        Bot.setLinearOp(this);
        startPipeline(pipeline);

        waitForStart();

        while (opModeIsActive()){
            CameraDetection();

            deliverPurple(Bot);


        }

    }
}
