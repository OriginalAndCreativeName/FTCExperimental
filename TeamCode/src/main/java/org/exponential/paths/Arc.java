package org.exponential.paths;

public class Arc extends PathComponent{
    private float radius;
    private float degrees;
    public Arc(float radius, float degrees){
        this.radius = radius;
        this.degrees = degrees;
    }

    public float getCurvature(){
        return (degrees/Math.abs(degrees))*(float)(360f / (2f * Math.PI * radius));
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public float getDegrees() {
        return degrees;
    }

    @Override
    public float getDistance() {
        return (float)((2f * Math.PI * radius) * (Math.abs(degrees)/360f)) ;
    }

    @Override
    public float getHeading(float distance) {
        return this.getCurvature()*distance;
    }
}
