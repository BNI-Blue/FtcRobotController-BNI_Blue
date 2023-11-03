package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.apriltag.AprilTagDetection;

import java.util.List;

// Abstract Main Autonomous Class.  It can only have methods and variables.
public abstract class Auto1_Main_Acker extends LinearOpMode {


    // Common Variables for Both Blue and Red Alliance Auto Pathing
    public enum TEAM_PROP {BLUE_LEFT, BLUE_MIDDLE, BLUE_RIGHT, RED_LEFT, RED_MIDDLE, RED_RIGHT, NONE}
    public TEAM_PROP teamPropPosition = TEAM_PROP.NONE;
    public AprilTagDetection aprilTagOfInterest = null;
    public static final boolean USE_WEBCAM = true;

    public AprilTagProcessor aprilTag;
    public VisionPortal visionPortal;

    // Common Methods for Both Blue and Red Alliance Auto Pathing

    // Method to Initialize Camera for April Tag Detection
    public void initAprilTag(){

        aprilTag = new AprilTagProcessor.Builder()
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        }   else{
            builder.setCamera(BuiltinCameraDirection.FRONT);
        }

        builder.addProcessor(aprilTag);

        visionPortal = builder.build();

    }

    public void telemetryAprilTag() {

        List<org.firstinspires.ftc.vision.apriltag.AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());


        for (org.firstinspires.ftc.vision.apriltag.AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }


        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");
        telemetry.addLine("LONG LIVE TACO");
        if (teamPropPosition == TEAM_PROP.BLUE_LEFT) {
            telemetry.addLine("Tag Position = BLUE_LEFT");
        }
        else if (teamPropPosition == TEAM_PROP.BLUE_MIDDLE) {
            telemetry.addLine("Tag Position = BLUE_MIDDLE");
        }
        else if (teamPropPosition == TEAM_PROP.BLUE_RIGHT) {
            telemetry.addLine("Tag Position = BLUE_RIGHT");
        }
        else if (teamPropPosition == TEAM_PROP.RED_LEFT) {
            telemetry.addLine("Tag Position = RED_LEFT");
        }
        else if (teamPropPosition == TEAM_PROP.RED_MIDDLE){
            telemetry.addLine("Tag Position = RED_MIDDLE ");
        }
        else if (teamPropPosition == TEAM_PROP.RED_RIGHT) {
            telemetry.addLine("Tag Position = RED_RIGHT");
        }
        else if (teamPropPosition == TEAM_PROP.NONE) {
            telemetry.addLine("Tag Position = NONE");
        }


    }

    public void findTag() {
        initAprilTag();
        List<org.firstinspires.ftc.vision.apriltag.AprilTagDetection> currentDetections = aprilTag.getDetections();

        telemetry.addData("# AprilTags Detected", currentDetections.size());


        if (aprilTagOfInterest.id ==  1 ){
            teamPropPosition = TEAM_PROP.BLUE_LEFT;
        }
        else if (aprilTagOfInterest.id == 2) {
            teamPropPosition = TEAM_PROP.BLUE_MIDDLE;
        }
        else if (aprilTagOfInterest.id == 3) {
            teamPropPosition = TEAM_PROP.BLUE_RIGHT;
        }
        else if (aprilTagOfInterest.id == 4) {
            teamPropPosition = TEAM_PROP.RED_LEFT;
        }
        else if (aprilTagOfInterest.id == 5) {
            teamPropPosition = TEAM_PROP.RED_MIDDLE;
        }
        else if (aprilTagOfInterest.id == 6) {
            teamPropPosition = TEAM_PROP.RED_RIGHT;
        }
        else {
            teamPropPosition = TEAM_PROP.NONE;
        }

    }

    public void detectTags() {
        findTag();
        sleep(500);
        findTag();
        sleep(500);
        findTag();
        sleep(500);
        visionPortal.close();
        sleep(500);
    }

}
