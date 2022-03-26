package compulsory;

import com.google.gson.Gson;
import compulsory.catalogUtils.CatalogStorage;
import compulsory.items.DocumentType;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.addItemToCatalog("{\"id\":\"knuth67\", \"title\":\"The Art of Computer Programming\", \"location\":\"d:/books/programming/tacp.ps\", \"year\":\"1967\", \"author\":\"Donald E. Knuth\", \"type\": \"book\"}", DocumentType.LOCAL_DOCUMENT);
        catalog.addItemToCatalog("{\"id\":\"java17\", \"title\":\"The Java Language Specification\", \"location\":\"https://docs.oracle.com/javase/specs/jls/se17/html/index.html\", \"year\":\"2021\", \"author\":\"James Gosling & others\", \"type\": \"book\"}", DocumentType.WEB_DOCUMENT);
        System.out.println(catalog);

        System.out.println(new Gson().toJson(catalog));
        CatalogStorage.saveCatalogToFile(catalog);

        Catalog catalog2 = CatalogStorage.getCatalogFromFile();
        System.out.println(catalog2);
    }
}
