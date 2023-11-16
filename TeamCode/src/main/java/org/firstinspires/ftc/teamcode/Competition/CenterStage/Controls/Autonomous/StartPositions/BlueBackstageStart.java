package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.StartPositions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

//@Disabled
@Autonomous(name= "Blue:Backstage:Start")
public class BlueBackstageStart extends AutoBlueAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){

            // INSERT AUTO CODE BELO


            Bot.driveForward(0.5,.5);
            sleep(100);

            Bot.rotateLeft(0.5,2.6);
            sleep(100);

            Bot.driveForward(0.5,3.6);
            sleep(100);

            // INSERT AUTO CODE ABOVE


            requestOpModeStop();

        }

        idle();
    }

}
