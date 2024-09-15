/* 
 *  Задание j2
 *  Java: Строки (1 неделя)
 *  Входные данные задаются как параметры командной строки.
 *  Показать генерацию и обработку исключительной ситуации
 *  собственного класса.
 *  При работе со строками использовать классы StringBuffer или StringBuilder.
 *  Если нужно разбивать строку на элементы, использовать класс StringTokenizer 
 *         либо использовать метод класса String.
 *  Продемонстрировать работу данного проекта без среды, т.е. осуществть запуск через командную строку.
 *          (Есть run.cmd файл который запускает программу)
 *  1. Из заданной строки исключить символы, расположенные между cамыми вложенными круглыми скобками.
*/
/*
 *  Уточнения:
 *  1) Скобочнаяа последовательность должна быть сбалансированной,
 *          но в ином случае будет обработано исключение
 *  2) Исключаются все символу между самыми вложенными скобками, включая скобки
 *  3) Если есть несколько скобок максимальной вложенности исключаются все из них
 *  4) Строка ввода не должна быть пустой, в противном случае будет обработка исключения
*/

import java.util.StringTokenizer;

class InvalidInput extends Exception {
    public InvalidInput(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new InvalidInput("Error: Empty input");
            }
            System.out.println("Input  : " + args[0].toString());
            System.out.println("Output : " + nestingRemove(args[0]));
        } catch (InvalidInput e) {
            System.err.println(e.getMessage());
        }
    }

    public static String nestingRemove(String input) throws InvalidInput {
        // Проверка сбалансированности скобок
        int openBraketsCount = 0;
        int closeBraketsCount = 0;
        for (char i : input.toCharArray()) {
            if (i == '(') {
                openBraketsCount++;
            } else if (i == ')') {
                closeBraketsCount++;
            }
        }
        if (openBraketsCount != closeBraketsCount) {
            throw new InvalidInput("Error: Unbalanced brakets");
        }

        // Просчитывание вложенностей
        StringTokenizer st = new StringTokenizer(input, "()", true);
        StringBuffer sb = new StringBuffer();
        int currentNesting = 0;
        int maxNesting = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("(")) {
                currentNesting++;
            }
            if (token.equals(")")) {
                currentNesting--;
            }
            if (currentNesting >= maxNesting) {
                maxNesting = currentNesting;
            }
        }

        // Удаление символов между самыми вложенными скобками
        currentNesting = 0;
        st = new StringTokenizer(input, "()", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("(")) {
                currentNesting++;
            }
            if (currentNesting < maxNesting) {
                sb.append(token);
            }
            if (token.equals(")")) {
                currentNesting--;
            }
        }
        return sb.toString();
    }
}
