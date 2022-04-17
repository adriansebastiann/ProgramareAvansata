package Compulsory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {

        //create a thread for every player and start them
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            Thread newThread = new Thread(player);
            threads.add(newThread);
        }
        while (bag.getLetters().size() > 20) {
            for (Thread thread : threads) {
//                thread.start();
                thread.run();
            }
        }
    }

    //created some objects and run the game
    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}
