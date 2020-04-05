package practice10;

public class Student extends Person {
    private final Klass klass;
    
    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String isLeaderIntroduce = isLeaderOf(klass) ? "Leader of " : "at ";
        return super.introduce() + " I am a Student. I am " + isLeaderIntroduce + "Class " + getKlass().getNumber() + ".";
    }

    public boolean isLeaderOf(Klass klass) {
        if (klass.getLeader() == null) {
            return false;
        }
        return this.equals(klass.getLeader());
    }
}
