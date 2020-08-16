package springhibern.shop.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Ball {
    int size;
    String discipline;
    double price;
}
