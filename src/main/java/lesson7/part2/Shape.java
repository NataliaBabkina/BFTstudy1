package lesson7.part2;

abstract class Shape {
    public abstract void draw ();
}
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисуется круг");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисуется прямоугольник");
    }
}

