package refactoring.excercise.shop.moviestate;

import refactoring.excercise.shop.Movie;
import refactoring.excercise.shop.Price;

public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;  // 대여료 계산
        return result;
    }
    
}
