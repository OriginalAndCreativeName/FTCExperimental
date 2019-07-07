package org.exponential.paths;

public class LinearMovement extends Movement {
    public LinearMovement(float maxPower, float maxPowerPercent, float distance){
        LBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        RBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        LFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        RFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);

    }

    /*LinearMovement(float maxPower, float maxPowerPercent, float distance, float bias){
        LBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        RBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        LFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        RFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);

    }*/

    public LinearMovement(float maxAccel, float maxDeaccel, int distance, float max, float bias){
        LBackCurve = new TrapezoidalCurve(maxAccel,  maxDeaccel, distance, max, bias);
        RBackCurve = new TrapezoidalCurve(maxAccel,  maxDeaccel, distance, max, bias);
        LFrontCurve = new TrapezoidalCurve(maxAccel,  maxDeaccel, distance, max, bias);
        RFrontCurve = new TrapezoidalCurve(maxAccel,  maxDeaccel, distance, max, bias);

    }

    @Override
    void generateCurves() {

    }
}
