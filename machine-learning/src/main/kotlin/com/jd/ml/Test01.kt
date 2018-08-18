package com.jd.ml

/**
 * @author sunchangtan
 * @date 2018/8/13 20:56
 *
 */

fun main(args: Array<String>) {
    val opt = Optimization()
    val f = { x: Double -> Math.pow(x, 4.0) - 3 * Math.pow(x, 3.0) + 2.0}
    val fd = { x: Double -> 4 * Math.pow(x, 3.0) - 9 * Math.pow(x, 2.0) }

    val start = System.currentTimeMillis()
    val res1 = opt.gradientDescent(f, fd, 6.0, 0.01, 0.00001)
    val res2 = opt.gradientDescent2(f, 6.0, 0.01, 0.00001)
    val end = System.currentTimeMillis()
    println(end - start)
    println(res1)
    println(res2)
}