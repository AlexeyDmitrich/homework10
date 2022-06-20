import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Draft3 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Contact, ArrayList<Phone>> phoneBook = new HashMap<>();

        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("+79111231212"));
        phoneBook.put(new Contact("Образцов"), phones);
        ArrayList<Phone> phones2 = new ArrayList<>();
        phones2.add(new Phone("+79107656543"));
        phoneBook.put(new Contact("Примеров"), phones2);
        ArrayList<Phone> phones3 = new ArrayList<>();
        phones3.add(new Phone("+79320986745"));
        phoneBook.put(new Contact("Иванов"), phones3);
        ArrayList<Phone> phones4 = new ArrayList<>();
        phones4.add(new Phone("+72141231212"));
        phoneBook.put(new Contact("Петров"), phones4);

        printAll(phoneBook);
        addRequest(phoneBook);
        printAll(phoneBook);
        getRequest(phoneBook);
    }

    static void addRequest(HashMap phoneBook) {
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

    static void addRequest(HashMap phoneBook, Contact name) {
        System.out.println("Добавление контакта " + name + " в телефонную книгу");
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
            System.out.println("Добавлен новый номер");
        }
    }

    static void getRequest (HashMap phoneBook){
        System.out.println("Введите фамилию абонента");
        String named = input.next();
        Contact name = new Contact(named);

        if (phoneBook.containsKey(name)){
            System.out.println("Найдено по запросу:");
            System.out.println(name + ", возможные номера:");
            System.out.println(phoneBook.get(name));
        }
        else {
            System.out.println("Не удалось найти контактов по Вашему запросу,");
            System.out.println("хотите создать новый контакт? (Y/N или д/н)");
            String userResponse = input.next();
            if (userResponse.equals("y") || userResponse.equals("Y") || userResponse.equals("д") || userResponse.equals("Д")){
                addRequest(phoneBook, name);
            }
            else {
                return;
            }
        }
    }

    static void printAll (HashMap<Contact, ArrayList<Phone>> phoneBook){
        System.out.println("Телефонная книга:\n");
        for (Map.Entry<Contact, ArrayList<Phone>> o:
                phoneBook.entrySet()) {
            System.out.println(o.getKey() + ", телефон: " + o.getValue());
        }
    }


}