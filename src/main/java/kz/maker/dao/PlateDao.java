package kz.maker.dao;

import kz.maker.entity.Cathet;
import kz.maker.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlateDao extends JpaRepository<Plate, Long> {
    Plate findOneByPlateValue(int plateValue);
    List<Plate> findAll();
    Plate findById(int id);
}
