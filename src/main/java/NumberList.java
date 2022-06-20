/**
 * Класс планировался для использования в качестве массива номеров абонента,
 * его применение не дало значимого результата, поэтому его разработку пришлось забросить.
 * Но он был интересен на первых отладках и, возможно, помог бы создать исключение
 * при добавлении записи с номером, который уже использовался.
 */

import java.util.ArrayList;
public class NumberList {
    ArrayList<Phone> numbers;

    public NumberList(Phone number) {
        this.numbers = new ArrayList<Phone>();
        this.numbers.add(number);
    }

    public ArrayList<Phone> getNumbers() {
        return numbers;
    }

    public void addNumbers(Phone number) {
        System.out.println("добавление номера " + number);
        System.out.println("было: " + numbers);
        numbers.add(number);
        System.out.println("стало: " + numbers.toString());
    }

    @Override
    public String toString() {
        String str = null;
        for (Phone number : numbers){
        str = (" "+ number);}
    return str;
    }
}
