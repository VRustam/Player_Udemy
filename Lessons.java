package Course;

public class Lessons {
    private int lessonNo;
    private String lesson_Header;
    private double minute;

    public Lessons(int lessonNo, String lessonHeader, double minute) {
        this.lessonNo = lessonNo;
        this.lesson_Header = lessonHeader;
        this.minute = minute;
    }



    public int getLessonNo() {
        return lessonNo;
    }

    public void setLesson_Header(String lesson_Header) {
        this.lesson_Header = lesson_Header;
    }

    public String getLesson_Header() {
        return lesson_Header;
    }

    public double getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "lessonNo=" + lessonNo +
                ", lessonHeader='" + lesson_Header + '\'' +
                ", minute=" + minute +
                '}';
    }
}
