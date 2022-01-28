package com.crs.flipkart.business;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseCatalog;

public class CourseCatalogService implements CourseCatalogServiceInterface{

	 private static Logger logger = Logger.getLogger(CourseCatalogService.class);

    public void addCourse(CourseCatalog courseCatalog, Course course) {
        courseCatalog.getCourses().add(course);
    }

    public void dropCourse(CourseCatalog courseCatalog, Course course) {
        int index = 0;
        for (Course c : courseCatalog.getCourses()) {
            if (c.getCourseId() == course.getCourseId())
                courseCatalog.getCourses().remove(index);
            index++;
        }
    }
}
