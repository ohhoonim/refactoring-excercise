package refactoring.excercise.shop.moviestate;

import refactoring.excercise.shop.Movie;
import refactoring.excercise.shop.Price;

public class ChildrenPrice implements Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
    
}
