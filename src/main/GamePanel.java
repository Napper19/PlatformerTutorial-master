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
    private BufferedImage img;
    private BufferedImage[] idleAni;
    private int aniTick, aniIndex, aniSpeed = 15;


    public GamePanel(){

        mouseInputs=new MouseInputs(this);
        importImg();
        loadAnimations();
        setPanelSize();
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);

    }

    /**
     * carichiamo l'array di animazioni
     */
    private void loadAnimations() {
        idleAni = new BufferedImage[5];

        for(int i = 0; i < idleAni.length; i++)
            idleAni[i] = img.getSubimage(i*64,0,64,40);
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

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= idleAni.length)
                aniIndex = 0;
        }

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


        updateAnimationTick();




        g.drawImage(idleAni[aniIndex],(int)xDelta,(int)yDelta,128,80,null);



    }




}
