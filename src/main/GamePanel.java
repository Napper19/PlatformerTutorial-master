package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Jframe rappresenta la cornice,Jpanel è il quadro
 */
public class GamePanel extends JPanel {
    int xDelta=100;
    int yDelta=100;
    private MouseInputs mouseInputs;
    public GamePanel(){
        mouseInputs=new MouseInputs(this);
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);

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
        repaint();

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


        g.fillRect ( xDelta, yDelta,200,50);
    }
}
