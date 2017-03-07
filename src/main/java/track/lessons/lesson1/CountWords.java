package track.lessons.lesson1;

import java.io.File;
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
            String NumNext = sc.nextLine();
            if (NumNext.matches("^-?\\d+$")) {
                try {
                    sum += Integer.parseInt(NumNext);
                } catch (Exception e) {
                    //ignored
                }
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
        String result = "" ;
        while (sc.hasNext()) {
            String SNext = sc.nextLine();
            if (!(SNext.matches("^-?\\d+$") || SNext.isEmpty())) {
                try {
                    result += SNext + " " ;
                } catch (Exception e) {
                    //ignored
                }
            }
        }
        return result;
    }
}