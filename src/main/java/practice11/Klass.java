package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass implements KlassSubject {
    private int number;
    private Student leader;
    private List<Student> members = new ArrayList<>();
    private List<KlassListener> listeners = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + getNumber();
    }
    
    @Override
    public List<KlassListener> getListeners() {
        return this.listeners;
    }
    
    public void assignLeader(Student student) {
        if (!members.contains(student)) {
            System.out.println("It is not one of us.");
            return;
        }
        leader = student;
        update(new KlassNotification(student, this, KlassNotificationType.BECAME_LEADER));
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
        update(new KlassNotification(student, this, KlassNotificationType.JOINED));
    }

    private void update(KlassNotification klassNotification) {
        getListeners().forEach(listener -> listener.listen(klassNotification));
    }

    @Override
    public void register(KlassListener klassListener) {
        getListeners().add(klassListener);
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
