package lesson14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(14,10,22));
        boxes.add(new Box(33,28,7));
        boxes.add(new Box(30,11,38));
        boxes.add(new Box(27,70,59));
        boxes.add(new Box(49,19,44));
        boxes.add(new Box(19,19,19));

        List<Box> wideBoxes = new ArrayList<>();

        Box.filterBox(boxes, wideBoxes, 30);

        System.out.println("Ширина меньше 30 см: ");
        boxes.forEach(System.out::println);

        System.out.println("Ширина больше 30 см: ");
        wideBoxes.forEach(System.out::println);
    }
}
