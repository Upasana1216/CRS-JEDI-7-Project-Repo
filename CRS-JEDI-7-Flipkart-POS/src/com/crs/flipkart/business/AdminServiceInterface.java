/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Set;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author Abhinav
 *
 */
public interface AdminServiceInterface {
	public boolean addCourse(Course course);
	public boolean deleteCourse(String id);
	public boolean addProfessor(Professor professor);
	public boolean approveStudent(String studentUserId);
	public List<Student> viewPendingApproval();
	public List<Course> viewCourse();
	public Set<String> viewSelectedCourse(String studentId);
	public int getCouseList(String c);
	public boolean updateRegistered(String studentId);
}