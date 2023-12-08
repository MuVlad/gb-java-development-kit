package mu.vlad.junior.stream_API.hw_2;

/*
Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Animal[] animals = new Animal[]{
                new Cat(),
                new Dog(),
                new Cat("Boris", 11),
                new Dog("Sharik", 3)
        };

        for (Animal animal : animals) {
            Class<?> objClass = animal.getClass();

            System.out.printf("Class name: %s\n", objClass.getName());

            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.printf("%s: %s\n", field.getName(), field.get(animal));
            }

            Method[] methods = objClass.getDeclaredMethods();

            for (Method method : methods) {
                method.setAccessible(true);
                method.invoke(animal);
            }
            System.out.println("___________________________________________________");
        }
    }
}
