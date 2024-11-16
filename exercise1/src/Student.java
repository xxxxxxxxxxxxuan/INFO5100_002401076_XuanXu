public class Student {
    private int[] scores;
    private String name;

    public Student(String name, int size) {
        this.name = name;
        this.scores = new int[size];
    }

    public String getName() {
        return name;
    }
    public int[] getScores() {
        return scores;
    }
    public void setScores(int[] scores) {
        this.scores = scores;
    }

}
