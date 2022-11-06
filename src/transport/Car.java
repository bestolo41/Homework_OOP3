package transport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Car extends Transport {
    public class Key {
        private boolean remoteEngineStart;
        private boolean keyless;

        public Key(boolean remoteEngineStart, boolean keyless) {
            this.remoteEngineStart = remoteEngineStart;
            this.keyless = keyless;

        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeyless() {
            return keyless;
        }

        @Override

        public String toString() {
                return (isRemoteEngineStart() ? "\tУдаленный запуск двигателя: есть\n" : "\tУдаленный запуск двигателя: нет\n") + (isKeyless() ? "\tБесключевой доступ: есть\n" : "\tБесключевой доступ: нет\n");
        }
    }
    public class Insurance {
        private Date validity;
        private double cost;
        private String number;

        public Insurance(String validity, double cost, String number) throws ParseException {

            String modValidity = validity.replaceAll("\\p{Punct}|\\p{Space}", ".");
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            if (validity == null || validity.isEmpty() || validity.isBlank()) {
                this.validity = formatter.parse("01.01.1900");
            } else if (Pattern.matches("\\d{2}[.]\\d{2}[.]\\d{4}", modValidity)) {
                this.validity = formatter.parse(modValidity);
            }


            if (cost >= 0) this.cost = cost;
            else this.cost = 0;

            if (number == null || number.isEmpty() || number.isBlank()) {
                this.number = "Номер не указан";
            } else this.number = number;
        }

        public Date getValidity() {
            return validity;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        private String checkValidity() {
            String ANSI_RESET = "\u001b[0m";
            String ANSI_RED = "\u001b[31m";
            Date now = new Date();
            if (getValidity().before(now)) return  ANSI_RED + "  ПОЛИС ПРОСРОЧЕН!!!" + ANSI_RESET;
            else return "";
        }

        private String checkNumber() {
            String ANSI_RESET = "\u001b[0m";
            String ANSI_RED = "\u001b[31m";
            if (Pattern.matches("[0-9a-zA-Z]{9}", getNumber())) return "";
            else return ANSI_RED + " НЕКОРРЕКТНЫЙ НОМЕР!!!" + ANSI_RESET;
        }


        @Override
        public String toString() {
            String ANSI_RESET = "\u001b[0m";
            String ANSI_RED = "\u001b[31m";
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return "\tНомер: " + getNumber() + checkNumber() + "\n" +
                    "\tСрок действия: " + (validity != null ? formatter.format(getValidity()) + checkValidity() + "\n" : ANSI_RED +" НЕКОРРЕКТНАЯ ДАТА!!!\n" + ANSI_RESET) +
                    "\tСтраховая премия: " + getCost();
        }
    }
    private String engineType;
    private double engineVolume;
    private String transmission;
    private String bodyType;
    private String regNumber;
    private int seats;
    private String tires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, String engineType, double engineVolume, String color, int year, String country, String transmission, int maxSpeed, String bodyType, String regNumber, int seats, String tires) {
        super(brand,model,year,country,color, maxSpeed);
        setEngineType(engineType);
        setEngineVolume(engineVolume);
        setTransmission(transmission);
        setBodyType(bodyType);
        setRegNumber(regNumber);
        setSeats(seats);
        setTires(tires);
    }




    public void changeTires() {
        if (tires.equalsIgnoreCase("Зимняя")) setTires("Летняя");
        else if (tires.equalsIgnoreCase("Летняя")) setTires("Зимняя");
    }


    public String getEngineType() {
        return engineType;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public String getTransmission() {
        return transmission;
    }
    public String getBodyType() {
        return bodyType;
    }
    public String getRegNumber() {
        return regNumber;
    }
    public int getSeats() {
        return seats;
    }
    public String getTires() {
        return tires;
    }
    public Key getKey() {
        return key;
    }
    public Insurance getInsurance() {
        return insurance;
    }
    public void setKey(Key key) {
        if (this.key == null)
        this.key = key;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    public void setEngineType(String engineType) {
        if (engineType != null || !engineType.isBlank() || !engineType.isEmpty()) {
            switch (engineType) {

                case "Электрический":
                case "Электро":
                case "Электричество":
                    this.engineType = "Электро";
                    break;
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
        } else this.engineType = "Нет информации";
    }
    public void setEngineVolume(double engineVolume) {
        if (engineVolume >= 0) {
            this.engineVolume = engineVolume;
        }
    }
    public void setTransmission(String transmission) {
        if (transmission != null || !transmission.isEmpty() || !transmission.isBlank()) this.transmission = transmission;
        else this.transmission = "Нет информации";
    }
    public void setRegNumber(String regNumber) {
        if (regNumber == null || regNumber.isEmpty() || regNumber.isBlank()) this.regNumber = "Нет информации";
        else {
            String modRegNumber = regNumber.replace(" ", "");
            modRegNumber = modRegNumber.toUpperCase();
            boolean correctNum = false;
            if (Pattern.matches("[авекмнорстухАВЕКМНОРСТУХ]\\d{3}[авекмнорстухАВЕКМНОРСТУХ]{2}\\d{2,3}", modRegNumber)) {
                this.regNumber = modRegNumber;
            } else {
                this.regNumber = "Некорректно указан г/н";
            }
        }
    }
    public void setTires(String tires) {
        if (tires == null || tires.isEmpty() || tires.isBlank()) this.tires = "Нет информации";
        else if (tires.equalsIgnoreCase("зимняя") || tires.equalsIgnoreCase("зима")) this.tires = "Зимняя";
        else if (tires.equalsIgnoreCase("летняя") || tires.equalsIgnoreCase("лето")) this.tires = "Летняя";
        else this.tires = "Некорректные данные";
    }
    public void setBodyType(String bodyType) {
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) this.bodyType = "Нет информации";
        else this.bodyType = bodyType;
    }
    public void setSeats(int seats) {
        if (seats <= 0) this.seats = 1;
        else this.seats = seats;
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
            case "Электро":
                System.out.println("Заряжается на электропарковке");
                break;
            default:
                System.out.println("Неизвестен тип двигателя");
                break;
        }
    }

    @Override
    public String toString() {
        return "\n" + getBrand() + " " + getModel() + "\n" +
                "Год выпуска: " + getYear() + "\n" +
                "Cтрана сборки: " + getCountry() + "\n" +
                "Цвет: " + getColor() + "\n" +
                "Тип двигателя" + getEngineType() + "\n" +
                "Объем двигателя: " + (engineVolume == 0 ? "Нет информации" : engineVolume + " л.\n") +
                "Трансмиссия: " + transmission + "\n" +
                "Кузов: " + bodyType + "\n" +
                "Максимальная скорость: " + (getMaxSpeed() == 0 ? "Нет информации\n" : getMaxSpeed() + "\n") +
                "г/н: " + regNumber + "\n" +
                "Сидячих мест: " + (seats == 1 ? seats + " указано по умолчанию\n" : seats + "\n") +
                "Сезонность шин: " + tires + "\n" +
                "Ключ: \n" + (key != null ? key : "\tИнформации о ключе отсутствует\n") +
                "ОСАГО: \n" + (insurance != null ? insurance : "\tИнформации об ОСАГО отсутствует");
    }


}
