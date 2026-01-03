package com.abw.factory;

import com.abw.service.CoursesService;
import com.abw.service.CoursesServiceImpl;


public class CoursesServiceFactory {

    private static CoursesService coursesService;

    private CoursesServiceFactory() {}

    public static CoursesService getCoursesServiceInstance() 
    {
        if(coursesService == null) {
            coursesService = new CoursesServiceImpl();
        }
        return coursesService;
    }
}
