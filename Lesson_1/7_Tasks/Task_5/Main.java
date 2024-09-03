// Что произойдет, если привести числовое значение типа double к значению
// типа int, которое больше самого большого значения типа int? Попробуйте
// сделать это

public class Main {
    public static void main(String[] args) {
        double maxDouble = Double.MAX_VALUE;
        int intNum = (int) maxDouble;
        System.out.println("Max double value : " + maxDouble);
        System.out.println("Max double value to int : " + intNum);
        System.out.println(maxDouble > intNum);
        // При приведении double к int результат максимальное значение int
        // а все биты которые за пределами размера int игнорируются
    }
}