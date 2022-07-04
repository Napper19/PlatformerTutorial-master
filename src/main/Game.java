package main;

public class Game implements Runnable {
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS_SET = 120;


    //constructor
    public Game(){
        gamePanel = new GamePanel();
        gameWindow=new GameWindow(gamePanel);

        /**
         * Request that this Component gets the input focus.
         */
        gamePanel.requestFocus();

        startGameLoop();


    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        //infinite loop
        while (true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }


            /**
             * se è passato un secondo dall'ultimo fps check,facciamo un nuovo check
             * salviamo il newfps check come lastFps check e ripetiamo
             */
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }

    }
}
