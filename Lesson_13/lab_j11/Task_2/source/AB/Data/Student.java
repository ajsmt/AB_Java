package AB.Data;

public class Student {
    private int id;
    private String name;
    private String course;
    private int mark;

    public Student(int id, String name, String course, int mark) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    static public Student studentPars(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0].trim());
        String name = data[1].trim();
        String course = data[2].trim();
        int mark = Integer.parseInt(data[3].trim());
        return new Student(id, name, course, mark);
    }

    @Override
    public String toString(){
        return id + ", " + name + ", " + course + ", " + mark;
    }
}
