package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous.AutoBlueAlliance;

@Autonomous(name = "Box")
public class Box extends AutoBlueAlliance {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){

            // INSERT AUTO CODE BELOW


            Bot.driveForward(.25);
            sleep(3000);
            Bot.stopMotors();

            Bot.strafeLeft(.25);
            sleep(3000);
            Bot.stopMotors();

            Bot.driveBack(.25);
            sleep(3000);
            Bot.stopMotors();

            Bot.strafeRight(.25);
            sleep(3000);
            Bot.stopMotors();



            // INSERT AUTO CODE ABOVE

            requestOpModeStop();

        }

        idle();
    }


}
