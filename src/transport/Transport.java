package transport;

import java.time.LocalDate;

public abstract class Transport {
    private static final String ANSI_RESET = "\u001b[0m";
    private static final String ANSI_RED = "\u001b[31m";

    private String brand;
    private String model;
    private int year;
    private String country;
    private String color;
    private int maxSpeed;

    public Transport(String brand, String model, int year, String country, String color, int maxSpeed) {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setCountry(country);
        setColor(color);
        setMaxSpeed(maxSpeed);
    }


    public abstract void refill();

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank() || brand.isEmpty()) this.brand = "";
        else this.brand = brand;
    }
    public void setModel(String model) {
        if (model == null || model.isBlank() || model.isEmpty()) this.model = "";
        else this.model = model;
    }
    private void setYear(int year) {
        if (year > 1886 && year < LocalDate.now().getYear()) this.year = year;
    }
    public void setCountry(String country) {
        if (country == null || country.isBlank() || country.isEmpty()) this.color = "Информация отсутствует";
        else this.country = country;
    }
    public void setColor(String color) {
        if (color == null || color.isBlank() || color.isEmpty()) this.color = "Информация отсутствует";
        else this.color = color;
    }
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) this.maxSpeed = maxSpeed;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getCountry() {
        return country;
    }
    public String getColor() {
        return color;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    @Override
    public String toString() {
        return "\n" + getBrand() + " " + getModel() + "\n" +
                "Год выпуска: " + getYear() + "\n" +
                "Cтрана сборки: " + getCountry() + "\n" +
                "Цвет: " + getColor() + "\n" +
                "Максимальная скорость: " + (getMaxSpeed() == 0 ? "Нет информации\n" : getMaxSpeed());

    }
}
