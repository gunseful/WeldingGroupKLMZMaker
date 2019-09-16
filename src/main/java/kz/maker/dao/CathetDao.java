package kz.maker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.maker.entity.Cathet;

import java.util.List;

public interface CathetDao extends JpaRepository<Cathet, Long> {
    Cathet findOneBySeamAndCathetValue(String seam, int k);
    List<Cathet> findAllBySeam(String seam);
    Cathet findById(int id);
}
