package compulsoryHomeworkBonus;

import com.google.gson.Gson;
import compulsoryHomeworkBonus.catalogUtils.CatalogStorage;
import compulsoryHomeworkBonus.commands.ListCommand;
import compulsoryHomeworkBonus.commands.ReportCommand;
import compulsoryHomeworkBonus.commands.ViewCommand;
import compulsoryHomeworkBonus.exceptions.InvalidItem;
import compulsoryHomeworkBonus.items.DocumentType;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException, URISyntaxException, InvalidItem {
        Catalog catalog = new Catalog();
        catalog.addItemToCatalog("{\"id\":\"knuth67\", \"title\":\"The Art of Computer Programming\", \"location\":\"C:/Users/aditu/OneDrive/Desktop/ProgramareAvansata/Laborator5/src/main/resources/content.txt\", \"year\":\"1967\", \"author\":\"Donald E. Knuth\", \"type\": \"book\"}", DocumentType.LOCAL_DOCUMENT);
        catalog.addItemToCatalog("{\"id\":\"java17\", \"title\":\"The Java Language Specification\", \"location\":\"https://docs.oracle.com/javase/specs/jls/se17/html/index.html\", \"year\":\"2021\", \"author\":\"James Gosling & others\", \"type\": \"book\"}", DocumentType.WEB_DOCUMENT);
        System.out.println(catalog);

        System.out.println(new Gson().toJson(catalog));
        CatalogStorage.saveCatalogToFile(catalog);

//        Catalog catalog2 = CatalogStorage.getCatalogFromFile();
//        System.out.println(catalog2);

        //Homework test from here
        System.out.println("---------Homework--------");

        ListCommand listCommand = new ListCommand(catalog);
        listCommand.executeOperation();

        ViewCommand viewCommand0 = new ViewCommand(catalog, 0);
        viewCommand0.executeOperation();
        ViewCommand viewCommand1 = new ViewCommand(catalog, 1);
        viewCommand1.executeOperation();

        ReportCommand reportCommand = new ReportCommand(catalog, catalog.getItems());
        reportCommand.executeOperation();
    }
}
