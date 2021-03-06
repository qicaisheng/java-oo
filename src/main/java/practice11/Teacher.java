package practice11;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements KlassListener {
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
        this.klasses.forEach(this::subscribe);
    }

    private void subscribe(KlassSubject klassSubject) {
        klassSubject.register(this);
    }

    @Override
    public String introduce() {
        List<String> teachClassesNumbers = getClasses().stream().map(Klass::getNumber).map(Object::toString).collect(Collectors.toList());
        String teachClassesString = String.join(", ", teachClassesNumbers);
        String teachClassString = getClasses().size() != 0 ? String.format("Class %s.", teachClassesString) : "No Class.";
        return String.format("%s I am a Teacher. I teach %s", super.introduce(), teachClassString);
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

    @Override
    public void listen(Klass.KlassNotification klassNotification) {
        String notificationType = klassNotification.getKlassNotificationType() == Klass.KlassNotificationType.JOINED ? "has joined" : "become Leader of";
        String notification = String.format("I am %s. I know %s %s Class %d.", this.getName(), klassNotification.getStudent().getName(), notificationType, klassNotification.getKlass().getNumber());
        System.out.println(notification);
    }
}
