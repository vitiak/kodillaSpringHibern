package springhibern.shop.controller;

import lombok.RequiredArgsConstructor;
import springhibern.shop.domain.BallDto;
import springhibern.shop.mapper.BallMapper;
import springhibern.shop.service.BallService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/balls")
class BallController {

    private final BallService service;

    @GetMapping
    public List<BallDto> m1() {
        return BallMapper.toBallDtoList(service.getBalls());
    }

    @PostMapping
    public void m2(@RequestBody BallDto ballDto) {
        service.createBall(BallMapper.toBall(ballDto));
    }

    @DeleteMapping(path = "/{index}")
    public void m3(@PathVariable("index") int index) {
        service.deleteBall(index);
    }

}