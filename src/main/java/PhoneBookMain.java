/**
 * Это основной класс по 2-му заданию.
 * Телефонная книга содержит 4 дефолтных контакта, функционал предусматривает:
 * Поиск по фамилии;
 * Добавление нового контакта;
 * Добавление нового контакта, если он не найден по запросу;
 * Чтение всего справочника;
 * Не смотря на условие задачи, всё реализовано через консольный ввод-вывод,
 * так как я не знаю, как реализовать интерактивность другими способами.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookMain {
    static Scanner input = new Scanner(System.in);

    /**
     * Основной метод.
     * Содержит скелет и дефолтную часть телефонной книги,
     * а так же интерактивную часть прогона по меню.
     * @param args
     */
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

        int request = 0;
        do {
            printMenu();
            if (input.hasNextInt()){
                request = input.nextInt();
                switch (request){
                    case 0:
                        System.out.println("Завершение работы программы.");
                        return;
                    case 1:
                        getRequest(phoneBook);
                        break;
                    case 2:
                        addRequest(phoneBook);
                        break;
                    case 3:
                        printAll(phoneBook);
                        break;
                    default:
                        System.out.println("Введен неверный запрос");
                }
            } else {
                System.out.println("Введен неверный запрос");
                input.nextLine();
            }
        } while (request != 0);
    }

    /**
     * метод предназначен исключительно для графического отображения меню
     */
    static void printMenu (){
        System.out.println("________________________________");
        System.out.println("|       Телефонная книга       |");
        System.out.println("|------------------------------|");
        System.out.println("|1 - Поиск контакта по фамилии |");
        System.out.println("|2 - Добавление нового контакта|");
        System.out.println("|3 - Показать весь справочник  |");
        System.out.println("|                              |");
        System.out.println("|0 - Выход                     |");
        System.out.println("|______________________________|");

    }

    /**
     * Перегруженный метод
     * Обработка запроса на добавление контакта в справочник,
     * в процессе работы запросит фамилию и номер телефона.
     * В случае, если контакт под этой фамилией уже имеется - номер будет добавлен к нему.
     * В случае уникальности фамилии - будет создан новый контакт
     * @param phoneBook как аргумент принимает сам справочник,
     *                  при перегрузке принимает сразу имя нового контакта
     */
    static void addRequest(HashMap phoneBook) {
        System.out.println("|---------------------------------------------|");
        System.out.println("|Добавление нового контакта в телефонную книгу|");
        System.out.println("|---------------------------------------------|");
        System.out.println("Введите фамилию:");
        String named = input.next();
        Contact name = new Contact(named);
        System.out.println("Введите номер телефона:");
        String number = input.next();
        System.out.println("Сохранение...");

        if (!(phoneBook.containsKey(name))) {
            System.out.print("новый контакт ");
            ArrayList<Phone> phones = new ArrayList<>();
            phones.add(new Phone(number));
            phoneBook.put(name, phones);
        }
        else {
            System.out.println("такой контакт уже был");
            ArrayList<Phone> phones = (ArrayList<Phone>) phoneBook.get(name);
            phones.add(new Phone(number));
            System.out.print("новый номер для этого контакта");
        }
        System.out.println("сохранен \n");
    }

    static void addRequest(HashMap phoneBook, Contact name) {
        System.out.println("Добавление контакта " + name + " в телефонную книгу");
        System.out.println("Введите номер телефона:");
        String number = input.next();
        System.out.println("Сохранение...");

        if (!(phoneBook.containsKey(name))) {
            System.out.print("новый контакт ");
            ArrayList<Phone> phones = new ArrayList<>();
            phones.add(new Phone(number));
            phoneBook.put(name, phones);
        }
        else {
            System.out.println("такой контакт уже был");
            ArrayList<Phone> phones = (ArrayList<Phone>) phoneBook.get(name);
            phones.add(new Phone(number));
            System.out.print("новый номер для этого контакта ");
        }
        System.out.print("сохранен\n");
    }

    /**
     * Метод для поиска абонента по фамилии, выведет все возможные номера, записанные под этой фамилией.
     * @param phoneBook принимает справочних на вход, остальное получает при взаимодействии с пользователем.
     */
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

    /**
     * метод для печати всей телефонной книги.
     * @param phoneBook на ввод принимает телефонную книгу, которую нужно вывести в консоль
     */
    static void printAll (HashMap<Contact, ArrayList<Phone>> phoneBook){
        System.out.println("Телефонная книга:\n");
        for (Map.Entry<Contact, ArrayList<Phone>> o:
                phoneBook.entrySet()) {
            System.out.println(o.getKey() + ", телефон: " + o.getValue());
        }
    }


}
