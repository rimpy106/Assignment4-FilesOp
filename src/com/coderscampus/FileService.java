package com.coderscampus;

import java.io.*;


public class FileService {
    private static final String fileHeader = "Student ID,Student Name, Course,Grade \n";

    public Student[] readFromCSV(String file) {
        Student[] students = new Student[101];
        String line;
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] fileData = line.split(",");
                students[i] = new Student(fileData[0], fileData[1], fileData[2], fileData[3]);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found exception");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return students;
    }

    public void readFromStudArray(Student[] students) {
        System.out.println("-------------------------------------");
        for (int j = 0; j < students.length; j++) {
            System.out.println(students[j].getStudentId() + "-" + students[j].getStudentName() + "-" + students[j].getCourse() + "-" + students[j].getGrade());
        }
    }

    public void writeToFile(Student[] stud, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(fileHeader);
        try {
            for (int j = 0; j < stud.length; j++) {
                if (stud[j] != null) {
                    bw.write(stud[j].getStudentId() + "," + stud[j].getStudentName() + "," + stud[j].getCourse() + "," + stud[j].getGrade() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            bw.close();
        }
    }

}
