package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Autonomous(name= "Red:Audience:Start")
public class RedAudienceStart extends AutoRedAlliance {
    BlueBot Bot = new BlueBot();

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        //keeps arm inside of 18"
        Bot.autoArmInitPos();

        waitForStart();

        while(opModeIsActive()){


            // INSERT AUTO CODE BELOW

            Bot.autoArmStartPos();

            Bot.driveForward(.25, .28);
            sleep(100);


            Bot.rotateRightNew(0.25, 3);
            sleep(100);


            Bot.driveForward(.5,9);
            sleep(100);


            // INSERT AUTO CODE ABOVE


            requestOpModeStop();

        }

        idle();
    }


}