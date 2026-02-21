package edu.pablosalgado.examenfinal.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.pablosalgado.examenfinal.model.enums.EstadoMision;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mision_asignada")
@NoArgsConstructor
@Data
public class MisionAsignada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripulante_id")
    @JsonIgnore
    private Tripulante tripulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nave_id")
    @JsonIgnore
    private Nave nave;

    @Column(name = "fecha_estelar")
    private BigDecimal fechaEstelar;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoMision estadoMision;

    @Column(name = "presupuesto")
    private BigDecimal presupuestoMision;
}
