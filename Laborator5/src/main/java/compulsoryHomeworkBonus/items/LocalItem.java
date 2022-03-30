package compulsoryHomeworkBonus.items;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocalItem extends Item {

    public LocalItem(String id, String title, String location, int year, String author, String type) {
        super(id, title, location, year, author, type);
    }

    @Override
    public void printItemsContent() throws FileNotFoundException {
        Scanner input = new Scanner(new File(getLocation()));
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }

    public void openFile() {
        try {
            File file = new File(this.getLocation());
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
