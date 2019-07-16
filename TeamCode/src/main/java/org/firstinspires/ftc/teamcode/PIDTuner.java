package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="PIDTuner", group="TeleOp")

public class PIDTuner extends LinearOpMode {
    float p;
    float i;
    float d;
    boolean upPrev;
    boolean downPrev;
    @Override

    public void runOpMode() throws InterruptedException {
        waitForStart();
            while(!gamepad1.a && opModeIsActive()){
                if(gamepad1.x){
                    if(gamepad1.dpad_up==true && upPrev==false){
                        p+=.002;
                    }
                    if(gamepad1.dpad_down==true && downPrev==false){
                        p-=.002;
                    }
                }
                else if(gamepad1.y){
                    if(gamepad1.dpad_up==true && upPrev==false){
                        i+=.001;
                    }
                    if(gamepad1.dpad_down==true && downPrev==false){
                        i-=.001;
                    }
                }
                else if(gamepad1.b){
                    if(gamepad1.dpad_up==true && upPrev==false){
                        d+=.001;
                    }
                    if(gamepad1.dpad_down==true && downPrev==false){
                        d-=.001;
                    }
                }
                telemetry.update();
            }
            upPrev=gamepad1.dpad_up;
            downPrev=gamepad1.dpad_down;
        }
}
