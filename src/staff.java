
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class staff extends person {
    ArrayList <Course> courses;
    Scanner input;
    String password;
    staff(){
        courses = new ArrayList<Course>();
        input = new Scanner(System.in);
        //read course file
        this.readCourseData();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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
    void writeCourseData(){
        try{
            FileWriter myWriter = new FileWriter("courses.txt");
            for(int i=0;i<courses.size();i++){
                myWriter.write(courses.get(i).getName()+"," + courses.get(i).getCreditHours() + "," + 
                        courses.get(i).getId()  + "\n");
            }
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void displayAllCourses(){
        for(int i=0;i<this.courses.size();i++){
            System.out.println("Course Name: " + this.courses.get(i).getName() + "Course Credit Hours: " + 
                    this.courses.get(i).getCreditHours() + "Course ID: " + this.courses.get(i).getId());
        }
    }
    ArrayList<Course> getCourses(){
        return this.courses;
    }
    void addNewCourse(){
        int c=0;
        String name = JOptionPane.showInputDialog(null,"Enter Course Name: ");
        int creditHours=0,id=0;
        try{
            creditHours = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Course Credit Hours: "));
            id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Course ID: "));
        }catch(Exception e){
            c++;
        }
        if(name.equals(" ")){
            c++;
        }
        if(c==0){
            Course newCourse = new Course();
            newCourse.setName(name);
            newCourse.setCreditHours(creditHours);
            newCourse.setId(id);
            this.courses.add(newCourse);
            this.writeCourseData();
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Please enter valid values!");
        }
        
    }
    void searchCourse(){
        System.out.println("Enter Name of course you want to search: ");
        String name = input.nextLine();
        int c=0;
        for(int i=0;i<this.courses.size();i++){
            if(name.equals(this.courses.get(i))){
                System.out.println("Course Name: " + this.courses.get(i).getName() + "Course Credit Hours: " + 
                    this.courses.get(i).getCreditHours() + "Course ID: " + this.courses.get(i).getId());
                c++;
            }
        }
        if(c==0){
            System.out.println("Course Not Found!");
        }
    }
    void deleteCourse(){
        String name = JOptionPane.showInputDialog(null,"Enter name of course you want to delete: ");
        int c=0;
        for(int i=0;i<this.courses.size();i++){
            if(name.equals(this.courses.get(i).getName())){
                this.courses.remove(i);
                this.writeCourseData();
                c++;
                JOptionPane.showMessageDialog(null,name + " Deleted!");
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Course Not Found!");
        }
    }
}
