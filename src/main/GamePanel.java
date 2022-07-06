package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


/**
 * Jframe rappresenta la cornice,Jpanel è il quadro
 */
public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta=100, yDelta = 100;
    private BufferedImage img, subImg;


    public GamePanel(){

        mouseInputs=new MouseInputs(this);
        importImg();
        setPanelSize();
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);

    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
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



        subImg = img.getSubimage(1*64,8*40,64,40);
        g.drawImage(subImg,(int)xDelta,(int)yDelta,128,80,null);



    }


    }
