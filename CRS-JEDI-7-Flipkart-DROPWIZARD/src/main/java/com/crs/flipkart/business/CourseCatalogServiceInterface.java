/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;

/**
 * @author hardik.kothari
 *
 */

/*
 *Interface containing methods for adding and droping course
 */
public interface CourseCatalogServiceInterface {
	
	public void addCourse(CourseCatalog courseCatalog, Course course);
	
	public void dropCourse(CourseCatalog courseCatalog, Course course);
	

}
