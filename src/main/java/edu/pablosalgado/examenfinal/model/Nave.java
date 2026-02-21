package edu.pablosalgado.examenfinal.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nave")
@NoArgsConstructor
@Data
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_nave")
    private String nombreNave;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "capacidad")
    private int capacidadPasajeros;

    @OneToMany(mappedBy = "nave")
    @JsonIgnore
    private List<MisionAsignada> misionAsignada = new ArrayList<>();
}
