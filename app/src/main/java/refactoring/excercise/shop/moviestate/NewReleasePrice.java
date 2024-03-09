package refactoring.excercise.shop.moviestate;

import refactoring.excercise.shop.Movie;
import refactoring.excercise.shop.Price;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    
}
