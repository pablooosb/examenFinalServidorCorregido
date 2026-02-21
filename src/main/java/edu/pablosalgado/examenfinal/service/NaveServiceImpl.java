package edu.pablosalgado.examenfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pablosalgado.examenfinal.model.Nave;
import edu.pablosalgado.examenfinal.repository.NaveRepo;
import edu.pablosalgado.examenfinal.service.interfaces.INaveService;

@Service
public class NaveServiceImpl implements INaveService{
    @Autowired
    private NaveRepo naveRepo;

    @Override
    public List<Nave> findAllNaves(){
        return naveRepo.findAll();
    }

    @Override
    public Nave findNaveById(Long id){
        return naveRepo.findById(id).orElse(null);
    }

    @Override
    public Nave addNave(Nave nave){
        return naveRepo.save(nave);
    }

    @Override
    public Nave updateNaveById(Long id, Nave nave){
        if (naveRepo.existsById(id)){
            return naveRepo.save(nave);
        }
        return null;
    }

    @Override
    public void deleteNaveById(Long id){
        naveRepo.deleteById(id);
    }
}
