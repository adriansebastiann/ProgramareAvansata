package Homework;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * This class is used for timing and printing the time
 */
public class Daemon implements Runnable {

    private final Game game;

    public Daemon(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        synchronized (game) {
            do {
                if (game.isMyTurn(0) && game.isPrintTime()) {
                    long duration = System.currentTimeMillis();
                    NumberFormat formatter = new DecimalFormat("#0.00000");
                    System.out.println("Time since the start of the game: "
                            + formatter.format((duration - game.getStartTime()) / 1000d)
                            + " seconds");
                    game.setPrintTime(false);
                    game.notifyAll();
                    game.setPlayerTurn(1);

                } else {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } while (game.isActiveGame());
        }
    }

}
