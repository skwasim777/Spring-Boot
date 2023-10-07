package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.crud.Course.Course;
import com.crud.repository.CourseRepository;

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String upsert(Course course) {
		// upsert (insert and update based on PK)
		courseRepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Long id) {
		Optional<Course> findbyid = courseRepo.findById(id);
		if (findbyid.isPresent()) {
			return findbyid.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {

		return courseRepo.findAll();
	}

	@Override
	public String deletById(Long id) {
		if (courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return "Deleted Success";
		} else {
			return "No Record Founds";
		}
	}


}
