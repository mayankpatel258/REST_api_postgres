package com.example.demo.services;

import com.example.demo.dao.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();
    public Optional<Course> getCourses(long id);
   public Course  addCourses(Course course);
   public void deleteCourse(long id);



    ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course);
}
