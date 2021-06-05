
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
public class student extends person {
    ArrayList<Course> myCourses;
    ArrayList<Course> courses;
    Scanner input;
    int rollNumber;
    String password;
    boolean feeStatus;
    
    student(){
        myCourses = new ArrayList<Course>();
        courses = new ArrayList<Course>();
        input = new Scanner(System.in);
        this.readCourseData();
    }
    
    void readCourseData(){
        try  {  
            //the file to be opened for reading
            FileInputStream fis=new FileInputStream("courses.txt");       
            Scanner sc=new Scanner(fis);  
            while(sc.hasNextLine()){  
                  String data = sc.nextLine();
                  String[] courseTemp = data.split(",");
                  Course c = new Course();
                  c.setName(courseTemp[0]);
                  c.setCreditHours(Integer.parseInt(courseTemp[1]));
                  c.setId(Integer.parseInt(courseTemp[2]));
                  courses.add(c);     
            }  
            sc.close();     
            }catch(IOException e){  
                e.printStackTrace();  
            }
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    void payFee(){
        System.out.println();
        String ask = JOptionPane.showInputDialog(null,"Are you sure you want to pay the fee(y/n): ");
        if(ask.equals("y") || ask.equals("Y")){
            JOptionPane.showMessageDialog(null,"Student Fee Paid!");
            this.feeStatus = true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Fee not Paid!");
            this.feeStatus = false;
        }
    }
    ArrayList<Course> getAllCourses(){
        return this.courses;
    }

    public boolean isFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(boolean feeStatus) {
        this.feeStatus = feeStatus;
    }
    
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }
    void addCourse(){
        int c=0;
        String name = JOptionPane.showInputDialog(null,"Enter Course Name: ");
        for(int i=0;i<this.courses.size();i++){
            if(name.equalsIgnoreCase(this.courses.get(i).getName())){
                this.myCourses.add(this.courses.get(i));
                c++;
                JOptionPane.showMessageDialog(null,name + " Added in registered Courses!");
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Course Not Found!");
        }
    }  
    void displayAllCourses(){
       //read the course file
    }
    void submitAssignment(){
        this.displayRegisteredCourses();
        System.out.println();
        String name = JOptionPane.showInputDialog(null,"Enter name of course you want to submit assignment of: ");
        int c=0;
        for(int i=0;i<this.myCourses.size();i++){
            if(name.equalsIgnoreCase(this.myCourses.get(i).getName())){
                c++;
                JOptionPane.showMessageDialog(null,"Assignment Submitted of course: " + this.myCourses.get(i).getName());
                Random rand = new Random();
                int score = rand.nextInt(11);
                if(score>7){
                    JOptionPane.showMessageDialog(null,"Congratulations! You scored " + score + " marks out of 10!");
                }
                else if(score <=7 && score >=4){
                    JOptionPane.showMessageDialog(null,"You Scored " + score + " marks out of 10!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Test Failed! You scored only " + score + " marks out of 10."
                            + " Better luck next time");
                }
                this.myCourses.get(i).setStudentScore(score);
                c++;
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Error! Course not found!!");
        }
    }
    void displayRegisteredCourses(){
        System.out.println("Available Courses: ");
        for(int i=0;i<this.myCourses.size();i++){
            System.out.println(this.myCourses.get(i).getName());
        }
    }
    ArrayList<Course> getRegisteredCourses(){
        return this.myCourses;
    }
    void takeQuiz(){
        this.displayRegisteredCourses();
        System.out.println();
        String name = JOptionPane.showInputDialog(null,"Enter name of subject you want to take quiz of: ");
        int c=0;
        for(int i=0;i<this.myCourses.size();i++){
            if(name.equalsIgnoreCase(this.myCourses.get(i).getName())){
                JOptionPane.showMessageDialog(null,"Taking quiz of "+ name);
                Random rand = new Random();
                int score = rand.nextInt(11);
                if(score>7){
                    JOptionPane.showMessageDialog(null,"Congratulations! You scored " + score + " marks out of 10!");
                }
                else if(score <=7 && score >=4){
                    JOptionPane.showMessageDialog(null,"You Scored " + score + " marks out of 10!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Test Failed! You scored only " + score + " marks out of 10."
                            + " Better luck next time");
                }
                this.myCourses.get(i).setStudentScore(score);
                c++;
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Error! Course not found!!");
        }
    }
}
