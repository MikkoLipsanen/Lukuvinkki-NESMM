package lukuvinkki.controller;

import java.sql.SQLException;
import lukuvinkki.database.TipDao;
import lukuvinkki.domain.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private TipDao tipDao;

    public MainController() {
        this.tipDao = new TipDao("jdbc:sqlite:tip.db");
    }

    @RequestMapping(value="/addTip", method=RequestMethod.GET)
    public String tipForm(Model model){
        model.addAttribute("tip", new Tip());
        return "tipForm";
    }
    
    @RequestMapping(value = "/addTip", method = RequestMethod.POST)
    public String tipSubmit(@ModelAttribute Tip tip)
    {
        System.out.println(tip);
        //try {
            // tipDao.addTip should probably take Tip as an arugement
            // Also could catch possible error here
            // tipDao.addTip(title, author, url, description);
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
        return "tipForm";
   }

}
