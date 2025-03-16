package AQA.melnikov.t1;

import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Integer> grades;

    public GradeBook() {
        grades = new ArrayList<>();
    }

    public int addGrades(int [] newGrades){
        final int MAX_GRADE = 5;
        final int MIN_GRADE = 1;
        int counter = 0;

        for (int gr: newGrades){
            if (gr>=MIN_GRADE && gr<=MAX_GRADE) {
                grades.add(gr);
                counter++;
            }
        }
        return counter;
    }

    public double getAverage(){
        if (grades.isEmpty()){
            return 0;
        }
        int sum = 0;
        for (Integer gr : grades) {
            sum += gr;
        }
        return ((double)sum)/grades.size();
    }

    public String getGrades(){
        return grades.toString();
    }
}
