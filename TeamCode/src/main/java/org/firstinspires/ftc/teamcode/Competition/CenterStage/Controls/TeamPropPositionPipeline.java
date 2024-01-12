package org.firstinspires.ftc.teamcode.Competition.CenterStage.Controls;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class TeamPropPositionPipeline extends OpenCvPipeline {

    //Instance Variables for Team Alliance Color and Threshold
    public String teamAlliance;
    public double colorThreshold;

    // Constants for the Color Boxes
    static final Scalar BLUE = new Scalar(0, 0, 255);
    static final Scalar GREEN = new Scalar(0, 255, 0);
    static final Scalar RED = new Scalar(255, 0, 0);

    // Constants for the Points to draw a box
    static final Point REGION1_TOPLEFT_ANCHOR_POINT = new Point(35, 370);
    static final Point REGION2_TOPLEFT_ANCHOR_POINT = new Point(390, 320);
    static final Point REGION3_TOPLEFT_ANCHOR_POINT = new Point(760, 350);
    static final int REGION_WIDTH = 200;
    static final int REGION_HEIGHT = 200;

    // Constructor for handling different team alliances and color thresholds
    // Not a Default Constructor
    public TeamPropPositionPipeline(String alliance,double threshold) {
        teamAlliance = alliance;
        colorThreshold = threshold;

    }

    // Bounding Box Geometry
    Point region1_pointA = new Point(REGION1_TOPLEFT_ANCHOR_POINT.x, REGION1_TOPLEFT_ANCHOR_POINT.y);
    Point region1_pointB = new Point(REGION1_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION1_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
    Point region2_pointA = new Point(REGION2_TOPLEFT_ANCHOR_POINT.x, REGION2_TOPLEFT_ANCHOR_POINT.y);
    Point region2_pointB = new Point(REGION2_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION2_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);
    Point region3_pointA = new Point(REGION3_TOPLEFT_ANCHOR_POINT.x, REGION3_TOPLEFT_ANCHOR_POINT.y);
    Point region3_pointB = new Point(REGION3_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, REGION3_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);

    // Image Matrices and Variables for Detecting Object
    Mat YCrCb = new Mat();
    Mat region1Chan, region2Chan, region3Chan;
    Mat chan = new Mat();

    // Volatile variable to accomodate threading w/o synchronization
    // Defaults to TWO
    public volatile TeamPropPosition position = TeamPropPosition.TWO;

    // Method to convert RGB to YCrCb to eliminate lighting, luminosty differences
    // Method to extract the the Cr channel and the Cb channel
    void inputToCbCr(Mat input) {
        Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_RGB2YCrCb);

        if (teamAlliance.equals("BLUE")) {
            Core.extractChannel(YCrCb, chan, 2); //Index 2 is Cb Channel (Blue)
        } else {
            Core.extractChannel(YCrCb, chan, 1); //Index 1 is Cr Channel (Red)
        }
    }

    // Initialize the Image Matrices and Initialize the Object Detection
    @Override
    public void init(Mat firstFrame) {

        inputToCbCr(firstFrame);

        region1Chan = chan.submat(new Rect(region1_pointA, region1_pointB));
        region2Chan= chan.submat(new Rect(region2_pointA, region2_pointB));
        region3Chan = chan.submat(new Rect(region3_pointA, region3_pointB));

    }

    @Override
    public Mat processFrame(Mat input) {

        inputToCbCr(input);

        // Draw Rectangles of Detection Areas
        Imgproc.rectangle(input, region1_pointA, region1_pointB, BLUE, 2);
        Imgproc.rectangle(input, region2_pointA, region2_pointB, BLUE, 2);
        Imgproc.rectangle(input, region3_pointA, region3_pointB, BLUE, 2);

        // Apply thresholding to the channel ( Above threshold will get white pixels, below threshold will get black)
        Imgproc.threshold(region1Chan, region1Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);
        Imgproc.threshold(region2Chan, region2Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);
        Imgproc.threshold(region3Chan, region3Chan, colorThreshold, 255, Imgproc.THRESH_BINARY);

        // Counts  White Pixels
        int area1 = Core.countNonZero(region1Chan);
        int area2 = Core.countNonZero(region2Chan);
        int area3 = Core.countNonZero(region3Chan);

        // Determine Area of with Most White Pixels
        int maxArea = Math.max(area1, Math.max(area2, area3));

        // Determine which area equals the max area and place a solid green box over it.

        if (teamAlliance.equals("BLUE")) {
            if (maxArea == area1) {
                position = TeamPropPosition.ONE;
                Imgproc.rectangle(input, region1_pointA, region1_pointB, GREEN, -1);
            } else if (maxArea == area2) {
                position = TeamPropPosition.TWO;
                Imgproc.rectangle(input, region2_pointA, region2_pointB, GREEN, -1);
            } else {
                position = TeamPropPosition.THREE;
                Imgproc.rectangle(input, region3_pointA, region3_pointB, GREEN, -1);
            }
            return input;
        }
        else {
            if (maxArea == area1) {
                position = TeamPropPosition.FOUR;
                Imgproc.rectangle(input, region1_pointA, region1_pointB, GREEN, -1);
            } else if (maxArea == area2) {
                position = TeamPropPosition.FIVE;
                Imgproc.rectangle(input, region2_pointA, region2_pointB, GREEN, -1);
            } else {
                position = TeamPropPosition.SIX;
                Imgproc.rectangle(input, region3_pointA, region3_pointB, GREEN, -1);
            }
            //delete the line below for actual auto
            position = TeamPropPosition.FIVE;
            //delete the line above for actual auto
            return input;
        }
    }

    // Return the Team Prop Position after image frame analysis
    public TeamPropPosition getAnalysis()
    {
        return position;
    }

}


