package compulsoryHomeworkBonus.commands;

import compulsoryHomeworkBonus.Catalog;
import compulsoryHomeworkBonus.items.Item;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the Command Class that creates the Html report
 */

public class ReportCommand implements Command{

    private Catalog catalog;
    private List<Item> items;

    public ReportCommand(Catalog catalog, List<Item> items) {
        this.catalog = catalog;
    }

    // Cod copiat de pe net
    // No idea ce face jumatate din el :))
    @Override
    public void executeOperation() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/aditu/OneDrive/Desktop/ProgramareAvansata/Laborator5/src/main/resources"));
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        Map root = new HashMap();
        root.put("user", "My person");
        catalog.setItems(this.items);
        root.put("latestProduct", catalog);

        Template temp = cfg.getTemplate("test.ftlh");

        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
    }
}
