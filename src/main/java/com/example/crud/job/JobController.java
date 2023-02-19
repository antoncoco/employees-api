package com.example.crud.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getJobs() {
        return this.jobService.getJobs();
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return this.jobService.addJob(job);
    }
}
