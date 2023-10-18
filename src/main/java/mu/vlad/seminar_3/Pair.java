package mu.vlad.seminar_3;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 Класс должен иметь методы getFirst(), getSecond() для получения значений
пары, а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Pair <T,K> {
    T t;
    K k;

    public Pair(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getFirst() {
        return t;
    }

    public K getSecond() {
        return k;
    }

    @Override
    public String toString() {
        return t + " " + k;
    }
}
