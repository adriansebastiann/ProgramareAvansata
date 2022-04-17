package Homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private int playerTurn = 1;
    private final int numberOfTiles = 7;
    private boolean activeGame = true;
    private boolean printTime = false;
    private long startTime;

    //method to add a player to the game
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    //start a new thread for every player
    public void play() {
        startTime = System.currentTimeMillis();
        for (Player player : players) {
            Thread newThread = new Thread(player);
            newThread.start();
        }
        Thread newThread = new Thread(new Daemon(this));
        newThread.setDaemon(true);
        newThread.start();
    }

    //assert if is the turn of a certain player
    public boolean isMyTurn(int player) {
        return player == playerTurn;
    }

    //initialize the player and start the game
    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        int numberOfPlayers = 3;
        game.addPlayer(new Player("Player 1", 1, numberOfPlayers, game));
        game.addPlayer(new Player("Player 2", 2, numberOfPlayers, game));
        game.addPlayer(new Player("Player 3", 3, numberOfPlayers, game));
        game.play();
        while (game.activeGame) {
            Thread.sleep(5000);
        }
        long duration = System.currentTimeMillis();
        System.out.println(game.board);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("The game duration: "
                + formatter.format((duration - game.getStartTime()) / 1000d)
                + " seconds");
    }

}
