package br.dcomp.ufs.softwaretest.thiago.student;

import br.dcomp.ufs.softwaretest.thiago.student.Exception.GradeNotInformedYetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class StudentTest {

    private static Double[] approvedGrade;

    private static Double averageApprovedGrade;

    private static Double[] reprovedGrade;

    private static Double averageReprovedGrade;

    private final static int MIN_FREQUENCY = 75;

    private static int approvedFrequency;

    private static int reprovedFrequency;

    private static String approvedName;

    private static String reprovedName;

    @BeforeAll
    static void beforeAll() {
        approvedGrade = new Double[]{10d, 10d, 10d};
        averageApprovedGrade = 10d;
        reprovedGrade = new Double[]{1d, 1d, 1d};
        averageReprovedGrade = 1d;
        Random randomGenerator = new Random();
        approvedFrequency = randomGenerator.nextInt(25) + MIN_FREQUENCY;
        reprovedFrequency = (MIN_FREQUENCY - 1) - randomGenerator.nextInt(74);
        approvedName = "Thiago Joaquim";
        reprovedName = "Flavio Rodolfo";
    }

    private Student createStudent(int frequency, String name, Double... grades) {
        Student student = new Student(name,  frequency);
        if (Objects.nonNull(grades))
            Arrays.stream(grades).forEach(t -> student.addGrade(t));
        return student;
    }

    @Test
    void testApprovedStudent() {
        Student studentApproved = createStudent(approvedFrequency, approvedName, approvedGrade);
        Assertions.assertEquals(approvedFrequency, studentApproved.getFrenquency());
        Assertions.assertEquals(approvedName, studentApproved.getName());
        Assertions.assertTrue(studentApproved.isApproved());
        Assertions.assertEquals(averageApprovedGrade.doubleValue(), studentApproved.average());
    }


    @Test
    void testReprovedStudentByFrequency() {

        Student studentReproved = createStudent(reprovedFrequency, reprovedName, approvedGrade);
        Assertions.assertEquals(reprovedFrequency, studentReproved.getFrenquency());
        Assertions.assertEquals(reprovedName, studentReproved.getName());
        Assertions.assertFalse(studentReproved.isApproved());
        Assertions.assertEquals(averageApprovedGrade.doubleValue(), studentReproved.average());
    }

    @Test
    void testReprovedStudentByGrade() {

        Student studentReproved = createStudent(approvedFrequency, reprovedName, reprovedGrade);
        Assertions.assertEquals(approvedFrequency, studentReproved.getFrenquency());
        Assertions.assertEquals(reprovedName, studentReproved.getName());
        Assertions.assertFalse(studentReproved.isApproved());
        Assertions.assertEquals(averageReprovedGrade.doubleValue(), studentReproved.average());
    }

    @Test
    void testReprovedStudentByGradeAndFrequency() {

        Student studentReproved = createStudent(reprovedFrequency, reprovedName, reprovedGrade);
        Assertions.assertEquals(reprovedFrequency, studentReproved.getFrenquency());
        Assertions.assertEquals(reprovedName, studentReproved.getName());
        Assertions.assertFalse(studentReproved.isApproved());
        Assertions.assertEquals(averageReprovedGrade.doubleValue(), studentReproved.average());
    }


    @Test
    void testStudentWithoutGrade() {
        GradeNotInformedYetException exception = Assertions.assertThrows(GradeNotInformedYetException.class,
                () -> createStudent(approvedFrequency, approvedName, null).isApproved());
    }


}
