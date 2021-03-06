/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;
import com.crs.flipkart.bean.SemesterRegistration;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.RegisteredCoursesDaoInterface;
import com.crs.flipkart.dao.RegisteredCoursesDaoOperation;
import com.crs.flipkart.exception.CourseNotFoundException;

/**
 * @author harsh
 *
 */
public class SemesterRegistrationService implements SemesterRegistrationServiceInterface{
    
	private static Logger logger = Logger.getLogger(SemesterRegistrationService.class);
	
	Scanner sc = new Scanner(System.in);
    RegisteredCoursesDaoInterface registeredCoursesDaoInterface = new RegisteredCoursesDaoOperation();
    
    public boolean addCourse(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Adding course");
        System.out.println("Enter the course ID");
        String courseId = sc.next();
        
        try {
        	registeredCoursesDaoInterface.isCourseAvailable(courseId);
        }
        catch(CourseNotFoundException ex) {
        	logger.error("Exception : "+ex.getMessage());
        	return false;
        }
        
        
        if(registeredCoursesDaoInterface.hasCourse(courseId,semesterRegistration.getStudentId())) {
        	System.out.println("You have this course added already!");
        	return false;
        } 
        
                
        System.out.println("Course with course id " + courseId + " added successfully!");
        System.out.println("-----------------------------------------------"); 
        System.out.println("-----------------------------------------------"); 
        
        return registeredCoursesDaoInterface.addCourse(courseId,semesterRegistration.getStudentId());
    }

    public void dropCourse(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Dropping Course");
        System.out.println("Enter the course ID that you want to delete");
        String courseId = sc.next();
        
        if(!registeredCoursesDaoInterface.hasCourse(courseId,semesterRegistration.getStudentId())) {
        	System.out.println("You do not have this course added!");
        	return;
        }
        

        registeredCoursesDaoInterface.dropCourse(courseId, semesterRegistration.getStudentId());
        
        System.out.println("Course with course id " + courseId + " deleted Successfully!");
        
        System.out.println("-----------------------------------------------"); 
        System.out.println("-----------------------------------------------"); 
        
    }

    public void showCourse() {
    	
    	logger.info("Showing Course");
    	System.out.println("Courses offered in this semester are: ");
    	// Fetch courses from course catalog
    	AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
    	
    	List<Course> availableCourses = adminDaoInterface.getAllCourse();
    	if(availableCourses.size()>0) {
    	availableCourses.forEach(course->{System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());});
//    	for(Course course: availableCourses) {
//    		System.out.println("Course ID: " + course.getCourseId() + " Course Name : " + course.getCourseName());
//    	}
    	} 
    	else 
    		logger.info("There are no courses available");
    	System.out.println("-----------------------------------------------");  
    	System.out.println("-----------------------------------------------"); 
    }
    
    public void showSelectedCourses(SemesterRegistration semesterRegistration) {
    	
    	logger.info("Showing selected courses");
    	System.out.println("You have selected the following courses!");
    	List<Course> selectedCourses = registeredCoursesDaoInterface.getSelectedCourses(semesterRegistration.getStudentId());
    	
    	if(selectedCourses.size()>0) {
    	selectedCourses.forEach(course->{System.out.println("Course ID: " + course.getCourseId());});
//    	for(Course course: selectedCourses) {
//    		System.out.println("Course ID: " + course.getCourseId() + " Course Name: " + course.getCourseName());
//    	}
    	} 
    	else
    		logger.info("No selected courses to display");
    	System.out.println("-----------------------------------------------");
    }
    
}
