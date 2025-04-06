package lesson7.part1;

public class Employee {
    public String name;
    public int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " за " + salary + " руб" + " работает за всех");
    }
}

class Manager extends Employee {
    public Manager(String name, int salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println(name+" за "+ salary + " руб" +" руководит");
    }
    public void workParent(){
        super.work();
    }
}

class Developer extends Employee {
    public Developer(String name, int salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println(name+" за "+salary+" руб" + " разрабатывает");
    }
}

