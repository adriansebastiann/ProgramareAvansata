package compulsoryHomeworkBonus.commands;

import compulsoryHomeworkBonus.Catalog;

public class ListCommand implements Command{

    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void executeOperation() {
        System.out.println(catalog);
    }

}
