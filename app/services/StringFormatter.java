package services;

public class StringFormatter {

    public String getCapitalizedName(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }
}
