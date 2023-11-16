package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

//@Disabled
@Autonomous(name="Red:Backstage:Start")
public class RedBackstageStart extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){


            Bot.driveForward(.5, .5);
            sleep(100);


            Bot.rotateRight(0.5, 3.1);
            sleep(100);


            Bot.driveForward(.5,3.6);
            sleep(100);


            requestOpModeStop();

        }

        idle();
    }

}
