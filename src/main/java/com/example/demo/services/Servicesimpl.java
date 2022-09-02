package com.example.demo.services;

import com.example.demo.dao.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class Servicesimpl implements CourseService{
    //List<Course> list;
    @Autowired
   private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
       // return list;
    }

    @Override
    public Optional<Course> getCourses(long id) {
        return courseRepository.findById(id);
//        Course course=null;
//        for(Course c:list){
//            if(c.getId()==id){
//                course=c;
//                break;
//            }
//        }
//        return course;
    }

    @Override
    public Course addCourses(Course course) {
//         list.add(course);
        courseRepository.save(course);
         return course;
    }

    @Override
    public void deleteCourse(long id) {

        courseRepository.deleteById(id);
//        list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    }



    @Override
   public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course){
//        list.forEach(e->{
//            if(e.getId()==course.getId()){
//                e.setName(course.getName());
//                e.setDescription(course.getDescription());
//            }
//        });
        Optional<Course> courseData = courseRepository.findById(id);
        if (courseData.isPresent()) {
            Course _tutorial = courseData.get();
            _tutorial.setName(course.getName());
            _tutorial.setDescription(course.getDescription());

            return new ResponseEntity<>(courseRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

   }

}
