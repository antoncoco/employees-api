package com.example.crud.job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer id;
    @Column(name = "job_name")
    private String name;
    @Column(name = "job_salary")
    private String salary;

    public Job(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }
}
