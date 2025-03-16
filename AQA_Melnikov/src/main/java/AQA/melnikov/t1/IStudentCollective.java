package AQA.melnikov.t1;

public interface IStudentCollective {
    String getId();
    boolean addStudent(Student student);
    boolean removeStudent(Student student);
    Cources getCource();
    Disciplines[] getDisciplines();
}
