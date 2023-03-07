import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

//  Напишите программу создания небольшого словаря сленговых программерских выражений, чтобы она
//  потом по запросу возвращала значения из этого словаря.
//
//  Формат входных данных
//  Файл dict.txt
//  В первой строке задано одно целое число n — количество слов в словаре.В следующих n строках
//  записаны слова и их определения, разделенные двоеточием и символом пробела.
//
//  Ввод с клавиатуры
//  В первой строке записано целое число m — количество поисковых слов, чье определение нужно
//  вывести. В следующих m строках записаны сами слова, по одному на строке.
//
//  Формат выходных данных
//  Для каждого слова, независимо от регистра символов, если оно присутствует в словаре, необходимо
//  вывести на экран его определение.
//  Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
//
//  Примечание 1
//  Мини-словарь для начинающих разработчиков можно посмотреть тут.
//  Примечание 2
//  Гарантируется, что в определяемом слове или фразе отсутствует двоеточие (:), следом за которым
//  идёт пробел.
//
//  Пример входных данных
//  5
//  Змея: язык программирования Python
//  Баг: от англ. bug — жучок, клоп, ошибка в программе
//  Конфа: конференция
//  Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
//  Бета: бета-версия, приложение на стадии публичного тестирования
//  3
//  Змея
//  Жаба
//  костыль
//  Пример выходных данных
//  язык программирования Python
//  Не найдено
//  код, который нужен, чтобы исправить несовершенство ранее написанного кода

  public static Map<String, String> readDictionaryFromFile(File inputFile) throws IOException {
    Map<String, String> dictionary = new HashMap<>();
//    try {
    BufferedReader br = new BufferedReader(new FileReader(inputFile)); // ошибка, если файла нет

    int n = Integer.parseInt(br.readLine()); // ошибка, только если файл неправильный
    for (int i = 0; i < n; ++i) { // прочитать n раз
      String line = br.readLine(); // "Змея: язык программирования Python"
      int spaceIndex = line.indexOf(':'); // индекс разделителя (4)
      // с начала и до двоеточия - слово
      String word = line.substring(0, spaceIndex); // "Змея" // ошибка, если файл неправильный
      // строка с определением - от "после двоеточия и пробела" до конца
      String definition = line.substring(spaceIndex + 2); //
      dictionary.put(word, definition); // записываем в словарь
    }
    br.close();
//    } catch (FileNotFoundException e) {
//      System.err.println("Файл не найден: " + e.getMessage());
//    } catch (IndexOutOfBoundsException e) {
//      // если при поиске пробела получили -1 и подставили его в substring
//      System.err.println("Ошибка в файле");
//    }
    return dictionary;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<String, String> dictionary = readDictionaryFromFile(new File("res/dict.txt"));

    int m = Integer.parseInt(br.readLine());
    ArrayList<String> wordList = new ArrayList<>();
    for (int i = 0; i < m; ++i) { // прочитать m раз
      wordList.add(i + 1, br.readLine());
    }

    for (int x = 0; x < m; ++x) { // проверить m раз
      if (dictionary.containsKey(wordList.get(x))) {
        System.out.println(dictionary.get(wordList.get(x)));
      }
      System.out.println("Не найдено");
    }
  }


}
