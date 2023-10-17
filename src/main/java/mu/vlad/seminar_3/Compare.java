package mu.vlad.seminar_3;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и
возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
типа.
 */
public class Compare {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr2.length != arr1.length) {
            return false;
        }
        for (int i = 0; i < arr1.length - 1; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
