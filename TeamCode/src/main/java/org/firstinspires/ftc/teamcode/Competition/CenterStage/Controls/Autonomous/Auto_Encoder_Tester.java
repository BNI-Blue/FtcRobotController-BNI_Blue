package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.Autonomous;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.ProgramBot;
import org.firstinspires.ftc.teamcode.Lab.Auto1_Main_Acker;
import org.firstinspires.ftc.teamcode.Lab.BlueBot_Acker;

public class Auto_Encoder_Tester extends Auto1_Main_Acker{
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
            blueBot.driveForward(.75, 5);
            sleep(1000);

            telemetry.addLine("Rotating Left");
            telemetry.update();
            blueBot.rotateLeft(.40, 4);
            sleep(1000);

            telemetry.addLine("Rotating Right");
            telemetry.update();
            blueBot.rotateRight(.75, 5);
            sleep(1000);

            telemetry.addLine("Driving Backwards");
            telemetry.update();
            blueBot.driveBack(.40, 4);
            sleep(1000);

            telemetry.addLine("Strafe Left");
            telemetry.update();
            blueBot.strafeLeft(.5, 4);
            sleep(1000);

            telemetry.addLine("Strafe Right");
            telemetry.update();
            blueBot.strafeRight(.5, 4);
            sleep(1000);


            // ***** INSERT AUTONOMOUS CODE ABOVE THIS LINE  *****

            idle();
            requestOpModeStop();
        }
    }
}
