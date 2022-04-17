package Homework;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Board {

    //HashMap used for storage of the score for each player
    private HashMap<String, Integer> scores;

    //a hashmap for storing the player and the currently formed words
    private HashMap<Player, List<String>> words;

    public Board() {
        words = new HashMap<>();
    }

    //here we add a word to each player's list
    public synchronized void addWord(Player player, String word) {
        if(!words.containsKey(player)) {
            List newList = new ArrayList<>();
            newList.add(word);
            words.put(player, newList);
        } else {
            words.get(player).add(word);
        }
        System.out.println(player.getName() + ": " + word);
    }

    //add a word to the board and update the player's score
    public synchronized void addWord(Player player, int score) {
        int actualScore = 0;
        if (!scores.containsKey(player.getName())) {
            scores.put(player.getName(), score);
            actualScore = score;
        } else {
            actualScore = scores.get(player.getName());
            actualScore = actualScore + score;
            scores.put(player.getName(), actualScore);
        }
        System.out.println(player.getName() + " current score: " + actualScore);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}