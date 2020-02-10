import java.awt.*;

public class Square extends Shape{
    private double height, width;

    public Square(int x, int y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
        getBoundingBox().x = (int) x;
        getBoundingBox().y = (int) y;
        getBoundingBox().width = (int) width;
        getBoundingBox().height = (int) height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    double getArea() {
        return this.height*this.width;
    }

}
