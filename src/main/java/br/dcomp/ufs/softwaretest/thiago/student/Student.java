package br.dcomp.ufs.softwaretest.thiago.student;

import br.dcomp.ufs.softwaretest.thiago.student.Exception.GradeNotInformedYetException;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public Student(String name, double frenquency) {
        this.name = name;
        this.frenquency = frenquency;
    }

    private String name;

    private List<Double> grades = new ArrayList<>();

    private double frenquency;

    private final double MIN_FREQUENCY = 75;
    private final double MIN_AVERAGE = 5;

    public double average() {
        if (grades.isEmpty())
            throw new GradeNotInformedYetException();
        Double gradesum = grades.stream().reduce(((grade1, grade2) -> grade1 += grade2)).get();
        return gradesum / grades.size();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public boolean isApproved() {
        return frenquency >= MIN_FREQUENCY && average() >= MIN_AVERAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFrenquency() {
        return frenquency;
    }

    public void setFrenquency(double frenquency) {
        this.frenquency = frenquency;
    }
}
