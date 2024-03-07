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
    
    public double getCharge() {
        double result = 0;
        switch(getMovie().getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;  // 대여료 계산
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;  // 대여료 계산
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;  // 대여료 계산
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
