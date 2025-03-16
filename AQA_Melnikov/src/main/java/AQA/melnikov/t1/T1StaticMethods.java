package AQA.melnikov.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class T1StaticMethods {
    public static void closeStudyYear(Group[] groupsArray) {
        for (Group gr: groupsArray){
            int count = gr.purgeTheWeak();
            System.out.printf("Группа %s: Отчислено %d человек(а)\n",gr.getId(),count);
            gr.advance();
        }
    }

    public static void printStudentsInfo(ArrayList<Student> studentsList) {
        for(Student st: studentsList){
            int courceNumber =st.getCource().getNumber();
            String courceSting = (courceNumber>Cources.GRADUATION_YEAR)? " успешно выпустился": courceNumber+" курс";
            System.out.println(st.getName()
                    +" (" + st.getGroup().getId() +
                    ", " + courceSting+
                    "):" + st.getGrades());
        }
    }

    public static void printStudentsInfo(Group[] groups){
        for(Group gr: groups) {
            printStudentsInfo(gr.getStudentCollection());
        }
    }

    public static Group[] initializeGroupsArray() {
        Group [] result = new Group[]{
                new Group("Bravo",
                        Cources.SECOND,
                        new Disciplines[]{
                                Disciplines.MATHEMATICS,
                                Disciplines.PHYSICS}),
                new Group("Alpha",
                        Cources.FIRST,
                        new Disciplines[]{
                                Disciplines.ECONOMY}),
                new Group("Delta",
                        Cources.FOURTH,
                        new Disciplines[]{
                                Disciplines.MATHEMATICS,
                                Disciplines.PROGRAMMING,
                                Disciplines.PHYSICS}),
                new Group("Echo",
                        Cources.FIFTH,
                        new Disciplines[]{
                                Disciplines.MATHEMATICS}),
        };
        return result;
    }

    public static ArrayList<Student> generateStudents(Group[] groups){
        final int MAX_GROUP = groups.length-1;
        final int GRADES_COUNT = 8;
        final int MAX_GENERATED_GRADE = 6;

        ArrayList <Student> result = new ArrayList<>( Arrays.asList(new Student[]{
                new Student("AAA A.", groups[rnd(MAX_GROUP)]),
                new Student("BBB B.", groups[rnd(MAX_GROUP)]),
                new Student("CCC B.", groups[rnd(MAX_GROUP)]),
                new Student("CCD B.", groups[rnd(MAX_GROUP)]),
                new Student("CCC C.", groups[rnd(MAX_GROUP)]),
                new Student("DDA D.", groups[rnd(MAX_GROUP)]),
                new Student("ABC D.", groups[rnd(MAX_GROUP)]),
                new Student("DAD A.", groups[rnd(MAX_GROUP)]),
                new Student("DAD A.", groups[0]),
                new Student("DAD A.", groups[1]),
        }));
        for (Student st : result){
            Group gr = (Group) st.getGroup();
            if(!gr.addStudent(st)){
                System.out.printf("Не удалось добавить студента %s в группу %s", st.getName(), gr.getId());
                st.assignToGroup(null);
                continue;
            }
            Disciplines[] personalDisciplines = gr.getDisciplines();
            for(Disciplines pd : personalDisciplines){
                int[] gradesArray = new int[GRADES_COUNT];
                for (int i = 0; i < GRADES_COUNT; i++) {
                    gradesArray[i]=rnd(MAX_GENERATED_GRADE);
                }
                st.addGrades(pd,gradesArray);
            }
        }
        return result;
    }

    public static int rnd(int max) {
        return (int)(Math.random()*(max + 1));
    }

    public static void printStudents(Set<Student> students, int course){
        students.forEach( (st) -> {
            if (st.getCource().getNumber() == course){
                System.out.println(st.getName());
            }
        });
    }
}
