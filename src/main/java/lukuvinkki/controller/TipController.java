package lukuvinkki.controller;

import lukuvinkki.domain.Tag;
import lukuvinkki.domain.Tip;
import lukuvinkki.repository.TagRepository;
import lukuvinkki.repository.TipRepository;
import lukuvinkki.util.TagParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TipController {
    
    private boolean testData = false;

    @Autowired
    private TipRepository tipRepository;

    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(value="/addTip", method=RequestMethod.GET)
    public String tipForm(Model model){
        model.addAttribute("tip", new Tip());
        return "tipForm";
    }
    
    @RequestMapping(value = "/addTip", method = RequestMethod.POST)
    public String tipSubmit(@ModelAttribute Tip tip)
    {
        TagParser parser = new TagParser(tip.getRawTags());
        List<Tag> tags = getOrCreateTag(parser.parse());
        for(Tag tag : tags) {
            tip.addTag(tag);
        }
        tipRepository.save(tip);
        return "tipForm";
   }

   @RequestMapping(value = "/tips", method = RequestMethod.GET)
   public String viewTips(Model model) {
       if (!testData) addTestData();
       
       
        List<Tip> tips = tipRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("tips", tips);
        return "tipList";
   }
   
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchTips(Model model, String keyword) {
        List<Tag> tags = tagRepository.findAllByName(keyword);
        List<Tip> tips = new ArrayList<>();
        for (Tag tag : tags) {
            tips.add(tipRepository.findByTags(tag.getName()));
        }
        model.addAttribute("tips", tips);
        return "tipList";
    }

    private List<Tag> getOrCreateTag(List<String> rawTags) {
        List<Tag> tags = new ArrayList<>();
        for (String rawTag : rawTags) {
            Tag tag = tagRepository.findTagByName(rawTag);
            if (tag == null) {
                tag = new Tag(rawTag);
                tagRepository.save(tag);
            }
            tags.add(tag);
        }
        return tags;
    }
    
    private void addTestData() {
        Tip tip = new Tip();
        tip.setTitle("Examples in Each Chapter");
        tip.setAuthor("SELECT * FROM Author");
        tip.setDescription("SELECT * FROM DESCRIPTION");
        tip.setUrl("https://www.w3schools.com/sql/");
        Tag tag = new Tag();
        tag.setName("SQL");
        tip.addTag(tag);
        tagRepository.save(tag);
        tipRepository.save(tip);
    
        Tip tip2 = new Tip();
        tip2.setTitle("Spring on kivaa");
        tip2.setAuthor("Nobody");
        tip2.setDescription("Vitsi vitsi");
        tip2.setUrl("www.spring.io");
        Tag tag2 = new Tag();
        tag2.setName("Spring");
        tip2.addTag(tag2);
        tagRepository.save(tag2);
        tipRepository.save(tip2);
        
        Tip tip3 = new Tip();
        tip3.setTitle("sql ohjeet");
        tip3.setAuthor("pekka");
        tip3.setDescription("kaikki mitä tarvii tietää sql");
        tip3.setUrl("https://www.w3schools.com/sql/");
        tip3.addTag(tag);
        tipRepository.save(tip3);
//        
        Tip tip4 = new Tip();
        tip4.setTitle("Motivation");
        tip4.setAuthor("Author Unknown");
        tip4.setDescription("There was this one day during elementary school where my mom came to say hello to me. I was so embarrassed.");
        tip4.setUrl("https://academictips.org/blogs/my-mom-only-had-one-eye/comment-page-2/");
        Tag tag4 = new Tag();
        tag4.setName("getMotivated");
        tip4.addTag(tag4);
        tagRepository.save(tag4);
        tipRepository.save(tip4);
//        
        Tip tip5 = new Tip();
        tip5.setTitle("Best joke ever");
        tip5.setAuthor("Funny guy");
        tip5.setDescription("Moses had the first tablet that could connect to the cloud.");
        tip5.setUrl("https://onelinefun.com/");
        Tag tag5 = new Tag();
        tag5.setName("Jokes");
        tip5.addTag(tag5);
        tagRepository.save(tag5);
        tipRepository.save(tip5);
//        
        Tip tip6 = new Tip();
        tip6.setTitle("2nd best joke");
        tip6.setAuthor("Funny guy");
        tip6.setDescription("About a month before he died, my uncle had his back covered in lard. After that, he went down hill fast.");
        tip6.setUrl("https://onelinefun.com/");
        tip6.addTag(tag5);
        tipRepository.save(tip6);
//        
        Tip tip7 = new Tip();
        tip7.setTitle("3rd best joke");
        tip7.setAuthor("Funny guy");
        tip7.setDescription("Maybe if we start telling people the brain is an app they will start using it.");
        tip7.setUrl("https://onelinefun.com/");
        Tag tag7 = new Tag();
        tip7.addTag(tag5);
        tipRepository.save(tip7);
    }
}
