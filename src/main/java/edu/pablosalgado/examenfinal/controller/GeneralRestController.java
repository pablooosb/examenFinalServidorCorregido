package edu.pablosalgado.examenfinal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pablosalgado.examenfinal.model.Nave;
import edu.pablosalgado.examenfinal.model.Tripulante;
import edu.pablosalgado.examenfinal.repository.MisionAsignadaRepo;
import edu.pablosalgado.examenfinal.service.interfaces.INaveService;

@RestController
@RequestMapping("/api")
public class GeneralRestController {
    @Autowired
    private INaveService naveService;  
    
    @Autowired
    private MisionAsignadaRepo misionAsignadaRepo;

    @GetMapping("/naves")
    public List<Nave> findAllNaves(){
        return naveService.findAllNaves();
    }

    @GetMapping("/naves/{id}")
    public Nave findNaveById(@PathVariable("id") Long id){
        return naveService.findNaveById(id);
    }

    @PostMapping("/naves/add")
    public Nave addNave(@RequestBody Nave nave){
        return naveService.addNave(nave);
    }
    

    @PostMapping("/naves/update/{id}")
    public Nave updateNaveById(@PathVariable("id") Long id, Nave nave){
        return naveService.updateNaveById(id, nave);
    }

    @DeleteMapping("/naves/delete/{id}")
    public void deleteNaveById(@PathVariable("id") Long id){
        naveService.deleteNaveById(id);
    }

    // Endpoint de cálculo para los impuestos galácticos (15%) según el id del tripulante
    @GetMapping("/impuestos/{tripulante_id}")
    public BigDecimal sumImpuestosGalacticosPagadosByTripulanteId(@PathVariable("tripulante_id") Long tripulante_id){
        return misionAsignadaRepo.sumImpuestosGalacticosPagadosByTripulanteId(tripulante_id);
    }
}
