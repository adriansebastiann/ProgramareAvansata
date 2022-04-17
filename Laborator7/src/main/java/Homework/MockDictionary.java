package Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class MockDictionary extends Dictionary {

    List<String> acceptedWords;
    List<String> wordsThatStartWithGivenPrefix;

    //generate a list with all the words from a generated file with words
    public MockDictionary() {
        acceptedWords = new ArrayList<>();
        wordsThatStartWithGivenPrefix = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("src/main/resources/words.txt"));
            while (s.hasNext()){
                acceptedWords.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //is checked if the list contains a specific word
    public boolean isWord(String str) {
        return acceptedWords.contains(str);
    }



    //-----------------BONUS------------------//

    //Here is verified if the list contains words that start with a specified prefix
    public List<String> getWordsFromDictionaryStartingWith(String prefix) {
        wordsThatStartWithGivenPrefix.clear();
        for(String word : acceptedWords) {
            if(word.startsWith(prefix)) {
                wordsThatStartWithGivenPrefix.add(word);
            }
        }
        return wordsThatStartWithGivenPrefix;
    }

    //here the search for words with a prefix is done by 4 threads
    //the whole lis is divided in 4 little lists
    //are used for threads to search in every new list
    public void multiThreadedSearch(String prefix) {
        final int size = acceptedWords.size();
        List<String> str1 = acceptedWords.subList(0, size / 4);
        List<String> str2 = acceptedWords.subList(size / 4, size / 2);
        List<String> str3 = acceptedWords.subList(size / 2, 3 * (size / 4));
        List<String> str4 = acceptedWords.subList(3 * (size / 4), size - 1);

        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(search(str1, prefix));
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(search(str2, prefix));
        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(search(str3, prefix));
        CompletableFuture<Void> cf4 = CompletableFuture.runAsync(search(str4, prefix));

        CompletableFuture.anyOf(cf1, cf2, cf3, cf4).join();
    }

    //using streams to easily search into the lists
    private static Runnable search(List<String> list, String searchString) {
        return () -> list.stream().filter(x -> x.startsWith(searchString)).findFirst().ifPresent(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("List: " + list);
        });
    }

    //nothing to see here
    @Override
    public int size() {
        return acceptedWords.size();
    }

    @Override
    public boolean isEmpty() {
        return acceptedWords.isEmpty();
    }

    @Override
    public Enumeration keys() {
        return null;
    }

    @Override
    public Enumeration elements() {
        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }
}
