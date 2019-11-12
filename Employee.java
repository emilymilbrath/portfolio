public class Employee extends Person {
    private String employer;
    private int salary;
    
    public Employee(String name, int age, String employer, int salary) {
        super(name, age);
        this.setEmployer(employer);
        this.setSalary(salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int getAge() {
        return super.getAge();
    }

    public String getName() {
        return super.getName();
    }
    
    public int compareTo(Human o) {
        if(super.compareTo(o) == 0) {
            if(o instanceof Employee) {
                Employee e = (Employee)o;
                if(e.getSalary() > this.getSalary()) {
                    return -1;
                } else if(e.getSalary() < this.getSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                throw new IllegalArgumentException("Incompatible inputs to compareTo");
            }
        } else {
            return super.compareTo(o);
        }
    }
    
    public boolean equals(Object o) {
        return super.equals(o);
    }
    
    public String toString() {
        return "Employee:[" +  getName() + ", " + getAge() + "][" + getEmployer() + ", " + getSalary() + "]";
    }
}

