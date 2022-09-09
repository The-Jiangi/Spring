package jay.spring.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    // 数组类型属性
    private String[] courses;
    // 集合类型属性
    private List<String> list;
    // map类型属性
    private Map<String,String> maps;
    // set类型属性
    private Set<String> sets;
    // 学生所学的多门课程
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test() {
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courseList.toString());
    }
}
