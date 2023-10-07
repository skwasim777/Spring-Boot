package com.crud.service;

import java.util.List;

import com.crud.Course.Course;



public interface CourseService {
	public String upsert(Course course);
	public Course getById(Long id);
	public List<Course> getAllCourses();
	public String deletById(Long id);
}
