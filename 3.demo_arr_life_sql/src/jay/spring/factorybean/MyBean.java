package jay.spring.factorybean;

import jay.spring.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() {
        Course course = new Course();
        course.setCname("Spring框架");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
