package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions.NoCamera;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

@Disabled
@Autonomous(name= "Blue:Backstage:Start")
public class BlueBackstageStart extends AutoBlueAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        Bot.closePixelClaw();

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){

            // INSERT AUTO CODE BELOW


            Bot.driveForward(0.5,4);
            Bot.extendPixelArm(.5);
            sleep(500);
            Bot.stopPixelArm();
            Bot.openPixelClaw();

            // INSERT AUTO CODE ABOVE


            requestOpModeStop();

        }

        idle();
    }

}
