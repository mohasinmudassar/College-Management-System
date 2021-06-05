import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
public class parent extends person {
    ArrayList<student> students;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    parent(){
        students = new ArrayList<student>();
        this.readStudentData();
    }
    student getStudent(){
        String name = JOptionPane.showInputDialog(null, "Enter name of your child: ");
        String rollNumber = JOptionPane.showInputDialog(null, "Enter roll number of your child: ");
        int c = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (name.equals(this.students.get(i).getName())) {
                c++;
                if (rollNumber.equals(String.valueOf(this.students.get(i).getRollNumber()))) {
                    return this.students.get(i);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Roll Number!");
                }

            }
        }
        return null;
    }
    void checkStudentData(){
        String name = JOptionPane.showInputDialog(null,"Enter name of your child: ");
        String rollNumber = JOptionPane.showInputDialog(null,"Enter roll number of your child: ");
        int c=0;
        for(int i=0;i<this.students.size();i++){
            if(name.equals(this.students.get(i).getName())){
                c++;
                if(rollNumber.equals(String.valueOf(this.students.get(i).getRollNumber()))){
                    JOptionPane.showMessageDialog(null,"Name: " + this.students.get(i).getName() + 
                            "\nRoll Number: " + this.students.get(i).getRollNumber()+ 
                            "\nAge: " + this.students.get(i).getAge() + "\n" + "Fee Status: " + 
                            this.students.get(i).isFeeStatus());
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Roll Number!");
                }
                
            }
        }
        if(c==0){
            JOptionPane.showMessageDialog(null,"Student not found in the record!");
        }
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
                  students.add(s);     
            }  
            sc.close();     
            }catch(IOException e){  
                e.printStackTrace();  
            }
    }
}
