package refactoring.excercise.shop;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
    
    public int getFrequentRenterPoints() {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }
}
