package Course;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends Man {
    private ArrayList<Course> coursesAttended;
    private LinkedList<Lessons> watchLessonsList;

    public LinkedList<Lessons> getWatchLessonsList() {
        return watchLessonsList;
    }

    public Student(String name, String promotion, String login) {
        super(name, promotion, login);
        coursesAttended = new ArrayList<>();
        watchLessonsList = new LinkedList<>();
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "coursesAttended=" + coursesAttended +
                '}';
    }

    public void takeTheCourse(Course javaCourse) {
        if(javaCourse.courseWatchCheck()){
            javaCourse.getCourseStudents().add(this);
            coursesAttended.add(javaCourse);
            System.out.println(this.getName() + " Istifadeci " + javaCourse.getCourseName() + "Kursa daxil oldu.");
        }else {
            System.out.println(javaCourse.getCourseName() + " adli kurs activ deyil daxil ola bilmezsiz");
        }
    }

    public void addWatchLessons(Lessons watchLesson){
        boolean derstapildi=false;

        if(coursesAttended.size() > 0){
            for(Course mueyyen :coursesAttended ){
               if(mueyyen.getLessonsInCourse().contains(watchLesson)){
                   System.out.println("Baxilacaq dersler " + watchLesson.getLessonNo() + mueyyen.getCourseName() + "aursunda olan" + mueyyen.getLesson_Header() + " dersi elave edildi");
                   watchLessonsList.add(watchLesson);
                   derstapildi = true;
                   break;
               }
            }
            if (!derstapildi){
                System.out.println("Girilen ders kurslarda tapilmadi.");
            }
        }
    }
}
