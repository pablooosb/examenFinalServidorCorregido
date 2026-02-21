package edu.pablosalgado.examenfinal.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pablosalgado.examenfinal.model.MisionAsignada;
import edu.pablosalgado.examenfinal.model.Tripulante;
import edu.pablosalgado.examenfinal.model.enums.EstadoMision;

@Repository
public interface MisionAsignadaRepo extends JpaRepository<MisionAsignada, Long>{
    // Buscar los registros de las misiones asignadas según su estado
    public List<MisionAsignada> findMisionAsignadaByEstadoMision(EstadoMision estadoMision);

    // Calcular el presupuesto total invertido según el id del tripulante
    @Query("SELECT SUM(m.presupuestoMision) FROM MisionAsignada m WHERE m.tripulante.id = :tripulante_id")
    public BigDecimal sumPresupuestoByTripulanteId(@Param("tripulante_id")Tripulante tripulante);

    // Endpoint de cálculo para los impuestos galácticos (15%) según el id del tripulante
    @Query("SELECT SUM(m.presupuestoMision)*0.15 FROM MisionAsignada m WHERE m.tripulante.id = :tripulante_id")
    public BigDecimal sumImpuestosGalacticosPagadosByTripulanteId(@Param("tripulante_id") Long tripulante_id);
}
