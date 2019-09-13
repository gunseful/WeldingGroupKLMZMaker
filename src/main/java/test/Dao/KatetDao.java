package test.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import test.entity.Katet;

import java.util.List;

public interface KatetDao extends JpaRepository<Katet, Long> {
    Katet findOneBySeamAndK(String seam, int k);
    List<Katet> findAllBySeam(String seam);
    Katet findById(int id);

}
