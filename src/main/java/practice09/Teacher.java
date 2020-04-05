package practice09;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);

        this.klass = klass;
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String teachClassString = getKlass() != null ? "Class " + getKlass().getNumber() + "." : "No Class.";
        return super.introduce() + " I am a Teacher. I teach " + teachClassString;
    }

    public String introduceWith(Student student) {
        String introduceWithStudent = isTeach(student) ? "I teach " + student.getName() : "I don't teach " + student.getName();
        return super.introduce() + " I am a Teacher. " + introduceWithStudent + ".";
    }

    private boolean isTeach(Student jerry) {
        if (getKlass() == null || jerry.getKlass() == null) {
            return false;
        }
        return jerry.getKlass().getNumber() == this.getKlass().getNumber();
    }
}
