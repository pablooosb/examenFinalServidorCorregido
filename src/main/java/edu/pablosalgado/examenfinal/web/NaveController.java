package edu.pablosalgado.examenfinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pablosalgado.examenfinal.model.Nave;
import edu.pablosalgado.examenfinal.service.interfaces.INaveService;

@Controller
@RequestMapping("/naves")
public class NaveController {
    @Autowired
    private INaveService naveService;

    @GetMapping
    public String findAllNaves(Model model){
        model.addAttribute("naves", naveService.findAllNaves());
        return "naves/index";
    }

    @GetMapping("/add")
    public String addNave(Model model){
        model.addAttribute("nave", new Nave());
        return "/naves/form";
    }

    @PostMapping("/add")
    public String postMethodName(@ModelAttribute Nave nave){
        naveService.addNave(nave);
        return "redirect:/naves";
    }
}
