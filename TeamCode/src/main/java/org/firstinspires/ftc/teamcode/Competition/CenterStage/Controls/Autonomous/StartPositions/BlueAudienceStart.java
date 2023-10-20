package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;
import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.BlueBot;

@Autonomous(name= "Blue Audience Start - Auto")
public class BlueAudienceStart extends AutoBlueAlliance {

    BlueBot Bot = new BlueBot();

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            requestOpModeStop();

        }

        idle();
    }

}
