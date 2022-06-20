import java.util.*;

public class PhBookWithoutContactClass {

        //TODO: фамилия - номер, (запилить класс)
        // add для добавления контакта,
        // get для чтения контакта по фамилии,
        // под одной фамилией может быть несколько номеров
        //
        static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {
            HashMap<ArrayList<Phone>, String> phoneBook = new HashMap<>();

            ArrayList<Phone> phones = new ArrayList<>();
            phones.add(new Phone("+79111231212"));
            phoneBook.put(phones, new String("Образцов"));
            ArrayList<Phone> phones2 = new ArrayList<>();
            phones2.add(new Phone("+79107656543"));
            phoneBook.put(phones2, new String("Примеров"));
            ArrayList<Phone> phones3 = new ArrayList<>();
            phones3.add(new Phone("+79320986745"));
            phoneBook.put(phones3, new String("Иванов"));
            ArrayList<Phone> phones4 = new ArrayList<>();
            phones4.add(new Phone("+72149898908"));
            phoneBook.put(phones4, new String("Петров"));



            addRequest(phoneBook);
            System.out.println();
            printAll(phoneBook);
            printSorted(phoneBook);
        }
        static void addRequest (HashMap phoneBook){
            System.out.println("Добавление нового контакта в телефонную книгу");
            System.out.println("Введите фамилию:");
            String name = input.next();
            System.out.println("Введите номер телефона:");
            String number = input.next();
            System.out.println("Сохранение...");

            if (!(phoneBook.containsValue(name))) {
                System.out.println("новый контакт");
                ArrayList<Phone> phones = new ArrayList<>();
                phones.add(new Phone(number));
                phoneBook.put(phones, name);
            }

            else {
                System.out.println("такой контакт уже был");
                ArrayList<Phone> phones = (ArrayList<Phone>) phoneBook.(name);
                System.out.println("предыдущая версия: " + phones);
                phones.add(new Phone(number));
                System.out.println("измененная версия: " + phones);
            }
        }
        static void printAll (HashMap <ArrayList<Phone>, String> phoneBook){
            System.out.println("Телефонная книга:\n");
            for (Map.Entry<ArrayList<Phone>, String> o:
                    phoneBook.entrySet()) {
                System.out.println(o.getValue() + ", телефон: " + o.getKey());
            }
        }
        static void printSorted (HashMap<ArrayList<Phone>, String> phoneBook){
            TreeMap<ArrayList<Phone>, String> sortedPhoneBook = new TreeMap<>(phoneBook);
            System.out.println("Полный вывод");
            for (Map.Entry<ArrayList<Phone>, String> item: sortedPhoneBook.entrySet()){
                System.out.println(item.getValue());
                for (Phone phone: item.getKey()) {
                    System.out.println(phone.getNumber());
                }
            }
        }
    }
