package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);

        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String teachClassString = getKlass() != null ? "Class " + getKlass().getNumber() + "." : "No Class.";
        return super.introduce() + " I am a Teacher. I teach " + teachClassString;
    }

    public String introduceWith(Student jerry) {
        String introduceWithJerry = isTeach(jerry) ? "I teach " + jerry.getName() : "I don't teach " + jerry.getName();
        return super.introduce() + " I am a Teacher. " + introduceWithJerry + ".";
    }

    private boolean isTeach(Student jerry) {
        if (getKlass() == null || jerry.getKlass() == null) {
            return false;
        }
        return jerry.getKlass().getNumber() == this.getKlass().getNumber();
    }
}
