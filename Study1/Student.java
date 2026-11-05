public class Student{
    private String name;
    private double ball;

    public Student(String name, double ball){
        this.name = name;
        this.ball = ball;
    }

    public String get_name(){
        return name;
    }

    public double get_ball(){
        return ball;
    }

    @Override
    public String toString(){
        return "Студент: " + name + " || Средний балл: "  + ball;
    }
}
