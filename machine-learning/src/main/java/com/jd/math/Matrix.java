package com.jd.math;

import java.text.*;

/**
 * @author sunchangtan
 * @date 2018/8/14 19:10
 */
public class Matrix {
    private static final DecimalFormat df = new DecimalFormat("#.###");
    private double[][] data;
    private int dim1;
    private int dim2;


    public Matrix(int dim1, int dim2) {
        data = new double[dim1][dim2];
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public Matrix replaceColumn(int columnIndex, Matrix matrixToReplace) {
        if (this.dim1 != matrixToReplace.dim1) {
            throw new IllegalArgumentException("行数不相同");
        }
        if (columnIndex < 0 || columnIndex >= this.dim2) {
            throw new IllegalArgumentException("column index error");
        }
        int dim1 = this.dim1;
        int dim2 = this.dim2 + matrixToReplace.dim2 - 1;
        Matrix newMatrix = new Matrix(dim1, dim2);
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                if(j == columnIndex) {
                    continue;
                }

                if (j < columnIndex) {
                    newMatrix.setData(i, j, this.getData(i, j));
                }

                if (j > columnIndex + matrixToReplace.dim2 - 1) {
                    newMatrix.setData(i, j, this.getData(i, j - matrixToReplace.dim2 + 1));
                }
            }
        }

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < matrixToReplace.dim2; j++) {
                newMatrix.setData(i, j + columnIndex , matrixToReplace.getData(i, j));
            }
        }


        return newMatrix;
    }

    public double[][] getData() {
        return data;
    }

    public double getData(int i, int j) {
        return data[i][j];
    }

    public void setData(int i, int j, double value) {
        data[i][j] = value;
    }

    public int getDim1() {
        return dim1;
    }

    public int getDim2() {
        return dim2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.dim1 > 20) {
            for (int i = 0; i < 10; i++) {
                this.makeString(this.data[i], this.dim2, builder);
                builder.append('\n');
            }
            builder.append("...").append('\n');
            for (int i = this.dim1 - 10; i < this.dim1; i++) {
                this.makeString(this.data[i], this.dim2, builder);
                builder.append('\n');
            }
        } else {
            for (double[] value : data) {
                this.makeString(value, this.dim2, builder);
                builder.append('\n');
            }
        }

        return builder.toString();
    }

    private void makeString(double[] datas, int dim, StringBuilder builder) {
        if (dim > 20) {
            for (int i = 0; i < 10; i++) {
                builder.append(df.format(datas[i])).append('\t');
            }
            builder.append("...").append('\t');
            for (int i = dim - 10; i < dim; i++) {
                builder.append(df.format(datas[i])).append('\t');
            }
        } else {
            for (double value : datas) {
                builder.append(df.format(value)).append('\t');
            }
        }
    }

    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 6);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                m1.setData(i, j, i + j);
            }
        }

        Matrix m2 = new Matrix(3, 2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                m2.setData(i, j, i + j + 10);
            }
        }

        System.out.println(m1);
        System.out.println("---------------------------");
        System.out.println(m2);
        System.out.println("---------------------------");
        System.out.println(m1.replaceColumn(5, m2));
    }
}
