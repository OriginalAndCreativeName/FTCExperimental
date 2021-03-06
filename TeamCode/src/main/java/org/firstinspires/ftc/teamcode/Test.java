package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.exponential.blueshift.Blueshift;
import org.exponential.paths.LinearMovement;
import org.exponential.paths.Movement;
import org.exponential.paths.RootMovement;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="Test", group="Autonomous")
public class Test extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        LinearMovement testMove = new LinearMovement(Blueshift.drivetrain.MAXACCEL, Blueshift.drivetrain.MAXDEACCEL,2500,.5f,.1f , LinearMovement.TRAPEZOID);


        Blueshift.initialize(this);
        Blueshift.drivetrain.initializeIMU();
        waitForStart();
        while(opModeIsActive()){
            Blueshift.drivetrain.moveIMU(testMove,0);
            Blueshift.readHub1Data();
            //Blueshift.readHub2Data();
            telemetry.update();
        }
    }
}
