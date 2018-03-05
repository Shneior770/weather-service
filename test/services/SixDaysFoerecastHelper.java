package services;

import models.CityWeatherVO;

import java.util.Arrays;
import java.util.List;

public class SixDaysFoerecastHelper {

    public static List<CityWeatherVO> getSixDaysForecast() {
        CityWeatherVO cityWeather1 = new CityWeatherVO();
        cityWeather1.setThe_temp(5.38);
        cityWeather1.setWeather_state_name("Light Cloud");
        cityWeather1.setApplicable_date("2018-02-12");
        cityWeather1.setWeather_state_abbr("lc");

        CityWeatherVO cityWeather2 = new CityWeatherVO();
        cityWeather2.setApplicable_date("2018-02-13");
        cityWeather2.setThe_temp(4.73);
        cityWeather2.setWeather_state_abbr("hr");
        cityWeather2.setWeather_state_name("Heavy Rain");

        CityWeatherVO cityWeather3 = new CityWeatherVO();
        cityWeather3.setApplicable_date("2018-02-14");
        cityWeather3.setThe_temp(5.9350000000000005);
        cityWeather3.setWeather_state_abbr("lr");
        cityWeather3.setWeather_state_name("Light Rain");

        CityWeatherVO cityWeather4 = new CityWeatherVO();
        cityWeather4.setApplicable_date("2018-02-15");
        cityWeather4.setThe_temp(10.09);
        cityWeather4.setWeather_state_abbr("s");
        cityWeather4.setWeather_state_name("Showers");

        CityWeatherVO cityWeather5 = new CityWeatherVO();
        cityWeather5.setApplicable_date("2018-02-16");
        cityWeather5.setThe_temp(8.93);
        cityWeather5.setWeather_state_abbr("hc");
        cityWeather5.setWeather_state_name("Heavy Cloud");

        CityWeatherVO cityWeather6 = new CityWeatherVO();
        cityWeather6.setApplicable_date("2018-02-17");
        cityWeather6.setThe_temp(7.17);
        cityWeather6.setWeather_state_abbr("hc");
        cityWeather6.setWeather_state_name("Heavy Cloud");

       return Arrays.asList(cityWeather1, cityWeather2, cityWeather3, cityWeather4, cityWeather5, cityWeather6);
    }
}
