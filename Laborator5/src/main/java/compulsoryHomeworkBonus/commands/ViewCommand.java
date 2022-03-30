package compulsoryHomeworkBonus.commands;

import compulsoryHomeworkBonus.Catalog;
import compulsoryHomeworkBonus.exceptions.InvalidItem;
import compulsoryHomeworkBonus.items.Item;
import compulsoryHomeworkBonus.items.LocalItem;
import compulsoryHomeworkBonus.items.WebItem;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * This class opens the file from their location, if it is a web element than it will be opened in browser
 * Else it will be opened locally using Desktop dependency
 */
public class ViewCommand implements Command {
    private Catalog catalog;
    private int index;

    public ViewCommand(Catalog catalog, int index) {
        this.catalog = catalog;
        this.index = index;
    }

    @Override
    public void executeOperation() throws IOException, URISyntaxException, InvalidItem {
        if (this.index < this.catalog.getItems().size() && this.index > -1) {
            Item item = this.catalog.getItemById(this.index);
            System.out.println("The item: " + item.getTitle() + " has the following content:");
            item.printItemsContent();

            if (this.catalog.getItemById(this.index) instanceof WebItem) {
                ((WebItem) this.catalog.getItemById(this.index)).openLink();
            } else if (this.catalog.getItemById(this.index) instanceof LocalItem) {
                ((LocalItem) this.catalog.getItemById(this.index)).openFile();
            } else {
                throw new InvalidItem(
                        "The item you are trying to get is invalid"
                );
            }
        }
    }
}
