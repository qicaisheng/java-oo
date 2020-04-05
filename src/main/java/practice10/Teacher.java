package practice10;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private LinkedList<Klass> klasses = new LinkedList<>();

    public Teacher(String name, int age) {
        super(name, age);
    }
    
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klasses) {
        super(id, name, age);

        this.klasses = klasses;
    }
    
    @Override
    public String introduce() {
        List<String> teachClassesNumbers = getClasses().stream().map(Klass::getNumber).map(Object::toString).collect(Collectors.toList());
        String teachClassesString = String.join(", ", teachClassesNumbers);
        String teachClassString = getClasses().size() != 0 ? "Class " + teachClassesString + "." : "No Class.";
        return super.introduce() + " I am a Teacher. I teach " + teachClassString;
    }

    public String introduceWith(Student student) {
        String introduceWithStudent = isTeaching(student) ? "I teach " + student.getName() : "I don't teach " + student.getName();
        return super.introduce() + " I am a Teacher. " + introduceWithStudent + ".";
    }

    public boolean isTeaching(Student student) {
        if (getClasses() == null || student.getKlass() == null) {
            return false;
        }
        return this.getClasses().stream().anyMatch(student::isIn);
    }

    public List<Klass> getClasses() {
        return klasses;
    }

}
