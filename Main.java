import Course.Course;
import Course.Instructor;
import Course.Lessons;
import Course.Student;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Emil","Emilinin ilkin melumatlar", "Emil_udemy");
        Instructor rustam = new Instructor("Rustam","Rustamin dersleri", "Rustam_udemy_teacher");
        Instructor test = new Instructor("test ad", "test dersleri", "test_login");
        System.out.println(st1);
        System.out.println(rustam);

        Lessons lessons1=new Lessons(1,"Giris ders",4.5);
        Lessons lessons2=new Lessons(2,"Java nedir",8.4);
        Lessons lessons3=new Lessons(3,"OOP derslikler",25.2);
        Lessons lessons4=new Lessons(4,"Arrays",15.2);
        Lessons lessons5=new Lessons(5,"Method",15.5);

        Lessons lessons6=new Lessons(6,"Treemap",20.5);
        Lessons lessons7=new Lessons(7,"map",26.5);
        Lessons lessons8=new Lessons(8,"Tree",22.5);
        Lessons lessons9=new Lessons(9,"Hashcode",21.5);
        Lessons lessons10=new Lessons(10,"Blac red tree",24.5);

        Course javaCourse = new Course("Ireli seviiye Java kursu",rustam);
        javaCourse.addLessonsForCourse(lessons1);
        javaCourse.addLessonsForCourse(lessons2);
        javaCourse.addLessonsForCourse(lessons3);
        javaCourse.addLessonsForCourse(lessons4);
        javaCourse.addLessonsForCourse(lessons5);


        javaCourse.addInstructorForCourse(test);
        javaCourse.removeInstructorForCourse(rustam);
        javaCourse.removeInstructorForCourse(test);

        Course androidCourse =new Course("Android kursu", rustam);
        androidCourse.addLessonsForCourse(lessons6);
        androidCourse.addLessonsForCourse(lessons7);
        androidCourse.addLessonsForCourse(lessons8);
        androidCourse.addLessonsForCourse(lessons9);
        androidCourse.addLessonsForCourse(lessons10);

        st1.takeTheCourse(javaCourse);
        st1.takeTheCourse(androidCourse);
        st1.addWatchLessons(lessons1);
        st1.addWatchLessons(lessons2);
        st1.addWatchLessons(lessons6);
        st1.addWatchLessons(lessons10);

        playList(st1.getWatchLessonsList());

    }

    public static void playList(LinkedList<Lessons> watchLessons){

        Scanner axtar = new Scanner(System.in);
        boolean exit = false;
        boolean ireliHereket = true;

        ListIterator<Lessons> iterator = watchLessons.listIterator();
        if (watchLessons.size() == 0){
            System.out.println("Hele ders elave olunmayib");
        }else{
            Lessons ilkDers = iterator.next();
            System.out.println(" indi baxilan ders" + ilkDers.getLesson_Header() + " vaxti" + ilkDers.getMinute());
        }
        menuGoster();
        while(!exit){
            System.out.println("Seciminiz : " );
            int istifadeciSecimi = axtar.nextInt();
            switch (istifadeciSecimi){
                case 0 :
                    System.out.println("proqramdan cixilir. ");
                    exit=true;
                    break;


                case 1:
                    if(!ireliHereket){
                        ireliHereket = true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }

                    if(iterator.hasNext()){
                        Lessons ilkDers = iterator.next();
                        System.out.println("================================================================================================================");
                        System.out.println(" indi baxilan : Ders No: " + ilkDers.getLessonNo() + " : basliq" + ilkDers.getLesson_Header() + " vaxti" + ilkDers.getMinute());
                        System.out.println("================================================================================================================");
                    }else {
                        System.out.println("Listin sonuna geldiniz");
                    }
                    break;

                case 2:
                    if(ireliHereket){

                        ireliHereket = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if(iterator.hasPrevious()){
                        Lessons ilkDers = iterator.previous();
                        System.out.println("================================================================================================================");
                        System.out.println(" indi baxilan : Ders No: " + ilkDers.getLessonNo() + " : basliq" + ilkDers.getLesson_Header() + " vaxti" + ilkDers.getMinute());
                        System.out.println("================================================================================================================");
                    }else{
                        System.out.println("Listin evveline geldiniz");
                    }
                    break;

                case 3 :
                    baxilacaqDerslerinListi(watchLessons);
                    break;


                case 9:
                    menuGoster();
                    break;
            }
        }

    }

    private static void baxilacaqDerslerinListi(LinkedList<Lessons> watchLessons) {
        ListIterator<Lessons> iterator = watchLessons.listIterator();
        if (watchLessons.size() == 0){
            System.out.println("Hele ders elave olunmayib");
            return;
        }else{

            while (iterator.hasNext()){
                Lessons ilkDers = iterator.next();

                System.out.println("Ders No: " + ilkDers.getLessonNo() + " : basliq" + ilkDers.getLesson_Header() + " vaxti" + ilkDers.getMinute());

            }

        }

    }

    private static void menuGoster() {
        System.out.println("********************** MENU *******************");
        System.out.println("0 - Cixis");
        System.out.println("1 - evvelinci derse kec");
        System.out.println("2 - sonrakii derse kec");
        System.out.println("3 - butun listeni gor");
        System.out.println("9 - Menu");
    }
}
