package refactoring.excercise.shop.moviestate;

import refactoring.excercise.shop.Movie;
import refactoring.excercise.shop.Price;

public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;  // 대여료 계산
        return result;
    }

}
