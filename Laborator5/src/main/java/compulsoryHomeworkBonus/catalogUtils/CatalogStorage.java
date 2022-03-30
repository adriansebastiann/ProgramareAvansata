package compulsoryHomeworkBonus.catalogUtils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import compulsoryHomeworkBonus.Catalog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is used to store and get the storage from a file
 */

public class CatalogStorage {
    public static void saveCatalogToFile(Catalog catalog){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PrintWriter file = new PrintWriter("C:\\Users\\aditu\\OneDrive\\Desktop\\ProgramareAvansata\\Laborator5\\src\\main\\resources\\catalog.txt");
            file.println(gson.toJson(catalog));
            file.close();
        }catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static String readAllBytesJava(String filePath) {
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static Catalog getCatalogFromFile() {
        String filePath = "C:/Users/aditu/OneDrive/Desktop/ProgramareAvansata/Laborator5/src/main/resources/catalog.txt";
        String fileContent = readAllBytesJava(filePath);
        Catalog catalog = new Gson().fromJson(fileContent, Catalog.class);
        return catalog;
    }

}
