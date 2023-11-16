package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoRedAlliance;

@Disabled
@Autonomous(name= "Red:Audience:Start_1")
public class RedAudienceStart_Truss1 extends AutoRedAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){


            // INSERT AUTO CODE BELOW


            Bot.driveForward(.25, .28);
            sleep(100);


            Bot.rotateRight(0.25, 3);
            sleep(100);


            Bot.driveForward(.5,10);
            sleep(100);


            // INSERT AUTO CODE ABOVE


            requestOpModeStop();

        }

        idle();
    }


}