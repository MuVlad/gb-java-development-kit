package mu.vlad.seminar_4;

import java.util.ArrayList;
import java.util.List;

/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников,
каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class EmployeeDirectory {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(0, "46456456", "Алекс", 10),
                new Employee(1, "9575789", "Алекс", 12),
                new Employee(2, "575756", "Василий", 8),
                new Employee(3, "475675647", "Михаил", 9),
                new Employee(4, "56457567657", "Анжелика", 11),
                new Employee(6, "56452227657", "Валентина", 10),
                new Employee(5, "45757567", "Александра", 15)));

        System.out.println(findEmployeeByExperience(employees, 10));
        System.out.println(findPhoneNumberByEmployeeName(employees, "Алекс"));
        System.out.println(findEmployeeByJobNumber(employees, 5));
        System.out.println(addEmployeeToList(employees, "Владислав", "2432145432", 3));
    }


    static List<Employee> findEmployeeByExperience(List<Employee> empls, int experience) {
        return empls.stream().filter(e -> e.getExperience() == experience).toList();
    }

    static List<String> findPhoneNumberByEmployeeName(List<Employee> emps, String name) {
        return emps.stream().filter(employee -> employee.name.equalsIgnoreCase(name)).map(e -> e.phone).toList();
    }

    static Employee findEmployeeByJobNumber(List<Employee> emps, int jobNumber) {
        return emps.stream().filter(e -> e.jobNumber == jobNumber).findAny().orElse(null);
    }

    static boolean addEmployeeToList(List<Employee> emps, String name, String phone, int experience) {
        int jobNumber = emps.stream().mapToInt(Employee::getJobNumber).max().getAsInt();
        return emps.add(new Employee(jobNumber + 1, phone, name, experience));
    }

}

class Employee {
    int jobNumber;
    String phone;
    String name;
    int experience;

    public Employee(int jobNumber, String phone, String name, int experience) {
        this.jobNumber = jobNumber;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "jobNumber=" + jobNumber +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}