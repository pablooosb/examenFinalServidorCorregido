package edu.pablosalgado.examenfinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pablosalgado.examenfinal.service.interfaces.ITripulanteService;

@Controller
@RequestMapping("/tripulantes")
public class TripulanteController {
    @Autowired
    private ITripulanteService tripulanteService;

    @GetMapping
    public String findAllTripulantes(Model model){
        model.addAttribute("tripulantes", tripulanteService.findAllTripulantes());
        return "tripulantes/index";
    }
}
