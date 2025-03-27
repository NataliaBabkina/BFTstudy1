package lesson4;

public class Car {
    public String model;
    public int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Car(String model) {
        this.model = model;
    }

    public void makeBeBe() {
        if (year == 0) {
            System.out.println(model + " уточните год выпуска");
        } else {
            System.out.println(model + " " + year);
        }
    }
    public void makeBeBe(boolean available) {
        System.out.println(model + " " + year + " нет в наличии");
    }
}

