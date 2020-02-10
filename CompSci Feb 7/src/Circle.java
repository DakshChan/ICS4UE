import java.awt.*;

public class Circle extends Shape{
    private double radius;

    public Circle(double x, double y, double radius) {
        super((int)x, (int)y);
        this.radius = radius;
        getBoundingBox().x = (int) x;
        getBoundingBox().y = (int) y;
        getBoundingBox().height = (int) radius * 2;
        getBoundingBox().width = (int) radius * 2;
    }

    @Override
    double getArea() {
        return (Math.PI * this.radius * this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
