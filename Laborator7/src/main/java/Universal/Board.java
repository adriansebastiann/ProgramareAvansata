package Universal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

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

    @Override
    public String toString() {
        return words.toString();
    }
}