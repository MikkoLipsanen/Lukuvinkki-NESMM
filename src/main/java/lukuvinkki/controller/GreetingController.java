package main.java.lukuvinkki.controller;

import main.java.lukuvinkki.database.TipDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private TipDao tipDao;

    public GreetingController() {
        this.tipDao = new TipDao("jdbc:sqlite:tip.db");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "title", required = false, defaultValue = "Terve") String name, Model model) {
        model.addAttribute("title", name);
        return "greeting";
    }

    @GetMapping("/bookmark")
    public String bookmark(@RequestParam(name = "title", required = false, defaultValue = "Heippa") String name, Model model) {
        model.addAttribute("title", name);
        return "bookmark";
    }

}
