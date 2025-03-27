package lesson4;

public class Main {
    public static void main(String[] args){
        Car car1 = new Car ("Audi A4 B6");
        Car car2 = new Car ("BMW 7 F01", 2008);
        Car car3 = new Car ("Kia Cerato 2", 2009);


        car1.makeBeBe();
        car2.makeBeBe();
        car3.makeBeBe(false);

        car1.model = "Haval H9";
        car1.year = 2014;

        car1.makeBeBe();
    }
}
