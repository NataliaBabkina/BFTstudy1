package lesson13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;

public class Test1 {

    @Test
    void exception() {
        try {
            System.out.println((char[])null);
        } catch (NullPointerException e){
            System.out.println("NullPointerException: не заполнено обязательное значение " + e.getMessage());
            e.printStackTrace();
        }
        try {
            Assertions.assertTrue(false);
        } catch (AssertionError e){
            System.out.println("AssertionError: условие не выполнено"+ e.getMessage());
            e.printStackTrace();
        }
    }
}
