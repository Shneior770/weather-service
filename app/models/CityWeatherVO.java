package models;

public class CityWeatherVO {
    private double the_temp;
    private String weather_state_name;
    private String applicable_date;
    private String weather_state_abbr;
    final private String imgLink = "https://www.metaweather.com/static/img/weather/png/%s.png";

    public String getImgLink() {
        return imgLink;
    }

    public String getFormattedImg() {
        return String.format(imgLink, weather_state_abbr);
    }

    public String getWeatherStateAbbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWeatherStateName() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public  String getApplicableDate() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public double getTemperature() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof CityWeatherVO)) {
            return false;
        }
        CityWeatherVO cityWeatherVO = (CityWeatherVO) obj;

        if (this.the_temp == cityWeatherVO.getTemperature() && this.weather_state_name.
                equals(cityWeatherVO.getWeatherStateName()) && this.applicable_date.
                equals(cityWeatherVO.getApplicableDate()) && this. weather_state_abbr.equals(cityWeatherVO.getWeatherStateAbbr()) &&
                this.imgLink.equals(cityWeatherVO.getImgLink())) {

            return true;
        }

        return false;
    }
}
