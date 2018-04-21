package com.kiran.springbootstarter.course;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	private static final String template = " Course %s";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/course")
	public Course getCourses(@RequestParam(value="name", defaultValue="Java") String name){
		return new Course(counter.incrementAndGet(),
						  String.format(template, name));
	}

}
