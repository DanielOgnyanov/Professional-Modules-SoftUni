package entities.universitySystem;


import entities.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int credits;

    private Teacher teacher;
    private Set<Student> students;

    public Course() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "credits")
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToMany(targetEntity = Student.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
