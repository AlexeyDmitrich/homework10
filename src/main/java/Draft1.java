import java.util.*;

public class Draft1 {
    //TODO: фамилия - номер, (запилить класс)
    // add для добавления контакта,
    // get для чтения контакта по фамилии,
    // под одной фамилией может быть несколько номеров
    //
static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Contact, ArrayList<Phone>> phoneBook = new HashMap<>();

        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("+79111231212"));
        phoneBook.put(new Contact("Образцов"), phones);
        ArrayList<Phone> phones2 = new ArrayList<>();
        phones.add(new Phone("+79107656543"));
        phoneBook.put(new Contact("Примеров"), phones);
        ArrayList<Phone> phones3 = new ArrayList<>();
        phones.add(new Phone("+79320986745"));
        phoneBook.put(new Contact("Иванов"), phones);
        ArrayList<Phone> phones4 = new ArrayList<>();
        phones.add(new Phone("+72141231212"));
        phoneBook.put(new Contact("Петров"), phones);

        TreeMap<? extends Object, ArrayList<Phone>> sortedPhoneBook = new TreeMap<>(phoneBook);

        addRequest(phoneBook);
        System.out.println();
        printAll(phoneBook);
        printSorted(sortedPhoneBook);
    }
    static void addRequest (HashMap phoneBook){
        System.out.println("Добавление нового контакта в телефонную книгу");
        System.out.println("Введите фамилию:");
        String named = input.next();
        Contact name = new Contact(named);
        System.out.println("Введите номер телефона:");
        String number = input.next();
        System.out.println("Сохранение...");

        if (!(phoneBook.containsKey(name))) {
            System.out.println("новый контакт");
            ArrayList<Phone> phones = new ArrayList<>();
            phones.add(new Phone(number));
            phoneBook.put(name, phones);
         }

        else {
            System.out.println("такой контакт уже был");
           ArrayList<Phone> phones = (ArrayList<Phone>) phoneBook.get(name);
           phones.add(new Phone(number));
        }
    }
    static void printAll (HashMap<Contact, ArrayList<Phone>> phoneBook){
        System.out.println("Телефонная книга:\n");
        for (Map.Entry<Contact, ArrayList<Phone>> o:
                phoneBook.entrySet()) {
            System.out.println(o.getKey() + ", телефон: " + o.getValue());
        }
    }
    static void printSorted (TreeMap<? extends Object, ArrayList<Phone>> sorted){
        System.out.println("Полный вывод");
        for (Map.Entry<? extends Object, ArrayList<Phone>> item: sorted.entrySet()){
            System.out.println(item.getKey());
            for (Phone phone: item.getValue()) {
                System.out.println(phone.getNumber());
            }
        }
    }
}
