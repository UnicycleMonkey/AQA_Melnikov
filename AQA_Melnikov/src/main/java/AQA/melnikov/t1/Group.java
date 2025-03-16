package AQA.melnikov.t1;

import java.util.*;

public class Group implements IStudentCollective{
    public final double MINIMUM_GRADE = 3;

    private String id;
    private LinkedList<Student> studentCollection;
    private HashSet<Disciplines> disciplines;
    private Cources cource;

    public Group(String id, Cources cource,  Disciplines[] disciplinesList){
        this.id = id;
        this.cource = cource;
        this.disciplines=new HashSet<>();
        disciplines.addAll(List.of(disciplinesList));
        studentCollection = new LinkedList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean addStudent(Student student) {
        boolean result = studentCollection.add(student);
        student.assignToGroup(this);
        return result;
    }

    @Override
    public boolean removeStudent(Student student) {
        boolean result =  studentCollection.remove(student);
        student.assignToGroup(null);
        return result;
    }

    @Override
    public Cources getCource() {
        return cource;
    }

    public void advance(){
        cource= Cources.advance(cource);
        for ( Student st: studentCollection){
            st.setCource(cource);
        }
    }

    @Override
    public Disciplines[] getDisciplines() {
        Disciplines [] result = new Disciplines[disciplines.size()];
        disciplines.toArray(result);
        return result;
    }

    public int purgeTheWeak(){
        ArrayList <Student> decimationList = new ArrayList<>();
        for (Student st : studentCollection) {
            for (Disciplines dis : disciplines) {
                if (st.getAverage(dis) < MINIMUM_GRADE) {
                    System.out.printf("Студент %s с позором изгнан из группы %s со средним баллом %.2f по %s\n",
                            st.getName(), this.getId(), st.getAverage(dis), dis.name());
                    decimationList.add(st);
                    break;
                }
            }
        }
        for (Student st: decimationList){
            removeStudent(st);
        }
        return decimationList.size();
    }

    public ArrayList<Student> getStudentCollection() {
        return new ArrayList<>(studentCollection);
    }
}
