package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {
    public static TankDrivetrain dt = new TankDrivetrain();
    public static ElapsedTime clock = new ElapsedTime();
    static Subsystem[] subsystems = {dt};
    public static void initialize(OpMode opMode){
        for(int i=0; i<subsystems.length; i++){
            subsystems[i].initialize(opMode);
        }
    }
    
}
