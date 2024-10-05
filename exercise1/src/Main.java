import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Student[] students = new Student[20];
        // part time
        for(int i = 0; i < students.length/2; i++){
            int[] randomArrayPartTime = new int[20];
            for (int j = 0; j < randomArrayPartTime.length; j++) {
                randomArrayPartTime[j] = rand.nextInt(101);
            }
            students[i] = new PartTime("PartTime"+i);
            students[i].setScores(randomArrayPartTime);
        }
        // full time
        for(int i = students.length/2; i < students.length; i++){
            int[] randomArrayFullTime = new int[22];
            for (int j = 0; j < randomArrayFullTime.length; j++) {
                randomArrayFullTime[j] = rand.nextInt(101);
            }
            students[i] = new FullTime("FullTime"+i);
            students[i].setScores(randomArrayFullTime);
        }

        Session s = new Session(students);
        System.out.println("Calculate average quiz scores per student for the whole class");
        System.out.println(Arrays.toString(s.getAvg()));
        System.out.println();
        s.printScores();
        s.printFullTimeScores();
        s.printPartTimeName();


    }
}