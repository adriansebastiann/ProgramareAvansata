package compulsoryHomeworkBonus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import compulsoryHomeworkBonus.items.DocumentType;
import compulsoryHomeworkBonus.items.Item;
import compulsoryHomeworkBonus.items.LocalItem;
import compulsoryHomeworkBonus.items.WebItem;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<Item> items;

    public Catalog() {
        this.items = new ArrayList<>();
    }

    public void addItemToCatalog(String entry, DocumentType documentType) {
        JSONObject json = new JSONObject(entry);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (documentType.equals(DocumentType.WEB_DOCUMENT)) {
            items.add(gson.fromJson(entry, WebItem.class));
        }
        if (documentType.equals(DocumentType.LOCAL_DOCUMENT)) {
            items.add(gson.fromJson(entry, LocalItem.class));
        }
    }

    public Item getItemById(Integer index) {
        return this.items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "items=" + items +
                '}';
    }
}
