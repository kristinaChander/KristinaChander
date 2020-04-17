package hw6;

import java.util.Objects;

public class UserTableRow {

    private String number;
    private String user;
    private String description;

    public UserTableRow(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTableRow)) return false;
        UserTableRow that = (UserTableRow) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(user, that.user) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }
}
