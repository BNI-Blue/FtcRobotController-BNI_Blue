package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Competition.CenterStage.Robots.MetalBot;

@TeleOp (name = "MecTeleOp")
public class MecTeleOp extends OpMode {

    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightLeftSpeed;

    double powerThreshold = 0;
    double speedMultiply = 1;

    public MetalBot MecBot = new MetalBot();

    @Override
    public void init(){MecBot.initRobot(hardwareMap);}
    @Override
    public void loop(){};

}
