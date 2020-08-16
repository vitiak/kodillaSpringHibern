package springhibern.shop.repository;

import springhibern.shop.domain.Ball;
import java.util.ArrayList;
import java.util.List;

class InMemoryBallRepository implements BallRepository {

    private List<Ball> balls = new ArrayList<>();

    @Override
    public List<Ball> findAll() {
        return balls;
    }

    @Override
    public void save(Ball ball) {
        balls.add(ball);
    }

    @Override
    public void deleteByIndex(int index) {
        balls.remove(index);
    }

}
