/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.RegisteredCourses;

/**
 * @author harsh
 *
 */
public interface RegisteredCoursesDaoInterface {
	
	public List<Course> getRegisteredCoursesById(String id);
	public boolean addCourse(String courseId,String SId);
	public void dropCourse(String courseId,String SId);
	public boolean hasCourse(String courseId,String Sid);
	public List<Course> getSelectedCourses(String id);
	
}