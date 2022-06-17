import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class WordsList {
    public static void main(String[] args) {
        ArrayList <Word> words = new ArrayList<>();
        String[] wordsArr = {"ночь", "улица", "фонарь", "аптека", "свет", "четверть", "исход", "начало", "ночь", "рябь", "канал", "аптека", "улица", "фонарь"};
        addInList(wordsArr, words);

        System.out.println("Полная коллекция");
        System.out.println("-------------------");
        print(words);
        System.out.println();

        HashSet<Word> unicWords = new HashSet<>();
        addInSetList(wordsArr, unicWords);

        System.out.println("*******************");
        System.out.println("Коллекция без дубликатов:");
        System.out.println("-------------------");
        for (Word word:unicWords) {
             System.out.println(word);
        }
        System.out.println();
        System.out.printf("Коллекция содежит %d элементов\n", unicWords.size());
        System.out.println();
        System.out.println("*******************");


    }

    static void addInList(String[] array, ArrayList list){
        for (int i = 0; i < array.length; i++) {
            list.add(new Word(array[i]));
        }
    }
    static void addInSetList(String[] array, HashSet<Word> list){
        for (int i = 0; i < array.length; i++) {
        //    System.out.println("Добавляем строку - " + array[i]);
        //    System.out.println();
            list.add(new Word(array[i]));
        /*    for (Word word : list){
                System.out.println(word);
            }
            System.out.println("-------------------");
            System.out.printf("Коллекция содежит %d элементов", list.size());
            System.out.println();
            System.out.println("=================");
            System.out.println();
        */
        }
    }

    static void print (ArrayList<Word> words){
    String orphographic;
    int uniCounter = 0;
        for (Word word:words) {
            if (Collections.frequency(words, word) > 1 && Collections.frequency(words, word) < 5){
                orphographic = " раза";
            } else {orphographic = " раз";}
        if (Collections.frequency(words, word) == 1){
            System.out.println(word + " (уникальный элемент)");
            uniCounter ++;
        } else {
            System.out.println(word + " (повторяется " + Collections.frequency(words, word) + orphographic + ")");
        }
    }
        System.out.println();
        System.out.printf("Коллекция содежит %d элементов, из них %d - уникальных\n", words.size(), uniCounter);
    }
}
