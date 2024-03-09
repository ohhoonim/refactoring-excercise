package refactoring.excercise.shop;

public abstract class Price {
    abstract public int getPriceCode();
    abstract public double getCharge(int daysRented) ;

    public int getFrequentRenterPoints(int daysRented) {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
