package mu.vlad.seminar_3;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 sum(), multiply(), divide(), subtract(). Параметры этих методов – два
числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {

    public static <T extends Number> double sum(T t1, T t2) {
       return t1.doubleValue() + t2.doubleValue();
    }

    public static <T extends Number> double multiply(T t1, T t2) {
        return t1.doubleValue() * t2.doubleValue();
    }

    public static <T extends Number> double divide(T t1, T t2) {
        return t1.doubleValue() / t2.doubleValue();
    }

    public static <T extends Number> double subtract(T t1, T t2) {
        return t1.doubleValue() - t2.doubleValue();
    }
}
