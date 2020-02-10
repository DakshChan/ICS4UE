/**
 * This template can be used as reference or a starting point for the Shape Game
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class ShapeGame extends JFrame {
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    static ShapeGame game;
    private GameAreaPanel panel;

    private ArrayList<Enemy> enemies;
    private Player player;

    //main
    public static void main(String[] args) {
        game = new ShapeGame();
    }    
    
    ShapeGame() {
        super("Game Frame");

        //create enemies and player

        //create the panel and add it to the frame
        panel = new GameAreaPanel();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set frame dimensions
        this.setSize(800, 600);

        //set to fullscreen
//        this.setSize(MAX_X,MAX_Y);
        //or
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //remove borders
//        this.setUndecorated(true);
        
        //create and attach a key listener
        this.addKeyListener(new MyKeyListener());
        //make the frame active and visible
        this.requestFocusInWindow();
        this.setVisible(true);

        this.enemies = new ArrayList<Enemy>();

        this.player = new Player(5,5,30);
        for (int i = 0; i < 5; i ++) {
            this.enemies.add(new Enemy((int)(Math.random()*800), (int) (Math.random()*600), (int) (Math.random()*30) + 5, (int) (Math.random()*30) + 5));
        }
    }

    void redraw () {
        panel.repaint();
    }
//------------------------------------------------------------------------------
//  inner class
//------------------------------------------------------------------------------        
    private class GameAreaPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setDoubleBuffered(true); 
            
            //move enemies
            for (Enemy i : enemies) {
                int direction = (int) (Math.random()  * 4);
                if (direction == 0) {
                    i.moveLeft();
                } else if (direction == 1) {
                    i.moveUp();
                } else if (direction == 2) {
                    i.moveRight();
                } else if (direction == 3) {
                    i.moveDown();
                }
                //draw em
                g.setColor(new Color(255, 0, 255));
                g.fillRect((int) i.getX(), (int) i.getY(), i.getBoundingBox().width, i.getBoundingBox().height);
            }


            //collision
            int arraylen = enemies.size()-1;

            if (arraylen == 0){
                System.out.println("Yay!!!!");
                game.dispose();
            }

            for (int i = arraylen; i >= 0; i--){
                if (enemies.get(i).getBoundingBox().intersects(player.getBoundingBox())){
                    //buh bye
                    double newMass = player.getArea() + enemies.get(i).getArea();
                    while (newMass > player.getArea()){
                        player.grow();
                    }
                    enemies.remove(i);

                }
            }

            //draw player

            g.setColor(Color.BLUE);
            g.fillOval((int) player.getX(), (int) player.getY(), player.getBoundingBox().width, player.getBoundingBox().height);

            repaint();
        }
    }
//------------------------------------------------------------------------------
//  inner class
//------------------------------------------------------------------------------     
    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            char keyChar = keyEvent.getKeyChar();
            if(keyChar == 'w' ){
                player.moveUp();
            } else if(keyChar == 'a' ){
                player.moveLeft();
            } else if(keyChar == 's' ){
                player.moveDown();
            } else if(keyChar == 'd' ){
                player.moveRight();
            }
        }
        
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == KeyEvent.VK_ESCAPE){
                System.out.println("Quitting!"); 
                game.dispose(); //close the frame & quit
            }
        }
        
        @Override
        public void keyReleased(KeyEvent keyEvent) {
            
        }
    }
}
