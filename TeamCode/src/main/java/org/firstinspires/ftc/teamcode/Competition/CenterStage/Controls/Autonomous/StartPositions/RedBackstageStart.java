package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoMain;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Autonomous(name="Red:Backstage:Start")
public class RedBackstageStart extends AutoRedAlliance {
    BlueBot Bot = new BlueBot();

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


            Bot.rotateRightNew(0.5, 3.1);
            sleep(100);


            Bot.driveForward(.5,3.6);
            sleep(100);


            requestOpModeStop();

        }

        idle();
    }

}
