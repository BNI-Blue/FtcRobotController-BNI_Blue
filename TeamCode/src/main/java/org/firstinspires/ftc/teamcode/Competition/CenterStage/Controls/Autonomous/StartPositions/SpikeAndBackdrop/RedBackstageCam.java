package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.SpikeAndBackdrop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeamPropPosition;

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

//        propPosition = TeamPropPosition.ONE;

        positionToDropRedBack();


        requestOpModeStop();

    }
    idle();
}
}
