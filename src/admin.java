import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
public class admin extends person {
    ArrayList<student> students;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    admin(){
        students = new ArrayList<student>();
        //read student file here
        this.readStudentData();
    }
    
    void readStudentData(){
        try  {  
            //the file to be opened for reading
            FileInputStream fis=new FileInputStream("students.txt");       
            Scanner sc=new Scanner(fis);  
            while(sc.hasNextLine()){  
                  String data = sc.nextLine();
                  String[] studentTemp = data.split(",");
                  student s = new student();
                  s.setName(studentTemp[0]);
                  s.setAge(Integer.parseInt(studentTemp[1]));
                  s.setRollNumber(Integer.parseInt(studentTemp[2]));
                  s.setFeeStatus(Boolean.parseBoolean(studentTemp[3]));
                  s.setPassword(studentTemp[4]);
                  students.add(s);     
            }  
            sc.close();     
            }catch(IOException e){  
                e.printStackTrace();  
            }
    }
    void writeStudentData(){
        try{
            FileWriter myWriter = new FileWriter("students.txt");
//            Writing all the data inside the students Arryalist to the file line by line
            for(int i=0;i<students.size();i++){
                myWriter.write(students.get(i).getName()+"," + students.get(i).getAge() + "," + 
                        students.get(i).getRollNumber() + "," + students.get(i).isFeeStatus() + "," + 
                        students.get(i).getPassword()  + "\n");
            }
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    ArrayList<student> displayAllStudents(){
//        for(int i=0;i<this.students.size();i++){
//            System.out.println("Name: " + this.students.get(i).getName() + "Roll Number: " +
//                    this.students.get(i).getRollNumber() + "Fee Status: " + this.students.get(i).isFeeStatus());
//        }
        return this.students;
    }
    void enrollStudent(){
        int exceptionCheck=0;
        String name = JOptionPane.showInputDialog(null,"Enter name of student: ");
        if(name.equals("")|| name.equals(" ")){
            exceptionCheck++;
        }
        String a = JOptionPane.showInputDialog(null,"Enter age of the student: ");
        String pass = JOptionPane.showInputDialog(null,"Enter Student Password: ");
        int age=0;
        try{
            age = Integer.parseInt(a);
        }catch(Exception e){
            exceptionCheck++;
        }
        String r = JOptionPane.showInputDialog(null,"Enter roll number of the student: ");
        int rollNumber=0;
        try{
         rollNumber = Integer.parseInt(r);   
        }catch(Exception e){
            exceptionCheck++;
        }
        if(exceptionCheck==0){
            student s = new student();
            s.setName(name);
            s.setAge(age);
            s.setRollNumber(rollNumber);
            s.setPassword(pass);
            students.add(s);
            this.writeStudentData();
            //this.readStudentData();
            for(int i=0;i<students.size();i++){
                System.out.println(students.get(i).getName());
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please enter correct Information!");
        }
    }
    void deleteStudent(){
        String name = JOptionPane.showInputDialog(null,"Enter name of student you want to delete: ");
        System.out.println(name);
        int c=0;
        for(int i=0;i<this.students.size();i++){
            if(name.equals(this.students.get(i).getName())){
                this.students.remove(i);
                this.writeStudentData();
//                this.readStudentData();
                JOptionPane.showMessageDialog(null,name + " Religated from the Durham School!");
                c++;
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Student not found!");
        }
    }
    
}
