package mu.vlad.seminar_2;

public class Main {
    public static void main(String[] args) {
        Developer developer = new FrontendDeveloper();
        if (developer instanceof FrontendDeveloper) {
            ((FrontendDeveloper) developer).developGUI();
        }
    }
}
