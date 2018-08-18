package com.jd.math;

import java.text.DecimalFormat;

/**
 * @author sunchangtan
 * @date 2018/8/14 20:35
 */
public class Vector {
    private static final DecimalFormat df = new DecimalFormat("#.###");
    private double[] data;
    private int dim;


    public Vector(int dim) {
        data = new double[dim];
        this.dim = dim;
    }

    public double[] getData() {
        return data;
    }

    public double getData(int i) {
        return data[i];
    }

    public void setData(int i, double value) {
        data[i] = value;
    }

    public int getDim() {
        return dim;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(this.dim>20) {
            for (int i = 0; i < 10; i++) {
                builder.append(df.format(this.data[i])).append('\n');
            }
            builder.append("...").append('\n');
            for (int i = this.dim - 10; i < this.dim; i++) {
                builder.append(df.format(this.data[i])).append('\n');
            }
        } else {
            for (double value : data) {
                builder.append(df.format(value)).append('\n');
            }
        }

        return builder.toString();
    }

}
