package Homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class will store the letters from the game
 */
@Getter
public class Bag {

    //a list with the tiles representing the letters with the associated points
    private List<TileWithPoint> letters;

    //here is generated the list, 10 occurrences of each letter with random value from 1 to 10
    public Bag() {
        this.letters = new ArrayList<>();
        fillTheBagWithHomeworksContent(this.letters);
        Collections.shuffle(this.letters);
    }

    //extract a tile from the list, add to extracted and remove from the initial list
    public synchronized List<TileWithPoint> extractTiles(int howMany) {
        Random rand = new Random();
        TileWithPoint tile;
        List<TileWithPoint> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            tile = letters.get(rand.nextInt(this.letters.size()));
            if(tile.getOccurrences() > 0) {
                extracted.add(tile);
                tile.decreaseOccurrences();
            }
            if(tile.getOccurrences() == 0) {
                letters.remove(tile);
            }
        }
        return extracted;
    }

    //populate the bag with the criteria from exercise
    private void fillTheBagWithHomeworksContent(List<TileWithPoint> letters) {
        this.letters.add(new TileWithPoint('A',9,1));
        this.letters.add(new TileWithPoint('B',2, 3));
        this.letters.add(new TileWithPoint('C',2, 3));
        this.letters.add(new TileWithPoint('D',4, 2));
        this.letters.add(new TileWithPoint('E',12, 1));
        this.letters.add(new TileWithPoint('F',2,4));
        this.letters.add(new TileWithPoint('G',3, 2));
        this.letters.add(new TileWithPoint('H',2, 4));
        this.letters.add(new TileWithPoint('I',9,1));
        this.letters.add(new TileWithPoint('J',1, 8));
        this.letters.add(new TileWithPoint('K',1, 5));
        this.letters.add(new TileWithPoint('L',4, 1));
        this.letters.add(new TileWithPoint('M',2, 3));
        this.letters.add(new TileWithPoint('N',6, 1));
        this.letters.add(new TileWithPoint('O',8, 1));
        this.letters.add(new TileWithPoint('P',2, 3));
        this.letters.add(new TileWithPoint('Q',1, 10));
        this.letters.add(new TileWithPoint('R',6, 1));
        this.letters.add(new TileWithPoint('S',4, 1));
        this.letters.add(new TileWithPoint('T',6, 1));
        this.letters.add(new TileWithPoint('U',4, 1));
        this.letters.add(new TileWithPoint('V',2, 4));
        this.letters.add(new TileWithPoint('W',2, 4));
        this.letters.add(new TileWithPoint('X',1,8));
        this.letters.add(new TileWithPoint('Y',2, 4));
        this.letters.add(new TileWithPoint('Z',1, 10));
    }

    public int getNumberOfLetters(){
        int number = 0;
        for(TileWithPoint tile : letters) {
            number += tile.getOccurrences();
        }
        return number;
    }
}
