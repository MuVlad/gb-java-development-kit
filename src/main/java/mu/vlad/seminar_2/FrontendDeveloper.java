package mu.vlad.seminar_2;

public class FrontendDeveloper extends Developer{

    @Override
    void drinkCoffee() {
        System.out.println("drinkCoffee");
    }

    @Override
    void smoke() {
        System.out.println("smoke");
    }

    public void developGUI() {
        System.out.println("create GUI");
    }
}
