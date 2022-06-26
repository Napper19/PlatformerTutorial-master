package main;

public class Game {
    private GamePanel gamePanel;
    private GameWindow gameWindow;


    //constructor
    public Game(){
        gamePanel = new GamePanel();
        gameWindow=new GameWindow(gamePanel);

        /**
         * Request that this Component gets the input focus.
         */
        gamePanel.requestFocus();


    }
}
