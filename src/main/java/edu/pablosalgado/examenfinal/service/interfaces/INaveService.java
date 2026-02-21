package edu.pablosalgado.examenfinal.service.interfaces;

import java.util.List;

import edu.pablosalgado.examenfinal.model.Nave;

public interface INaveService {
    public List<Nave> findAllNaves();

    public Nave findNaveById(Long id);

    public Nave addNave(Nave nave);

    public Nave updateNaveById(Long id, Nave nave);

    public void deleteNaveById(Long id);
}
