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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TipController {

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
        return "redirect:index.html";
   }

   @RequestMapping(value = "/tips", method = RequestMethod.GET)
   public String viewTips(Model model) {
        List<Tip> tips = tipRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("tips", tips);
        return "tipList";
   }
   
   @RequestMapping(value = "/tips/{tipId}", method = RequestMethod.POST)
   public String statusSubmit(@PathVariable Long tipId, Model model){
       Optional<Tip> optional = tipRepository.findById(tipId);
       if(optional.isPresent()){
       Tip tip = optional.get();
       tip.setStatus(true);
       tipRepository.save(tip);
       }
       return "redirect:/tips";                  
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
}
