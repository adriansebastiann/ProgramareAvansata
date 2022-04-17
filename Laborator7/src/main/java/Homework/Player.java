package Homework;

import lombok.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    private int numberOfPlayers;
    private int numberOfPlayer;
    private List<TileWithPoint> playerTiles = new ArrayList<>();
    private int numberOfTiles = 0;
    private int howManiTilesToExtract = 7;

    public Player(String name, int number, int numberOfPlayers, Game game) {
        this.name = name;
        this.numberOfPlayer = number;
        this.numberOfPlayers = numberOfPlayers;
        this.game = game;
    }

    //here the word is subbmited
    //is checked if it is valid
    //if it is valid, the letters are deleted and the points are assigned to the player
    //then the turn is changed to another player
    private boolean submitWord() {
        howManiTilesToExtract = game.getNumberOfTiles() - numberOfTiles;
        List<TileWithPoint> extracted = game.getBag().extractTiles(howManiTilesToExtract);
        numberOfTiles = numberOfTiles + howManiTilesToExtract;
        playerTiles.addAll(extracted);
        if (extracted.isEmpty()) {
            return false;
        }
        String word = getWordFromPlayer(playerTiles);
        int pointsForWord = 0;
        if (game.getDictionary().isWord(word)) {
            System.out.println("It's a valid word!");
            int tilesUsed = 0;
            for (int index = 0; index < word.length(); index++) {
                for (TileWithPoint tile : playerTiles) {
                    if (tile.getLetter() == word.charAt(index)) {
                        pointsForWord = pointsForWord + tile.getPoints();
                        playerTiles.remove(tile);
                        tilesUsed += 1;
                        break;
                    }
                }
            }
            numberOfTiles = numberOfTiles - tilesUsed;
        } else {
            System.out.println("Isn't a valid word! All tiles are Replaced.");
            playerTiles = new ArrayList<>();
            numberOfTiles = 0;
        }
        game.getBoard().addWord(this, pointsForWord);
        try {
            game.setPrintTime(true);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int nextPlayer = (this.numberOfPlayer + 1) % (numberOfPlayers + 1);
        if (nextPlayer == 0) {
            nextPlayer = 0;
        } else {
            System.out.println("Player turn: " + game.getPlayerTurn());
        }
        game.setPlayerTurn(nextPlayer);

        return true;
    }

    //here is generated a random word by concatenating all extracted letters
    private String generateWord(List<TileWithPoint> tiles) {
        String word = "";
        for (TileWithPoint tile : tiles) {
            word += tile.getLetter();
        }
        return word;
    }

    //the player writes in console a word and then the verifications are made
    //if it is a valid word we delete the words used for that word and extract new tiles
    //the number of extracted tiles is equal to the length of submitted word
    private String getWordFromPlayer(List<TileWithPoint> tiles) {
        StringBuilder letters = new StringBuilder();
        for (TileWithPoint tile : tiles) {
            letters.append(tile.getLetter());
        }
        String allLetters = letters.toString();
        System.out.println("Letters available: " + allLetters);
        System.out.print("Please insert a word: ");
        String wordFromInput = "";

        while (true) {
            boolean validWord = true;
            StringBuilder lettersAvailable = new StringBuilder(letters);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                wordFromInput = reader.readLine().toUpperCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < wordFromInput.length(); i++) {
                if (!validWord) {
                    break;
                }
                for (int j = 0; j < lettersAvailable.length(); j++) {
                    if (lettersAvailable.indexOf(String.valueOf(wordFromInput.charAt(i))) == -1) {
                        validWord = false;
                        break;
                    }
                    if (lettersAvailable.charAt(j) == wordFromInput.charAt(i)) {
                        lettersAvailable.deleteCharAt(j);
                        break;
                    }
                }
            }
            if (validWord) {
                break;
            }
        }
        return wordFromInput;
    }


    //implement the run method;
    //if it's my turn then I get my letters and submit a word
    @Override
    public void run() {
        synchronized (game) {
            while (game.getBag().getLetters().size() >= howManiTilesToExtract) {
                if (game.isMyTurn(this.numberOfPlayer)) {
                    this.submitWord();
                    game.notifyAll();
                } else {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Game over!");
        game.setActiveGame(false);
    }
}
