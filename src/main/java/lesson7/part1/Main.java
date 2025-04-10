package lesson7.part1;

public class Main {
    public static void main(String[] args){
        Manager m1 = new Manager ("Елена", 200000);
        Manager m2 = new Manager ("Игорь", 5000);
        Developer d1 = new Developer ("Иван", 250000);

        m1.work();
        m2.workParent();
        d1.work();
    }
}
