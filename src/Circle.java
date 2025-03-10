public class Circle extends AbstractFigure {
    public Circle (double radius, String borderColor, String fillColor){
        super(new double[] {radius}, borderColor, fillColor);
    }

    @Override
    public double calculateSquare() {
        double r = sides[0];
        return Math.PI*r*r;
    }

    @Override
    public double calculatePerimeter(){
        return 2*Math.PI*sides[0];
    }

    public String getInfo(){
        StringBuilder result = new StringBuilder("Радиус: "+String.format("%.2f", sides[0]));
        result.append("\nЦвет заливки:\t");
        result.append(borderColor);
        result.append("\nЦвет границ:\t");
        result.append(fillColor);
        result.append("\nДлина окружности:\t");
        result.append(calculatePerimeter());
        result.append("\nПлощадь:\t");
        result.append(calculateSquare());
        return result.toString();
    }
}
