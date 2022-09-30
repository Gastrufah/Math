package back;

public class Matrix {
    final private int height;
    final private int length;

    final protected double[][] values;

    public Matrix(int height, int length) {
        this.height = height;
        this.length = length;

        values = new double[height][length];
    }

    public Matrix(double[][] values) {
        this.length=values[0].length;
        this.height=values.length;
        this.values = values;
    }

    public double[][] getValues() {
        return values;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
