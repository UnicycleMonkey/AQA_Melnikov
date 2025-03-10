import java.util.Arrays;

public abstract class AbstractFigure implements IHasSquare, IHasPerimeter{
    protected double [] sides;
    protected String borderColor;
    protected String fillColor;

    public AbstractFigure(double[] sides, String borderColor, String fillColor){
        for (double s: sides){
            if (s<=0){
                throw new IllegalArgumentException("Длины сторон фигуры должны быть строго положительны! "+
                        s+"<=0; "+ Arrays.toString(sides));
            }
        }
        this.sides=sides.clone();
        this.borderColor=borderColor;
        this.fillColor=fillColor;
    }

    @Override
    public double calculatePerimeter(){
        if(sides==null) {
            return 0;
        }
        double result = 0;
        for (double s : sides) {
            result += s;
        }
        return result;
    }

    public String getInfo(){
        StringBuilder result = new StringBuilder("Стороны: [\t");
        for (double side : sides){
            result.append(String.format("%.2f\t", side));
        }
        result.append("]\nЦвет заливки:\t");
        result.append(borderColor);
        result.append("\nЦвет границ:\t");
        result.append(fillColor);
        return result.toString();
    }
}
