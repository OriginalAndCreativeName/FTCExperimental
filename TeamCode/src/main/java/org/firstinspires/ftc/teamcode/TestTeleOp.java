package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="DriverControlled", group="Teleop")

public class TestTeleOp extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        Robot.initialize(this);
        waitForStart();
        while(opModeIsActive()){
            float leftPower = Range.clip(-gamepad1.left_stick_y+gamepad1.right_stick_x,-1,1);
            float rightPower = Range.clip(-gamepad1.left_stick_y-gamepad1.right_stick_x,-1,1);
            Robot.dt.runMotors(rightPower/2, rightPower/2, leftPower/2, leftPower/2);
        }
    }
}
