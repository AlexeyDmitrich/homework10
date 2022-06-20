import java.util.Objects;

public class Contact {
    private String name; // read as surname


    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Contact){
            if (this.name == ((Contact) o).name){
                return true;
            }
        }
        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
