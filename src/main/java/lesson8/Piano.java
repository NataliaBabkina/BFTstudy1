package lesson8;

public class Piano implements Playable {
    @Override
    public void play(int stringCount) {
        System.out.println("Пианино играет, используя " + stringCount + " струн");
    }
}
