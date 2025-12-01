package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Завдання 1: MyOptional ===");

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println("Порожній об'єкт: " + middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse('немає'): " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println("Заповнений об'єкт: " + username);
        System.out.println("get(): " + username.get());

        try {
            System.out.println("Спроба отримати значення з порожнього...");
            middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            System.out.println("Спроба створити MyOptional(null)...");
            new MyOptional<>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }


        System.out.println("\n=== Завдання 2: BookData ===");
        BookData[] books = {
                new BookData("Java for Beginners", "Author A", 10, 45.0),
                new BookData("Advanced Java", "Author B", 5, 25.0),
                new BookData("Clean Code", "Author C", 20, 80.0)
        };

        System.out.println("До сортування: " + Arrays.toString(books));
        Arrays.sort(books);
        System.out.println("Після сортування (за рейтингом):");
        for (BookData book : books) {
            System.out.println(book);
        }


        System.out.println("\n=== Завдання 3: Printer ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.print("Друк Integer[]: ");
        myPrinter.printArray(intArray);

        System.out.print("Друк String[]: ");
        myPrinter.printArray(stringArray);


        System.out.println("\n=== Завдання 4: Generic Filter ===");

        String[] words = {"apple", "banana", "pear", "kiwi", "pineapple"};
        Object[] longWords = filter(words, w -> w.length() > 5);
        System.out.println("Слова довші 5 букв: " + Arrays.toString(longWords));

        Integer[] nums = {10, 5, 20, 3, 99};
        Object[] bigNums = filter(nums, n -> n > 10);
        System.out.println("Числа більше 10: " + Arrays.toString(bigNums));


        System.out.println("\n=== Завдання 5: Generic Contains ===");
        String[] names = {"Ivan", "Petro", "Oleg"};
        System.out.println("Масив " + Arrays.toString(names) + " містить 'Petro'? " + contains(names, "Petro"));
        System.out.println("Масив " + Arrays.toString(names) + " містить 'Maria'? " + contains(names, "Maria"));


        System.out.println("\n=== Завдання 6: Tuples ===");

        GenericTwoTuple<String, Integer> studentInfo = new GenericTwoTuple<>("Іванов", 95);
        System.out.println("TwoTuple (Студент, Рейтинг): " + studentInfo);

        GenericThreeTuple<String, Integer, Boolean> fullInfo =
                new GenericThreeTuple<>("Петров", 60, true);
        System.out.println("ThreeTuple (Студент, Рейтинг, Бюджет): " + fullInfo);
    }

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }
}