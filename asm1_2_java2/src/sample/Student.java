package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static sample.Main.*;

public class Student {
    public TextField txtname;
    public TextField txtage;
    public TextField txtmark;
    public TextArea KQ;

    public String name;
    public int age;
    public float mark;
    public boolean xacdinh;
    public Student(){

    }
    public Student(String name, int age, float mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMark() {
        return mark;
    }

public void setMark(float mark) {
        this.mark = mark;
    }

    public void themSV(){
            String name = txtname.getText();
            int age = Integer.parseInt(txtage.getText());
            float mark = Integer.parseInt(txtmark.getText());


            Student STD = new Student();
            STD.setName(name);
            STD.setAge(age);
            STD.setMark(mark);
//            arl.add(STD);

            Main.arl.add(STD);
            String str = "";
            for (Student s : arl) {
                String S = "Name: " + s.name + " - Age: " + s.age + " - Mark: " + s.mark;
                str += (S + "\n");
        }
        KQ.setText(str);
    }

    class AgeComparator1 implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if (s1.mark == s2.mark)
                return 0;
            else if (s1.mark > s2.mark)
                return 1;
            else
                return -1;
        }

    }

    class AgeComparator2 implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if (s1.mark == s2.mark)
                return 0;
            else if (s1.mark < s2.mark)
                return 1;
            else
                return -1;
        }

    }



    public void sxsv(){
        String str2 ="";
        boolean flag = true;
        if(flag){
            Collections.sort(Main.arl, new AgeComparator1());
            for (Student s : Main.arl) {
                String st = "Name: "+s.name + " - Age: " +s.age+ " - Mark: " + s.mark;
                str2 += (st+ "\n");

//                flag = !flag;
            }

        }else if(!flag){
            Collections.sort(Main.arl, new AgeComparator2());
            for (Student s : Main.arl) {
                String st = "Name: "+s.name + " - Age: " +s.age+ " - Mark: " + s.mark;
                str2 += (st+ "\n");
//                flag = !flag;
            }
//            flag = !flag;
        }
        KQ.setText(str2);
        flag = !flag;

    }
}
