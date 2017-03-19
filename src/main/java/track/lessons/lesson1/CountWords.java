package track.lessons.lesson1;

import java.io.File;
import java.io.InterruptedIOException;
import java.util.Scanner;

/**
 * Задание 1: Реализовать два метода
 *
 * Формат файла: текстовый, на каждой его строке есть (или/или)
 * - целое число (int)
 * - текстовая строка
 * - пустая строка (пробелы)
 *
 *
 * Пример файла - words.txt в корне проекта
 *
 * ******************************************************************************************
 *  Пожалуйста, не меняйте сигнатуры методов! (название, аргументы, возвращаемое значение)
 *
 *  Можно дописывать новый код - вспомогательные методы, конструкторы, поля
 *
 * ******************************************************************************************
 *
 */
public class CountWords {

    /**
     * Метод на вход принимает объект File, изначально сумма = 0
     * Нужно пройти по всем строкам файла, и если в строке стоит целое число,
     * то надо добавить это число к сумме
     *
     * @param file - файл с данными
     * @return - целое число - сумма всех чисел из файла
     */

    public long countNumbers(File file) throws Exception {
        Scanner sc = new Scanner(file);
        long sum = 0;
        while (sc.hasNext()) {
            String snext = sc.nextLine();
            if (snext.matches("^-?\\d+$")) {
                sum += Integer.parseInt(snext);
            } else {
                continue;
            }

        }
        return sum;
    }


    /**
     * Метод на вход принимает объект File, изначально результат= ""
     * Нужно пройти по всем строкам файла, и если в строка не пустая и не число
     * то надо присоединить ее к результату через пробел
     *
     * @param file - файл с данными
     * @return - результирующая строка
     */
    public String concatWords(File file) throws Exception {
        Scanner sc = new Scanner(file);
        String result = "";
        while (sc.hasNext()) {
            String snext = sc.nextLine();
            if (!(snext.matches("^-?\\d+$") || snext.isEmpty())) {
                result += snext + " " ;
            } else {
                continue;
            }
        }
        return result;
    }

    public static void main(String[] strings) {
        String filename = "/home/fedor/track_java/track17-spring/words.txt";
        CountWords cw = new CountWords();
        File file = new File(filename);
        try {
            long cnum = cw.countNumbers(file);
            String cwords = cw.concatWords(file);
            System.out.println(cnum);
            System.out.println(cwords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}