import java.util.Arrays;

public class Session {
    private Student[] students;
    private float[] avg;

    public Session(Student[] students) {
        this.students = students;
        this.avg = calculateScores();
    }

    public float[] getAvg() {
        return avg;
    }

    public float[] calculateScores() {
        float[] score = new float[students.length];
        for (int i = 0; i < students.length; i++) {
            int sum = 0;
            sum += Arrays.stream(students[i].getScores()).sum();
            if (students[i].getClass() == FullTime.class) {
                score[i] = sum / 22f;
            } else {
                score[i] = sum / 20f;
            }
        }
        return score;
    }

    public void printScores() {
        System.out.println("Print the list of quiz scores in ascending order");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName() +": " + Arrays.toString(students[i].getScores()));
        }
        System.out.println();
    }

    public void printPartTimeName() {
        System.out.println("Print names of part-time students");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getClass() != FullTime.class) {
                System.out.println(students[i].getName());
            }
        }
        System.out.println();
    }

    public void printFullTimeScores() {
        System.out.println("Print exam scores of full-time students");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getClass() == FullTime.class) {
                System.out.println(Arrays.toString(students[i].getScores()));
            }
        }
        System.out.println();
    }
}


