package edu.pablosalgado.examenfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pablosalgado.examenfinal.model.Tripulante;
import edu.pablosalgado.examenfinal.repository.TripulanteRepo;
import edu.pablosalgado.examenfinal.service.interfaces.ITripulanteService;

@Repository
public class TripulanteServiceImpl implements ITripulanteService{
    @Autowired
    private TripulanteRepo tripulanteRepo;

    @Override
    public List<Tripulante> findAllTripulantes(){
        return tripulanteRepo.findAll();
    }
}
