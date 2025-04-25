package lesson6;

public class Main {
    public static void main(String[] args) {
        String[] array = {"привет", "ПОКА", "гипербола"};
        System.out.println(array[0].toUpperCase());
        System.out.println(array[1].toLowerCase());
        for (String str : array) {
            if (str.length() >= 4 && str.charAt(1) == 'О') {
                StringBuilder sb = new StringBuilder(str);
                sb.insert(3, ' ');
                System.out.println(sb);
            }
        }
        printRandomString(array);
    }

    public static void printRandomString(String[] array) {
        int randomIndex = (int) (Math.random() * array.length);
        System.out.println("Случайная строка: " + array[randomIndex]);
    }
}

