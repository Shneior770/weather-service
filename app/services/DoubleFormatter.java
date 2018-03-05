package services;

import java.math.BigDecimal;

public class DoubleFormatter {

    public double formatDoubleWithTwoDigitsAfterPoint(double num) {
        final int decimalPlaces = 2;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);

        return bd.doubleValue();
    }
}
