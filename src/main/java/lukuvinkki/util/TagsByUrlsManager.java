package lukuvinkki.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.ResourceUtils;


public class TagsByUrlsManager {
    private Map<List<String>, List<String>> tagsAndUrls;
    
    public TagsByUrlsManager() {
        tagsAndUrls = new HashMap<>();
        List<String> urls1 = new ArrayList<>();
        List<String> tags1 = new ArrayList<>();
        List<String> urls2 = new ArrayList<>();
        List<String> tags2 = new ArrayList<>();
        
        urls1.add("youtube.com/watch?v=");
        urls1.add("youtu.be/");
        urls1.add("y2u.be/");
        
        tags1.add("video");
        
        urls2.add("dl.acm.org/");
        urls2.add("ieeexplore.ieee.org/document/");
        
        tags2.add("tieteellinen julkaisu");
        
        tagsAndUrls.put(urls1, tags1);
        tagsAndUrls.put(urls2, tags2);
    }
    
    public List<String> getTagsByUrl(String tipUrl) {
        List<String> tagsToBeAdded = new ArrayList<>();
        for (Map.Entry<List<String>, List<String>> entry : tagsAndUrls.entrySet()) {
            List<String> urls = entry.getKey();
            List<String> tags = entry.getValue();
            
            for (String url : urls) {
                if (tipUrl.contains(url)) {
                    for (String tag : tags) {
                        tagsToBeAdded.add(tag);
                    }
                }
            }
            
        }
        return tagsToBeAdded;
    }
    
    //private static final String FILEPATH = "data/tags_by_urls.txt";
//    
//    public List<String> getRawData() {
//        List<String> lines = new ArrayList<>();
//        try {
//            File file = ResourceUtils.getFile("classpath:" + FILEPATH);
//            Charset charset = Charset.forName("UTF-8");
//            lines = Files.readAllLines(file.toPath(), charset);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        return lines;
//    }
//    
//    public List<String> getTagsByUrl(String tipUrl, List<String> lines) {
//        List<String> tagsToBeAdded = new ArrayList<>();
//        for (String line : lines) {
//            String[] urlsAndTags = line.split(" => ");
//            String[] urls = urlsAndTags[0].split(" ");
//            String[] tags = urlsAndTags[1].split(";");
//            for (String parsedUrl : urls) {
//                if (tipUrl.contains(parsedUrl)) {
//                    for (String tag : tags) {
//                        tagsToBeAdded.add(tag);
//                    }
//                }
//            }
//        }
//        return tagsToBeAdded;
//    }
}
