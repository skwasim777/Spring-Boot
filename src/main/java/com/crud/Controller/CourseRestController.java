package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Course.Course;
import com.crud.service.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseRestController {
	@Autowired
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Course> getCourse(Long id) {
		Course course = courseService.getById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> allcourses = courseService.getAllCourses();
		return new ResponseEntity<>(allcourses, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
		String status = courseService.deletById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
