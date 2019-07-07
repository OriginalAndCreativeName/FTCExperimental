package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.exponential.paths.Movement;
import org.exponential.superclasses.Drivetrain;
import org.exponential.superclasses.Robot;
import org.exponential.util.PIDController;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.openftc.revextensions2.ExpansionHubMotor;

public class TankDrivetrain extends Drivetrain {
    Robot robot;
    public static final float MAXACCEL = .002f;
    public static final float MAXDEACCEL = 0.00035f;
    //private Orientation targetHeading = new Orientation();
    private Orientation currentHeading;
    private Position currentPosition = new Position();
    private Position targetPosition = new Position();
    private OpMode opMode;
    private ExpansionHubMotor lFront;
    private ExpansionHubMotor rFront;
    private ExpansionHubMotor lBack;
    private ExpansionHubMotor rBack;
    private BNO055IMU imu;
    float initialHeading;
    float initialPitch;
    float initialRoll;
    PIDController headingController;
    //Orientation orientation = new Orientation();

    TankDrivetrain(){
    }

    public void translate (float direction, float distance){

    }

    public void move(Movement movement){
        runMotors(
                movement.RFrontCurve.getValue(getRightPos()),
                movement.LFrontCurve.getValue(getLeftPos())
        );
    }

    public int getRightPos(){
        return (Robot.getHub1().getBulkInputData().getMotorCurrentPosition(rFront)+Robot.getHub1().getBulkInputData().getMotorCurrentPosition(rBack))/2;
    }
    public int getLeftPos(){
        return (Robot.getHub1().getBulkInputData().getMotorCurrentPosition(lFront)+Robot.getHub1().getBulkInputData().getMotorCurrentPosition(lBack))/2;
    }

    public void resetAllEncoders(){
        lFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setAllRunUsingEncoders(){
        lFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void waitAllMotors(){
        while(lFront.isBusy() || rFront.isBusy() || lBack.isBusy() || rBack.isBusy()){
        }
    }

    public void runMotors(float right,float left){
        lFront.setPower(Range.clip(left,-1,1));
        lBack.setPower(Range.clip(left, -1, 1));
        rFront.setPower(Range.clip(right,-1,1));
        rBack.setPower(Range.clip(right,-1,1));
    }

    public void initializeIMU() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(parameters);
        if(opMode.getClass()==LinearOpMode.class){
            while (((LinearOpMode)opMode).opModeIsActive() && !imu.isGyroCalibrated()) ;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resetOrientation();
    }

    public void updateOrientation() {
        currentHeading = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
    }

    public void resetOrientation(){
        updateOrientation();
        initialHeading = currentHeading.firstAngle;
        initialRoll = currentHeading.secondAngle;
        initialPitch = currentHeading.thirdAngle;
    }

    public void driveIMU(float targetHeading, float power){
        if(headingController == null){
            headingController = new PIDController(.005f ,0 ,0);
            headingController.start();
        }
        updateOrientation();
        float correction =  headingController.getValue(targetHeading, currentHeading.firstAngle - initialHeading);
        opMode.telemetry.addData("current", currentHeading.firstAngle - initialHeading);
        opMode.telemetry.addData("1st angle", currentHeading.firstAngle);
        opMode.telemetry.addData("initial", initialHeading);
        opMode.telemetry.addData("correction", correction);
        runMotors(power + correction, power - correction);

    }

    @Override
    public void initialize(OpMode opMode) {
        this.opMode = opMode;
        lFront = (ExpansionHubMotor)opMode.hardwareMap.get(DcMotor.class, "lFront");
        rFront = (ExpansionHubMotor)opMode.hardwareMap.get(DcMotor.class, "rFront");
        lBack = (ExpansionHubMotor)opMode.hardwareMap.get(DcMotor.class, "lBack");
        rBack = (ExpansionHubMotor)opMode.hardwareMap.get(DcMotor.class, "rBack");
        lFront.setDirection(DcMotor.Direction.REVERSE);
        lBack.setDirection(DcMotor.Direction.REVERSE);
        resetAllEncoders();
        waitAllMotors();
        setAllRunUsingEncoders();
        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
    }
}
