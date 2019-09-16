package test.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.entity.Cathet;

import java.util.List;

public interface CathetDao extends JpaRepository<Cathet, Long> {
    Cathet findOneBySeamAndCathet(String seam, int k);
    List<Cathet> findAllBySeam(String seam);
    Cathet findById(int id);
}
