import java.util.Arrays;

public class Triangle extends AbstractFigure{
    public Triangle(double a, double b, double c, String borderColor, String fillColor){
        super(new  double[]{a,b,c}, borderColor, fillColor);

        boolean areSidesOfTriangle = (a+b>c) || (a+c>b) || (b+c>a);
        if(!areSidesOfTriangle){
            throw new IllegalArgumentException("Введенные значения не являются сторонами треугольника! "
                    + Arrays.toString(sides));
        }
    }

    @Override
    public double calculateSquare() {
        if (sides.length<3) {
            return 0;
        }
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        double p = super.calculatePerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c)); //Формула Герона
    }

    public String getInfo(){
        String result = super.getInfo();
        result+="\nПериметр:\t"+calculatePerimeter()+"\nПлощадь:\t"+calculateSquare();
        return result;
    }
}
