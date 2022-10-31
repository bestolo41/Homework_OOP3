package transport;

public class Train extends Transport {
    private double tripPrice;
    private String tripTime;
    private String startStation;
    private String finishStation;
    private int wagonCount;

    public Train(String brand, String model, int year, String country, String color, int maxSpeed, double tripPrice, String tripTime, String startStation, String finishStation, int wagonCount) {
        super(brand, model, year, country, color, maxSpeed);
        setTripPrice(tripPrice);
        setTripTime(tripTime);
        setStartStation(startStation);
        setFinishStation(finishStation);
        setWagonCount(wagonCount);
    }


    @Override
    public void refill() {
        System.out.println("Заправляется дизелем");
    }

    @Override
    public String toString() {
        return "\nПоезд: " + getBrand() + " " + getModel() + "\n" +
                "Стоимость: " + getTripPrice() + "\n" +
                "Время отправления: " + getTripTime() + "\n" +
                "Отправление из: " + getStartStation() + "\n" +
                "Прибытие в: " + getFinishStation() + "\n" +
                "Количество вагонов: " + getWagonCount();
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = tripPrice;
    }
    public void setTripTime(String tripTime) {
        if (tripTime == null || tripTime.isEmpty() || tripTime.isBlank())  this.tripTime = "Нет информации";
        else this.tripTime = tripTime;
    }
    public void setStartStation(String startStation) {
        if (startStation == null || startStation.isEmpty() || startStation.isBlank())  this.startStation = "Нет информации";
        else this.startStation = startStation;
    }
    public void setFinishStation(String finishStation) {
        if (finishStation == null || finishStation.isEmpty() || finishStation.isBlank())  this.finishStation = "Нет информации";
        else this.finishStation = finishStation;
    }
    public void setWagonCount(int wagonCount) {
        this.wagonCount = wagonCount;
    }
    public double getTripPrice() {
        return tripPrice;
    }
    public String getTripTime() {
        return tripTime;
    }
    public String getStartStation() {
        return startStation;
    }
    public String getFinishStation() {
        return finishStation;
    }
    public int getWagonCount() {
        return wagonCount;
    }
}
