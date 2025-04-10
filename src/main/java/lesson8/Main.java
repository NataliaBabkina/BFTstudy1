package lesson8;

public class Main {
    public static void main(String[] args) {

        Playable gitara = new Gitara();
        Playable piano = new Piano();

        gitara.play(Struncount.StringCount.GITARA.getCount());
        piano.play(Struncount.StringCount.PIANO.getCount());
    }
}
