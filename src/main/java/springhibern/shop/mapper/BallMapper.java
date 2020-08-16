package springhibern.shop.mapper;

import springhibern.shop.domain.Ball;
import springhibern.shop.domain.BallDto;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BallMapper {

    public static Ball toBall(BallDto ballDto) {
        return Ball.of(ballDto.getSize(), ballDto.getDiscipline(), ballDto.getPrice());
    }

    public static BallDto toBallDto(Ball ball) {
        return new BallDto(ball.getSize(), ball.getDiscipline(), ball.getPrice());
    }

    public static List<Ball> toBallList(List<BallDto> ballDtos) {
        return ballDtos
                .stream()
                .map(bdto -> Ball.of(bdto.getSize(), bdto.getDiscipline(), bdto.getPrice()))
                .collect(toList());
    }

    public static List<BallDto> toBallDtoList(List<Ball> balls) {
        return balls
                .stream()
                .map(b -> new BallDto(b.getSize(), b.getDiscipline(), b.getPrice()))
                .collect(toList());
    }

}
