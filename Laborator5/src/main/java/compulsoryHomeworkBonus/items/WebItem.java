package compulsoryHomeworkBonus.items;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class WebItem extends Item{

    public WebItem(String id, String title, String location, int year, String author, String type) {
        super(id, title, location, year, author, type);
    }

    @Override
    public void printItemsContent() throws MalformedURLException {
        URL url = new URL(this.getLocation());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openLink() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(this.getLocation()));
        }
    }
}
