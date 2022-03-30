package compulsoryHomeworkBonus.commands;

import compulsoryHomeworkBonus.exceptions.InvalidItem;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * This is the interface for the Commands
 */
public interface Command {
    void executeOperation() throws IOException, TemplateException, URISyntaxException, InvalidItem;
}
