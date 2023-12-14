package com.coderscampus;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileApplication {
    public static void main(String[] args) throws IOException {
        FileService fs = new FileService();
        Student[] students=fs.readFromCSV("student-master-list.csv");
      //  fs.readFromStudArray(students);
        //Sorting an array in descending order
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student2.getGrade().compareTo(student1.getGrade());
            }
        });

        //fs.readFromStudArray(copyStudents);
        Student[] compSci=new Student[100];
        Student[] stat=new Student[100];
        Student[] apMath=new Student[100];
        int csCtr=0, statCtr=0, mathCtr=0;
        for (int j = 1; j < students.length; j++) {
            if (students[j].getCourse().contains("COMPSCI")) {
                compSci[csCtr]=students[j];
                csCtr++;
            } else if (students[j].getCourse().contains("STAT")) {
               stat[statCtr]=students[j];
               statCtr++;
            } else if(students[j].getCourse().contains("APMTH")){
                apMath[mathCtr]=students[j];
                mathCtr++;
            }
        }

        //write to csv files
        fs.writeToFile(compSci,"compsci.csv");
        fs.writeToFile(stat,"stat.csv");
        fs.writeToFile(apMath,"apMath.csv");



    }
}
