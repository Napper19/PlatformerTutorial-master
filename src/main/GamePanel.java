package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Jframe rappresenta la cornice,Jpanel è il quadro
 */
public class GamePanel extends JPanel {
    private float xDelta=100;
    private float yDelta=100;
    private float xDir = 0.003f, yDir = 1f;
    private int frames;
    private long lastCheck = 0;
    private Color color = new Color(150,20,90);
    private Random random;

    private MouseInputs mouseInputs;
    public GamePanel(){
        random = new Random();
        mouseInputs=new MouseInputs(this);
        setPanelSize();
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);

    }

    /**
     * total size will be a bit larger than the size set in jpanel
     */
    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }
    public void changeYDelta(int value){
         this.yDelta += value;
         repaint();
    }

    /**
     * metodo in cui diciamo qui posizioneremo il rettangolo
     */
    public void setRectPos(int x,int y){
        this.xDelta = x;
        this.yDelta = y;


    }


    /**
     * metodo particolare,viene chiamato ogni volta che iniziamo il gioco
     * graphics ci permette di disegnare,è come se graphics fosse il penello
     * e jpanel gli dice dove può disegnare
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        //devi chiamare il super metodo altrimenti potresti avere errori con i frame precedenti
        super.paint(g);


        updateRectangle();
        g.setColor(color);
        g.fillRect ((int) xDelta,(int) yDelta,200,50);





        /**
         * metodo che richiama paint
         * repaint();
          */

    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

        private Color getRndColor () {
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);

            return new Color(r, g, b);
        }
    }
