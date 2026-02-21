package edu.pablosalgado.examenfinal.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.pablosalgado.examenfinal.model.enums.Rango;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tripulante")
@NoArgsConstructor
@Data
public class Tripulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "rango")
    private Rango rango;

    @Column(name = "licencia_estelar")
    private String licenciaEstelar;

    @OneToMany(mappedBy = "tripulante")
    @JsonIgnore
    private List<MisionAsignada> misionAsignada = new ArrayList<>();
}
