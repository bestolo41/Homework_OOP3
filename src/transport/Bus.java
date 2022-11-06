package transport;

public class Bus extends Transport{

    private String engineType;
    public Bus(String brand, String model, String engineType, int year, String country, String color, int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
        setEngineType(engineType);
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        if (engineType == null || engineType.isBlank() || engineType.isEmpty()) this.engineType = "Нет информации";
        else switch (engineType) {

                case "Бензиновый":
                case "Бензин":
                    this.engineType = "Бензин";
                    break;
                case "Дизельный":
                case "Дизель":
                    this.engineType = "Дизель";
                    break;
                default:
                    this.engineType = "Нет информации";
                    break;
        }
    }

    @Override
    public void refill() {
        switch (engineType) {
            case "Бензин":
                System.out.println("Заправляется бензином на АЗС");
                break;
            case "Дизель":
                System.out.println("Заправляется дизелем на АЗС");
                break;
            default:
                System.out.println("Неизвестен тип двигателя");
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Тип двигателя: " + getEngineType();
    }
}
