package lukuvinkki.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import lukuvinkki.domain.Tip;
import org.springframework.util.ResourceUtils;


public class TagsByUrlsManager {
    
    private static final String FILEPATH = "data/tags_by_urls.txt";
    
    public TagsByUrlsManager() {
        
    }
    
    public List<String> getRawData() {
        List<String> lines = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:" + FILEPATH);
            Charset charset = Charset.forName("UTF-8");
            lines = Files.readAllLines(file.toPath(), charset);
        } catch (IOException e) {
            e.getMessage();
        }
        return lines;
    }
    
    public List<String> getTagsByUrl(String tipUrl, List<String> lines) {
        List<String> tagsToBeAdded = new ArrayList<>();
        for (String line : lines) {
            String[] urlsAndTags = line.split(" => ");
            String[] urls = urlsAndTags[0].split(" ");
            String[] tags = urlsAndTags[1].split(";");
            for (String parsedUrl : urls) {
                if (tipUrl.contains(parsedUrl)) {
                    for (String tag : tags) {
                        tagsToBeAdded.add(tag);
                    }
                }
            }
        }
        return tagsToBeAdded;
    }

}
