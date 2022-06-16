import java.util.Objects;

public class Word {
    private final String drowing;
private static int counter;
int id;
    public Word(String drowing) {
        this.drowing = drowing;
    id = ++ counter;
    }

    public String getDrowing() {
        return drowing;
    }

    @Override
    public String toString() {
        return (drowing /*+ " - объект типа Word, id: " + id*/);
    }

    @Override
    public boolean equals(Object o) {
        if (this.drowing == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return getDrowing().equals(word.getDrowing());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrowing());
    }
}
