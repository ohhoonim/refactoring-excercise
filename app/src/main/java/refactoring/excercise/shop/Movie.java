package refactoring.excercise.shop;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        // 상태/전략 패턴으로 전환 기법을 이용하려면 getter/setter를 이용하도록 강제해야한다.
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch(getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;  // 대여료 계산
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;  // 대여료 계산
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if ( daysRented > 3)
                    result += (daysRented - 3) * 1.5;  // 대여료 계산
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
