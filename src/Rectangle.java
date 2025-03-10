public class Rectangle extends AbstractFigure {
    public Rectangle (double a, double b, String borderColor, String fillColor){
        super(new double[] {a,b,a,b}, borderColor, fillColor);
    }

    @Override
    public double calculateSquare() {
        return sides[0]*sides[1];
    }

    @Override
    public String getInfo(){
        String result = super.getInfo();
        result+="\nПериметр:\t"+calculatePerimeter()+"\nПлощадь:\t"+calculateSquare();
        return result;
    }
}
