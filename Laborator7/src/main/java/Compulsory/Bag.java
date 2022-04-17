package Compulsory;

import lombok.Getter;

import java.util.*;

/**
 * This class will store the letters from the game
 */
@Getter
public class Bag {

    //a list with the tiles representing the letters with the associated points
    private List<Tile> letters;

    //here is generated the list, 10 occurrences of each letter with random value from 1 to 10
    public Bag() {
        Random random = new Random();
        letters = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
            int value = random.nextInt() % 11;
            for(int index = 0; index < 10; index ++) {
                letters.add(new Tile(c, value));
            }
        }
        Collections.shuffle(letters);
    }

    //extract a tile from the list, add to extracted and remove from the initial list
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(i));
            letters.remove(letters.get(i));
        }
        return extracted;
    }

    public void fillTheBagWithHomeworksContent() {

    }
}
