package springhibern.shop.service;

import lombok.RequiredArgsConstructor;
import springhibern.shop.domain.Ball;
import springhibern.shop.repository.BallRepository;
import java.util.List;

@RequiredArgsConstructor
class BallServiceImpl implements BallService {

    private final BallRepository repository;

    @Override
    public List<Ball> getBalls() {
        return repository.findAll();
    }

    @Override
    public void createBall(Ball ball) {
        repository.save(ball);
    }

    @Override
    public void deleteBall(int index) {
        repository.deleteByIndex(index);
    }

}
