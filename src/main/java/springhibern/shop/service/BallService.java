package springhibern.shop.service;

import springhibern.shop.domain.Ball;

import java.util.List;

public interface BallService {
    List<Ball> getBalls();
    void createBall(Ball ball);
    void deleteBall(int index);
}
