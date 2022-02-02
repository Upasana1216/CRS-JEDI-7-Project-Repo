/**
 * 
 */
package com.crs.flipkart.validator;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.exception.CourseNotFoundException;

/**
 * @author nandini mehta
 *
 */
public class StudentValidator {

	/**
	 * Method to validate if student is already registered for this particular
	 * course (courseCode) or not
	 * 
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList
	 * @return
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(String courseCode, String studentId, List<Course> registeredCourseList)
			throws CourseNotFoundException {
		for (Course course : registeredCourseList) {
			if (courseCode.equalsIgnoreCase(course.getCourseId()))
				return true;
		}

		return false;
	}

	/**
	 * Method to validate if couseCode is valid or not
	 * 
	 * @param courseCode
	 * @param availableCourseList
	 * @return
	 */
	public static boolean isValidCourseCode(String courseCode, List<Course> availableCourseList) {
		for (Course course : availableCourseList) {
			if (courseCode.equalsIgnoreCase(course.getCourseId()))
				return true;
		}

		return false;

	}

}
