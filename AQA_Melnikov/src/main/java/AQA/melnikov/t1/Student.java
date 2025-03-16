package AQA.melnikov.t1;

//Создайте класс Student, содержащий следующие характеристики – имя,
//группа, курс, оценки по предметам. Создайте коллекцию, содержащую
//объекты класса Student. Следует написать метод, который удаляет
//студентов со средним баллом < 3, а также отдельный метод, который
//переводит студента на следующий курс, если средний балл >= 3.
//Напишите метод printStudents(Set<Student> students, int course), который
//получает список студентов и номер курса. Метод печатает на консоль
//имена тех студентов, которые обучаются на данном курсе.

import java.util.HashMap;

public class Student {
    private String name;
    private IStudentCollective group;
    private Cources cource;
    private HashMap<Disciplines, GradeBook> gradesCollection;

    public Student(String name, IStudentCollective group){
        this.name = name;
        this.group = group;
        this.cource = group.getCource();
        gradesCollection = new HashMap<>();
        for (Disciplines d : group.getDisciplines()){
            gradesCollection.put(d,new GradeBook());
        }
    }

    public Cources getCource() {
        return cource;
    }

    public void setCource(Cources cource){
        this.cource = cource;
    }

    public String getName() {
        return name;
    }

    public IStudentCollective getGroup() {
        return group;
    }

    public String getGrades(){
        StringBuilder result = new StringBuilder();
        for (Disciplines dis : gradesCollection.keySet()) {
            result.append(dis);
            result.append( ": ");
            result.append( gradesCollection.get(dis).getGrades());
            result.append( "\t AVG: ");
            result.append(gradesCollection.get(dis).getAverage());
            result.append( "\n");
        }
        return result.toString();
    }

    public void addGrades(Disciplines discipline, int[] newGrades){
        gradesCollection.get(discipline).addGrades(newGrades);
    }

    public void assignToGroup(IStudentCollective group){
        this.group=group;
    }

    public double getAverage(Disciplines discipline){
        GradeBook gradeBook =  gradesCollection.get(discipline);
        return gradeBook.getAverage();
    }
}
