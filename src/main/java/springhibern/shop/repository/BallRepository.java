package springhibern.shop.repository;

import springhibern.shop.domain.Ball;
import java.util.List;

public interface BallRepository {

    List<Ball> findAll();
    void save(Ball ball);
    void deleteByIndex(int index);

}
