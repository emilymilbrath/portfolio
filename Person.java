public class Person implements Human {
    private int age;
    private String name;
    
    public Person(String name, int age) {
        if(name.trim().equals("") || age<0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.name = name;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return "Person:[" +  getName() + ", " + getAge() + "]";
    }
    
    public boolean equals(Object o) {
        if(o instanceof Person) {
            Person p = (Person)o;
            return p.getAge() == this.getAge() && p.getName() == this.getName();
        } else {
            return false;
        }
    }
    
    public int compareTo(Human h) {
        if(h.getAge() > this.getAge()) {
                return -1;
        } else if(h.getAge() < this.getAge()) {
                return 1;
        } else {
                return 0;
        }
            
    }
}
        
