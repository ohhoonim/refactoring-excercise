package refactoring.excercise.shop;

import refactoring.excercise.shop.moviestate.ChildrenPrice;
import refactoring.excercise.shop.moviestate.NewReleasePrice;
import refactoring.excercise.shop.moviestate.RegularPrice;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        // 상태/전략 패턴으로 전환 기법을 이용하려면 getter/setter를 이용하도록 강제해야한다.
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                _price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("올바른 가격 코드를 입력하세요.");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
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
