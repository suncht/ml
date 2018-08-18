package com.jd.ml

import com.jd.math.Matrix
import com.jd.math.Vector
import org.apache.commons.csv.CSVFormat
import java.io.FileReader

/**
 * @author sunchangtan
 * @date 2018/8/18 10:35
 *
 */

data class DataSet(val features: Matrix, val label: Vector)

object DataSetReader {
    fun loadFromCsv(fileName: String): DataSet? {
        val reader = FileReader(fileName)
        val parser = CSVFormat.DEFAULT.withHeader("area", "floor", "orientation", "price").parse(reader)
        val rowNumber = parser.recordNumber.toInt()
        val features = Matrix(rowNumber, 3)
        val label = Vector(rowNumber)
        for(record in parser) {
            println(record["area"])
        }
        reader.close()
        return null
    }



}


fun main(args: Array<String>) {
    DataSetReader.loadFromCsv("E:\\开发\\JavaWorkspace\\ml\\machine-learning\\data\\price.csv")

}

