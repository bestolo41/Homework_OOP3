import transport.Bus;
import transport.Car;
import transport.Train;
import transport.Transport;

public class Main {
    public static void main(String[] args) {
        Car granta = new Car("Lada", "Granta", "Бензин", 1.7,"Желтый", 2015, "Россия", "МКПП", 190, "Лифтбек",
                "в601та716", 5, "Зимняя");

        Car audi = new Car("Audi", "A8 50 L TDI quattro", "Дизель",3.0, "Черный", 2020, "Германия", "РКПП", 250, "Седан",
                "а543мв77", 5, "Летняя");

        Car bmw = new Car("BMW", "Z8", "Бензиновый",3.0, "Черный", 2021, "Германия", "АКПП", 260, "Купе",
                "т777тт77", 2, "Лето");

        Car kia = new Car("Kia", "Sportage 4-го поколения", "Бензин",2.4, "Красный", 2018, "Южная Корея", "АКПП",
                210, "SUV", "р739ак198", 5, "Зима");

        Car hyundai = new Car("Hyundai", "Avante", "Дизельный",1.6, "Оранжевый", 2016, "Южная Корея", "АКПП",
                220, "Седан", "с961вт21", 5, "Лето");


        Transport lastochka = new Train("Ласточка", "В-901", 2011, "Россия",
                "", 301, 3500, "", "Белорусский вокзал",
                "Минск-Пассажирский",
                11);

        Transport leningrad = new Train("Ленинград", "D-125", 2019, "Россия",
                "", 270, 1700, "", "Ленинградский вокзал",
                "Ленинград-Пассажирский", 8);

        System.out.println(lastochka);
        System.out.println(leningrad);

        Transport bus1 = new Bus("Mersedes", "Sprinter", "Бензин", 2015, "Germany", "White", 130);
        Transport bus2 = new Bus("Ford", "Transit", "Дизель", 2017, "Russia", "Blue", 120);
        Transport bus3 = new Bus("GAZ", "Gazelle", "Бензин",2019, "Russia", "Yellow", 100);

        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);

        bus1.refill();
        bus2.refill();
        bus3.refill();
    }
}
