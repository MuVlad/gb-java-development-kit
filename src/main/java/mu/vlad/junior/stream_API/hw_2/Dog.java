package mu.vlad.junior.stream_API.hw_2;

public class Dog extends Animal {

    private String name;
    private int age;

    public Dog() {
        this.name = "Dog";
        this.age = 7;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("auf-auf");
    }

    public void dogInfo() {
        System.out.println("dogs love bones.");
    }

}
