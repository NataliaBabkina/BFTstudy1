package lesson5;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        float summa = 0;
        int months = 0;

        while (true) {
            System.out.print("Введите сумму вклада: ");
            if (scanner.hasNextFloat()) {
                summa = scanner.nextFloat();
                if (summa > 0) {
                    break;
                } else {
                    System.out.println("Введите положительное значение.");
                }
            } else {
                System.out.println("Введите число.");
                scanner.next();
            }
        }
        while (true) {
        System.out.print ("Введите количество месяцев: ");
            if (scanner.hasNextInt()) {
                months = scanner.nextInt();
                if (months > 0) {
                    break;
                } else {
                    System.out.println("Введите положительное значение.");
                }
            } else {
                System.out.println("Введите целое число.");
                scanner.next();
            }
        }

        Calculator calc = new Calculator();
        calc.summa = summa;
        calc.months = months;


    for (int m=1;m<= months; m++){
        float result = calc.calculate();
        calc.summa = result;
    }


    if (calc.months % 10 == 1 && calc.months % 100 != 11 )
       System.out.println("После " + calc.months + " месяца сумма вклада составит: " + calc.summa);
       else
          System.out.println("После " + calc.months + " месяцев сумма вклада составит: " + calc.summa);

    }
}
