public class Enemy extends Square implements Moveable{
    public Enemy(int x, int y, double height, double width) {
        super(x, y, height, width);
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
}
