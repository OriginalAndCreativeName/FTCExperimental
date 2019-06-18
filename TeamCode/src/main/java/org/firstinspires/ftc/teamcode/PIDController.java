package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {
    private float kP;
    private float kI;
    private float kD;
    private ElapsedTime PIDClock;
    float prevError = 0;
    float i = 0;

    PIDController(float kP, float kI, float kD){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }
    public void start(){
        PIDClock = new ElapsedTime();
        prevError = 0;
        float i = 0;
    }
    public void reset(){
        start();
    }

    //ideally called every loop, don't wait too long between calls unless running p loop
    public float getValue(float target, float actual){
        if (PIDClock==null){
            start();
        }
        float error = target - actual;
        float p = error;
        i += (float)(error*PIDClock.milliseconds()/1000f);
        float d = (float)((error-prevError)/ (PIDClock.milliseconds()/1000f));
        prevError=error;
        PIDClock.reset();
        return kP*p + kI*i + kD*d;
    }
}