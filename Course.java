package Course;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Lessons> lessonsInCourse;
    private ArrayList<Instructor> instructorsCourse;
    private ArrayList<Student> courseStudents;
    // Ders sayi en azi 5 ve en az 60 deqiqe olmalidir
    private boolean watch;


    public Course(String courseName, Instructor chiefInstructor) {
        this.courseName = courseName;
        this.lessonsInCourse = new ArrayList<>();
        this.instructorsCourse = new ArrayList<>();
        this.courseStudents =  new ArrayList<>();
        instructorsCourse.add(0,chiefInstructor);
        this.watch = false;
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addInstructorForCourse(Instructor newInstructor){

        if(!instructorsCourse.contains(newInstructor)){
            instructorsCourse.add(newInstructor);
            System.out.println(newInstructor.getName() + " kursa muellim olaraq alindi. ");
        }else {
            System.out.println(newInstructor.getName() + "Bele bir muellim artiq bazada movcuddur");
        }

    }
    public void removeInstructorForCourse(Instructor deleteInstructor){
        if(deleteInstructor.getName().equals(instructorsCourse.get(0).getName())){
            System.out.println(deleteInstructor.getName() + " kursun esas muellimi olduqundan siline bilmez. ");

        }else {
            instructorsCourse.remove(deleteInstructor);
            System.out.println(deleteInstructor.getName() +  " kurs muellimliyinden cixarildi . ");
        }

    }
    public void addLessonsForCourse(Lessons addLesson){
        lessonsInCourse.add(addLesson);
    }
    public int lessonsTimeInCourse(){
       return lessonsInCourse.size();
    }

    private int allLessonsMinuteInCourse(){
        double allTime = 0;
        for (Lessons lessons : lessonsInCourse){
            allTime = allTime + lessons.getMinute();
        }
        return (int)allTime;
    }

    public boolean courseWatchCheck(){
        if(lessonsInCourse.size() >= 5 && allLessonsMinuteInCourse() > 60){
            watch = true;
            return true;
        }else return false;
    }

    public ArrayList<Lessons> getLessonsInCourse() {
        return lessonsInCourse;
    }


    
}
