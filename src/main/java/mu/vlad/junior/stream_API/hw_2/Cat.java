package mu.vlad.junior.stream_API.hw_2;

public class Cat extends Animal {

    private String name;
    private int age;

    public Cat() {
        this.name = "Cat";
        this.age = 9;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void catInfo() {
        System.out.println("cats love milk.");
    }
}
