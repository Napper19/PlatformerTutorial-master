package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow  {
    private JFrame jFrame;
    //constructor
    public GameWindow(GamePanel gamePanel){
        jFrame=new JFrame();


        /**
         * Metodo per settare la size della finestra
         *  jFrame.setSize(400,400);
         */



        /**
         * metodo che permette di chiudere l'operazione se chiudi la finestra
         * a seconda dell'integer passato fa diverse operazioni
         */
        jFrame.setDefaultCloseOperation(3);

         jFrame.add(gamePanel);

        /**
         * mette la game window al centro dello schermo
         */
        jFrame.setLocationRelativeTo(null);


        jFrame.setResizable(false);

        /**
         * con questo metodo diciamo a jframe di aggiustare la size della finestra con quella dei suoi componenti(ne abbiamo solo uno,jpanel 1200 x 800)
         */
        jFrame.pack();

        /**
         * metodo per vedere la finestra,è settata di default a false altrimenti
         * setVisible è un metodo che deve stare sempre SOTTO !!
         * Altrimenti potresti avere problemi
         */
        jFrame.setVisible(true);



    }
}
