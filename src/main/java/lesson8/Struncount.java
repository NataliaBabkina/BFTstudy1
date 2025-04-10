package lesson8;

public class Struncount {
    public enum StringCount {
        GITARA(7),
        PIANO(100);
        private final int count;

        StringCount(int count) {
            this.count = count;        }

        public int getCount() {
            return count;
        }
    }

}
