package practice06;

public class Teacher extends Person {
    private int classNumber;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int classNumber) {
        super(name, age);

        this.classNumber = classNumber;
    }

    public int getKlass() {
        return classNumber;
    }

    @Override
    public String introduce() {
        String teachClassString = getKlass() == 0 ? "No Class." : "Class " + getKlass() + ".";
        return super.introduce() + " I am a Teacher. I teach " + teachClassString;
    }
}
