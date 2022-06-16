import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
//import java.util.SortedSet;

public class WordsList {
    public static void main(String[] args) {
        ArrayList <Word> words = new ArrayList<Word>();
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
        */}
    }

    static void print (ArrayList<Word> words){
    for (Word word:words) {
        System.out.println(word);
    }
    }
//todo: расчет повторяющихся элементов
}
