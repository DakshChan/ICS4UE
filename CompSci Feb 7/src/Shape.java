import java.awt.*;

public abstract class Shape {
    private int x, y;
    private Rectangle boundingBox = new Rectangle();

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = (int)x;
        this.boundingBox.x = this.x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = (int)y;
        this.boundingBox.y = this.y;
    }

    abstract double getArea();

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.boundingBox = boundingBox;
    }



}
