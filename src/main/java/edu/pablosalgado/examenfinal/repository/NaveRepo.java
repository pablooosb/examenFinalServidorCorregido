package edu.pablosalgado.examenfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pablosalgado.examenfinal.model.Nave;

@Repository
public interface NaveRepo extends JpaRepository<Nave, Long>{

}
