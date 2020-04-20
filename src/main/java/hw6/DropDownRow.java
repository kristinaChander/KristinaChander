package hw6;

import java.util.Objects;

public class DropDownRow {

    private String value;

    public DropDownRow(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DropDownRow)) return false;
        DropDownRow that = (DropDownRow) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
