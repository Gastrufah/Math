package back;

import java.util.Scanner;

public class Functions {
    public static double[][] fillMatrix(Matrix matrix){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getLength(); j++) {
                System.out.print(String.format("Enter element with coords A%d%d :", i+1, j+1));
                try {
                    matrix.values[i][j] = sc.nextDouble();
                }
                catch (Exception e){
                    System.out.println(String.format("Error with enter element A%d%d", i+1,j+1));
                }
            }
        }
        return matrix.values;
    }

    public static double[][] fillMatrixRandom(Matrix matrix){
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getLength(); j++) {
                matrix.values[i][j]=(int) (Math.random()*100);
            }

        }
        return matrix.values;
    }

    public static void printMatrix(Matrix matrix){
        for (int i = 0; i < matrix.getHeight(); i++) {
            System.out.print("|");
            for (int j = 0; j < matrix.getLength(); j++) {
                System.out.print(matrix.values[i][j]+ " ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static double foundDet(Matrix matrix) throws Exception {
        double result = 0;
        if(matrix.getLength()==matrix.getHeight() && matrix.getHeight()==3){
            result += matrix.values[0][0]* matrix.values[1][1]* matrix.values[2][2];//Главная диагональ
            result += matrix.values[0][2]* matrix.values[1][0]* matrix.values[2][1];//Треугольник с вершиной в правом верхнем углу
            result += matrix.values[0][1]* matrix.values[1][2]* matrix.values[2][0];//Треугольник с  вершиной в левом нижнем углу
            result -= matrix.values[0][2]* matrix.values[1][1]* matrix.values[2][0];//Не главная диагональ
            result -= matrix.values[1][2]* matrix.values[2][1]* matrix.values[0][0];//Треугольник с вершиной в левом верхнем углу
            result -= matrix.values[0][1]* matrix.values[1][0]* matrix.values[2][2];//Треугольник с вергшиной в правом нижнем углу
        }

        for (int i = 0; i < matrix.getHeight() ; i++) {
            matrix.values[i][i];
        }



        else throw new Exception("Ti debil? Ona ne kvadratnaya");
        return result;
    }

    public static Matrix getSum(Matrix A, Matrix B) throws Exception {
        if(A.getHeight() == B.getHeight() && A.getLength()==B.getLength()) {
            double[][] first = A.getValues();
            double[][] second = B.getValues();
            double[][] resultMatrixValues = new double[A.getLength()][B.getHeight()];

            for (int i = 0; i <A.getLength() ; i++) {
                for (int j = 0; j < A.getHeight(); j++) {
                    resultMatrixValues[i][j]=first[i][j]+second[i][j];
                }

            }
            return new Matrix(resultMatrixValues);
        }
        else throw new Exception("Not same razmernost");

    }
    public static Matrix getDifference(Matrix A, Matrix B) throws Exception {
        if(A.getHeight() == B.getHeight() && A.getLength()==B.getLength()) {
            double[][] first = A.getValues();
            double[][] second = B.getValues();
            double[][] resultMatrixValues = new double[A.getLength()][B.getHeight()];

            for (int i = 0; i <A.getLength() ; i++) {
                for (int j = 0; j < A.getHeight(); j++) {
                    resultMatrixValues[i][j]=first[i][j]-second[i][j];
                }

            }
            return new Matrix(resultMatrixValues);
        }
        else throw new Exception("Not same razmernost");}

    public static Matrix getProduct(Matrix A, Matrix B) throws Exception{
        if(A.getLength() == B.getHeight()){
            Matrix newMatrix = new Matrix(A.getHeight(),B.getLength());   // Создание результирующей матрицы с длинной (количеством столбцов) первой матрицы и высотой второй

            for (int i = 0; i < newMatrix.values.length; i++) {
                for (int j = 0; j <newMatrix.values[0].length ; j++) {  //Заполняем по новой матрице
                    double result=0;   //очистка
                    for (int k = 0; k <A.getLength(); k++) {
                        result+= A.values[i][k]*B.values[k][j]; //Зависимости: x1 ->i y1 -> k x2 ->k y2->j
                    }
                    newMatrix.values[i][j] = result; //запись результата в матрицу
                }
            }
            return newMatrix;
        }
        else throw new Exception("Nelzya ix umnojat'");
    }

    public static double getNumberToGetZero(double verx, double niz){
        double x = -niz/verx;
        return  x;
    }
}
