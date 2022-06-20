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
    public boolean equals(Object o) {   // не знаю, насколько адекватно я подогнал метод под свои нужды,
        // но пока он справляется со своей задачей.
        // хотелось бы сделать метод, игнорирующий регистр, но прочтение документации по
        // eqals привело меня в тёмный лес непонимания, как это сделать ((
        // форумы и WikiHow не курил, так как в ДЗ это не по понятиям)
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
    public int hashCode() {  // не в полной мере понимаю этот метод, но подозреваю, что он архиважен.
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
