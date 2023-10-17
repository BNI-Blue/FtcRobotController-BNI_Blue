package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;

// Autonomous Pathing Class.  It inherits from Auto Blue parent and Auto Main "grandparent"
@Disabled
@Autonomous(name ="Blue:Position1:Basic:NoVision")
public class Auto3_BluePath_Pos1_Acker extends Auto2_Blue_Acker {

    // Construct Competiton and Programming Robots
    public BlueBot_Acker blueBot = new BlueBot_Acker();
    public ProgramBot programBot = new ProgramBot();

    // Boolean Flag to determine which robot we are using
    public boolean isCompetition = true;

    @Override
    public void runOpMode() throws InterruptedException {

        if (isCompetition) {
            blueBot.initRobot(hardwareMap);
            blueBot.setLinearOp(this);
        } else {
            programBot.initRobot(hardwareMap);
            programBot.setLinearOp(this);
        }

        telemetry.addLine("WAITING FOR START >");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // ***** INSERT AUTONOMOUS CODE BELOW THIS LINE  *****

            telemetry.addLine("Driving Forward");
            telemetry.update();
            blueBot.driveForward(.75,5);
            sleep(1000);

            telemetry.addLine("Rotating Left");
            telemetry.update();
            blueBot.rotateLeft(.40,4);
            sleep(1000);

            telemetry.addLine("Driving Forward Again");
            telemetry.update();
            blueBot.driveForward(.75,5);
            sleep(1000);
            blueBot.rotateLeft(.40,4);
            sleep(1000);


            // ***** INSERT AUTONOMOUS CODE BELOW THIS LINE  *****

            idle();
            requestOpModeStop();
        }

    }
}
