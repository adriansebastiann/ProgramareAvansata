package Compulsory;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class Player implements Runnable {

    //a player has a name, a game whose is assigned and a boolean to set his state
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    //here are extracted 7 letters from bag, the letters are concatenated and a word is formed
    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word = generateWord(extracted);
        game.getBoard().addWord(this, word);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String generateWord(List<Tile> tiles) {
        String word = "";
        for (Tile tile : tiles) {
            word += tile.getLetter();
        }
        return word;
    }

    //implement the run method;
    @Override
    public void run() {
        this.submitWord();
    }
}
