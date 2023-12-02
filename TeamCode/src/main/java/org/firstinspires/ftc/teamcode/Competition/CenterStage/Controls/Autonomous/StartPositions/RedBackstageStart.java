package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

@Autonomous(name="Red:Backstage:Start")
public class RedBackstageStart extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        Bot.closePixelClaw();

        telemetry.addLine("Awaiting Start");
        telemetry.update();



        waitForStart();

        while(opModeIsActive()){


            Bot.driveForward(.5, .5);
            sleep(100);


            Bot.strafeRight(0.5, 3.1);
            sleep(100);


            Bot.driveForward(.5,3.7);
            sleep(100);


            requestOpModeStop();

        }

        idle();
    }

}
