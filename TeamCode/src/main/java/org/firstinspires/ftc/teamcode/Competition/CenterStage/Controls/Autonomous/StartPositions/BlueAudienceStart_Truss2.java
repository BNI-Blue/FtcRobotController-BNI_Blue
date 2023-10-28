package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Autonomous(name="Blue:Audience:Start_2")
public class BlueAudienceStart_Truss2 extends AutoBlueAlliance {

    BlueBot Bot = new BlueBot();

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){

            // INSERT AUTO CODE BELOW

            Bot.driveForward(.5, 3);
            sleep(100);

            Bot.rotateLeftNew(0.25, 2.9);
            sleep(100);

            //this is the only movement that needs to be tested, the other two work
            Bot.driveForward(.5,10);
            sleep(100);


            // INSERT AUTO CODE ABOVE

            requestOpModeStop();
        }
        idle();
    }
}
