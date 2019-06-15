package org.firstinspires.ftc.teamcode;

public class LinearMovement extends Movement {
    LinearMovement(float maxPower, float maxPowerPercent, float distance){
        LBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        RBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        LFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);
        RFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, .05f);

    }

    LinearMovement(float maxPower, float maxPowerPercent, float distance, float bias){
        LBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        RBackCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        LFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);
        RFrontCurve = new TrapezoidalCurve(distance,  distance*maxPowerPercent, maxPower, bias);

    }

    @Override
    void generateCurves() {

    }
}
