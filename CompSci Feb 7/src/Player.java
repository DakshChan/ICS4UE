public class Player extends Circle implements Moveable, Scalable{

    public Player(int x, int y, double radius) {
        super(x, y, radius);
    }

    @Override
    public void moveUp() {
        setY(getY()-5);
    }

    @Override
    public void moveDown() {
        setY(getY()+5);
    }

    @Override
    public void moveLeft() {
        setX(getX()-5);
    }

    @Override
    public void moveRight() {
        setX(getX()+5);
    }

    @Override
    public void grow() {
        getBoundingBox().grow(1,1);
        setRadius(getRadius()+1);
    }

    @Override
    public void shrink() {
        getBoundingBox().grow(-1,-1);
        setRadius(getRadius()-1);
    }
}
