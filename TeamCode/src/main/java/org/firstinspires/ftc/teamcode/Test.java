package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="Test", group="Autonomous")
public class Test extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        LinearMovement testMove = new LinearMovement(.5f,.1f,2500,.1f);


        Robot.initialize(this);
        waitForStart();
        while(opModeIsActive()){
            Robot.dt.move(testMove);
        }


    }
}
