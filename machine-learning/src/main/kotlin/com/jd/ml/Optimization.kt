package com.jd.ml

/**
 * @author sunchangtan
 * @date 2018/8/13 20:05
 *
 */

data class GDResult(val y: Double, val x: Double, val iter: Long)

class Optimization {
    /**
     * 梯度下降求函数的最小值
     */
    fun gradientDescent(targetFun: (Double) -> Double,
                        derivativeFun: (Double) -> Double,
                        init: Double,
                        learnRate: Double,
                        precision: Double): GDResult {
        var difference = targetFun(init)
        var x = init
        var y = targetFun(x)
        var iter: Long = 0
        while (difference > precision) {
            x -= learnRate * derivativeFun(x)
            difference = y - targetFun(x)
            y = targetFun(x)
            iter++
        }

        return GDResult(y, x, iter)
    }

    /**
     * 梯度下降2求函数的最小值
     */
    fun gradientDescent2(targetFun: (Double) -> Double,
                        init: Double,
                        learnRate: Double,
                        precision: Double): GDResult {
        var difference = targetFun(init)
        var x = init
        var y = targetFun(x)
        var iter: Long = 0
        while (difference > precision) {
            x -=  learnRate * derivative(targetFun, x)
            difference = y - targetFun(x)
            y = targetFun(x)
            iter++
        }

        return GDResult(y, x, iter)
    }

    /**
     * 函数求导
     */
    private fun derivative(targetFun: (Double) -> Double, value: Double, delta: Double = 0.0001): Double {
        return (targetFun(value + delta) - targetFun(value)) / delta
    }

//    fun batchGradientDescent(targetFun: (Double) -> Double,
//                             derivativeFun: (Double) -> Double
//
//                             ): GDResult {
//
//    }


}

