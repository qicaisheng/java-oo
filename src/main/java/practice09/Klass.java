package practice09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members = new ArrayList<>();

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
    }
}
