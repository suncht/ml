package com.jd.ml

import com.jd.math.Matrix
import com.jd.math.Vector
import org.apache.commons.lang3.RandomUtils

/**
 * @author sunchangtan
 * @date 2018/8/13 20:57
 *
 */

fun main(args: Array<String>) {
    val num = 100
    val featureNum = 100
    val labels = Vector(num)
    val features = Matrix(num, featureNum)

    for(i in 0 until num) {
        for(j in 0 until featureNum) {
            features.setData(i, j, RandomUtils.nextDouble(1.0, 30.0))
        }

        labels.setData(i,3 * features.getData(i, 0) + 4 * features.getData(i, 1) + 5 * features.getData(i, 2) + 10 + RandomUtils.nextDouble(0.001, 0.1))
    }

    println(features)



}