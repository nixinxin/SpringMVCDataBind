package com.imooc.dao;

import com.imooc.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseDAO {

    private Map<Integer, Course> courseMap = new HashMap<Integer, Course>();


    public void add(Course course) {
        courseMap.put(course.getId(), course);
    }

    public Collection<Course> getAll() {
        return courseMap.values();
    }

}
