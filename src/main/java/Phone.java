public class Phone {
    private String number;
    private Contact ovner;

    public Phone(String number) {
        this.number = number;
        this.ovner = ovner;
    }
    public String getNumber() {
        return number;
    }

    public Contact getOvner() {
        return ovner;
    }

    @Override
    public String toString() {
        return number;
    }
}
