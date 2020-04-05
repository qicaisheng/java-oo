package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members = new ArrayList<>();
    private List<Teacher> observers = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + getNumber();
    }

    public void assignLeader(Student student) {
        if (!members.contains(student)) {
            System.out.println("It is not one of us.");
            return;
        }
        leader = student;
        KlassNotification klassNotification = new KlassNotification(student, this, KlassNotificationType.BECAME_LEADER);
        this.observers.forEach(observer -> observer.sendNotification(klassNotification));
    }

    public Student getLeader() {
        return leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number &&
                Objects.equals(leader, klass.leader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, leader);
    }

    public void appendMember(Student student) {
        members.add(student);
        KlassNotification klassNotification = new KlassNotification(student, this, KlassNotificationType.JOINED);
        this.observers.forEach(observer -> observer.sendNotification(klassNotification));
    }

    public void addObserver(Teacher teacher) {
        this.observers.add(teacher);
    }

    public class KlassNotification {
        private final Student student;
        private Klass klass;
        private final KlassNotificationType klassNotificationType;

        public KlassNotification(Student student, Klass klass, KlassNotificationType klassNotificationType) {
            this.student = student;
            this.klass = klass;
            this.klassNotificationType = klassNotificationType;
        }

        public Student getStudent() {
            return student;
        }

        public KlassNotificationType getKlassNotificationType() {
            return klassNotificationType;
        }

        public Klass getKlass() {
            return klass;
        }
    }

    public enum  KlassNotificationType {
        JOINED, BECAME_LEADER 
    }
}
