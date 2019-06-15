package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class Drivetrain extends Subsystem {
    public static final float MAXACCEL = .001f;
    public static final float MAXDEACCEL = 0.0005f;
    private Orientation targetHeading = new Orientation();
    private Orientation currentHeading = new Orientation();
    private Position currentPosition = new Position();
    private Position targetPosition = new Position();
    OpMode opMode;
    DcMotorEx lFront;
    DcMotorEx rFront;
    DcMotorEx lBack;
    DcMotorEx rBack;


    Drivetrain(){

    }
    public void translate (float direction, float distance){

    }
    public void move(Movement movement){
        lFront.setPower(movement.LFrontCurve.getValue(lFront.getCurrentPosition()));
        rFront.setPower(movement.RFrontCurve.getValue(rFront.getCurrentPosition()));
        lBack.setPower(movement.LFrontCurve.getValue(lFront.getCurrentPosition()));
        rBack.setPower(movement.RFrontCurve.getValue(rFront.getCurrentPosition()));

        //lBack.setPower(movement.LFrontCurve.getValue(lBack.getCurrentPosition()));
        //rBack.setPower(movement.RFrontCurve.getValue(rBack.getCurrentPosition()));

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

    public void runMotors(float rFrontPow,float rBackPow, float lFrontPow, float lBackPow){
        lFront.setPower(lFrontPow);
        lBack.setPower(lBackPow);
        rFront.setPower(rFrontPow);
        rBack.setPower(rBackPow);
    }


    @Override
    public void initialize(OpMode opMode) {
        this.opMode = opMode;
        lFront = (DcMotorEx)opMode.hardwareMap.get(DcMotor.class, "lFront");
        rFront = (DcMotorEx)opMode.hardwareMap.get(DcMotor.class, "rFront");
        lBack = (DcMotorEx)opMode.hardwareMap.get(DcMotor.class, "lBack");
        rBack = (DcMotorEx)opMode.hardwareMap.get(DcMotor.class, "rBack");
        lFront.setDirection(DcMotor.Direction.REVERSE);
        lBack.setDirection(DcMotor.Direction.REVERSE);

        resetAllEncoders();
        setAllRunUsingEncoders();


    }
}
