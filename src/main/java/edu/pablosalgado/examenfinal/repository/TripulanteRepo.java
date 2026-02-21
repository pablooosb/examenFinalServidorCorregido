package edu.pablosalgado.examenfinal.repository;

import java.util.List;
import edu.pablosalgado.examenfinal.model.Tripulante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripulanteRepo extends JpaRepository<Tripulante, Long>{
    // Buscar los tripulantes según su licencia estelar
    public List<Tripulante> findTripulantesByLicenciaEstelar(String licenciaEstelar);
}
