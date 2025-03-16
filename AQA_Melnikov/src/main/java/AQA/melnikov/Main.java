package AQA.melnikov;

import AQA.melnikov.t1.Cources;
import AQA.melnikov.t1.Disciplines;
import AQA.melnikov.t1.Group;
import AQA.melnikov.t1.Student;
import AQA.melnikov.t2.PhoneDirectory;

import java.util.ArrayList;
import java.util.HashSet;

import static AQA.melnikov.t1.T1StaticMethods.*;
import static AQA.melnikov.t2.T2StaticMethods.*;

public class Main {
    public static void main(String[] args) {
        Group[] groupsArray = initializeGroupsArray();
        generateStudents(groupsArray);
        printStudentsInfo(groupsArray);
        closeStudyYear(groupsArray);
        printStudentsInfo(groupsArray);

//Напишите метод printStudents(Set<Student> students, int course), который
//получает список студентов и номер курса. Метод печатает на консоль
//имена тех студентов, которые обучаются на данном курсе.
        ArrayList<Student> generatedStudents =  generateStudents(new Group[]{
                new Group("a", Cources.FIRST, new Disciplines[]{}),
                new Group("b", Cources.SECOND, new Disciplines[]{})
        });
        printStudentsInfo(generatedStudents);
        HashSet <Student> someStudents = new HashSet<>(generatedStudents);
        printStudents(someStudents,2);

//  Написать простой класс Телефонный Справочник, который хранит в
//  себе список фамилий и телефонных номеров. В этот телефонный
//  справочник с помощью метода add() можно добавлять записи, а с
//  помощью метода get() искать номер телефона по фамилии. Следует
//  учесть, что под одной фамилией может быть несколько телефонов (в
//  случае однофамильцев), тогда при запросе такой фамилии должны
//  выводиться все телефоны.
        PhoneDirectory phoneDirectory = new PhoneDirectory(initializePhoneDirectory());
        printPhonesCollection(phoneDirectory.getPhoneDirectory());
        phoneDirectory.add(11111111, "Юра");
        printPhonesCollection(phoneDirectory.getPhoneDirectory());
        findAndPrintPhones(phoneDirectory, "Юра");
        findAndPrintPhones(phoneDirectory, "Саня");
    }


}
