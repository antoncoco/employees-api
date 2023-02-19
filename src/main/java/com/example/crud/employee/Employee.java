package com.example.crud.employee;

import com.example.crud.job.Job;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "emp_rfc")
    private String rfc;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_lastname")
    private String lastname;
    @Column(name = "emp_email")
    private String email;
    @Column(name = "emp_birthday")
    private LocalDate birthday;
    @Transient
    @Setter(AccessLevel.NONE)
    private int age;
    @ManyToOne
    @JoinColumn(name = "emp_job")
    private Job job;

    public Employee(String rfc, String name, String lastname, String email, LocalDate birthday, Job job) {
        this.rfc = rfc;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
        this.job = job;
        this.setAge();
    }

    private void setAge() {
        this.age = Period.between(this.birthday, LocalDate.now()).getYears();
    }

}
