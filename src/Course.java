
public class Course {
    String name;
    int creditHours,id,studentScore=0;

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore += studentScore;
    }
    
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getId() {
        return id;
    }
    
}
