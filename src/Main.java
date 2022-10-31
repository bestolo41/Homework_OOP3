import transport.Bus;
import transport.Train;
import transport.Transport;

public class Main {
    public static void main(String[] args) {
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
