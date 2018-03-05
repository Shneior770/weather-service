package services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DoubleFormatterTest {

    @Test
    public void givenIntegerNum_formatDoubleWithTwoDigitsAfterPoint_shouldReturnTheNumWithA_0_AfterFloatingPoint() {
        // prepare
        DoubleFormatter formatter = new DoubleFormatter();
        final int GIVEN_NUM = 10;
        double expectedNum = 10.0;
        // act
        double actualNum = formatter.formatDoubleWithTwoDigitsAfterPoint(GIVEN_NUM);
        // assert
        assertEquals(expectedNum,actualNum,0);
    }

    @Test
    public void givenBigDoubleNumber_formatTheTemp_shouldFormatItAndReturnTowNumAfterFloatingPoint() {
        // prepare
        DoubleFormatter formatter = new DoubleFormatter();
        double bigDouble = 235.3111;
        double formattedDouble = 235.31;
        // act
        double tempDouble = formatter.formatDoubleWithTwoDigitsAfterPoint(bigDouble);
        // assert
        assertEquals(formattedDouble, tempDouble,0);
    }

    @Test
    public void givenTheFranctionIsHalfOfTheIntegerNumber_formatTheTemp_shouldRoundItUp() {
        //prepare
        DoubleFormatter formatter = new DoubleFormatter();
        double myDouble = 1.999;
        double formattedDouble = 2.0;
        //act
        double tempDouble = formatter.formatDoubleWithTwoDigitsAfterPoint(myDouble);
        //assert
        assertEquals(formattedDouble, tempDouble,0);
    }

}
