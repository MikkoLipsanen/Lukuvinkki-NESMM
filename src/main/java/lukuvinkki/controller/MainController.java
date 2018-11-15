package main.java.lukuvinkki.controller;

import java.sql.SQLException;
import lukuvinkki.database.TipDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            return "tipForm";
    }
    
    @RequestMapping(value = "/addTip", method = RequestMethod.POST)
        public String tipSubmit(@RequestParam("title") String title, @RequestParam("author") String author,
            @RequestParam("url") String url, @RequestParam("description") String description) throws SQLException {
            tipDao.addTip(title, author, url, description);
            return "tipForm";
   }

}
