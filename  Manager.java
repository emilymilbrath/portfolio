public class Manager extends Employee {
    private ArrayList<Employee> team = new ArrayList<Employee>();
    

    public Manager(String name, int age, String employer, int salary) {
        super(name, age, employer, salary);
    }
    
    public ArrayList<Employee> getTeam() {
        return team;
    }
    
    public void addEmployee(Employee e) {
        this.getTeam().add(e);
    }
    
    public int getSalary() {
        int teamSalary = 0;
        for(int i = 0; i < this.getTeam().size(); i++) {
            teamSalary += this.getTeam().get(i).getSalary();
        }
        return super.getSalary() + teamSalary/this.getTeam().size();
    }
    
    public int compareTo(Human h) {
        if(super.compareTo(h) == 0) {
            if(h instanceof Manager) {
                Manager m = (Manager)h;
                if(m.getTeam().size() > this.getTeam().size()) {
                    return -1;
                } else if (m.getTeam().size() < this.getTeam().size()) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return super.compareTo(h);
        }
    }
    
    public boolean equals(Object o) {
        if(o instanceof Manager) {
            Manager m = (Manager)o;
            return super.equals(m) && m.getTeam() == this.getTeam();
        } else {
            return super.equals(o);
        }
    }
    
    public String toString() {
        return "Manager:[" +  super.getName() + ", " + super.getAge() + "][" + super.getEmployer() + ", " + getSalary() + "][Team: " + this.getTeam().size() + "]";
    }
}
