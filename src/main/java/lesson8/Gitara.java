package lesson8;

public class Gitara implements Playable {
    @Override
    public void play(int stringCount) {
        System.out.println("Гитара играет, используя " + stringCount + " струн");
    }
}