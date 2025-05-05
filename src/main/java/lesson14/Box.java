package lesson14;

import java.util.Iterator;
import java.util.List;

public class Box {
    private int width;
    private int height;
    private int depth;

    public Box (int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getDepth(){
        return depth;
    }

    public static void filterBox (List<Box> source, List<Box> destination, int minWidth){
        Iterator<Box> iterator = source.iterator();
        while (iterator.hasNext()){
            Box box = iterator.next();
            if (box.getWidth()>minWidth){
                destination.add(box);
                iterator.remove();
            }
        }
    }

    @Override
    public String toString(){
        return "Коробка: ширина="+width+", длина="+height+", глубина="+depth;
    }
}
