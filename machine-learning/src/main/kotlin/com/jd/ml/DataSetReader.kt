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
    fun loadFromCsv(fileName: String, onehot: Boolean = false): DataSet {
        val reader = FileReader(fileName)
        val parser = CSVFormat.DEFAULT.withHeader("area", "floor", "orientation", "price").withTrim()
                .withSkipHeaderRecord().parse(reader)
        val records = parser.records
        reader.close()

        val rowNumber = records.size
        var features = Matrix(rowNumber, 3)
        val label = Vector(rowNumber)

        val orientationVector = mutableListOf<String>()

        records.forEachIndexed { index, csvRecord ->
            features.setData(index, 0, csvRecord["area"].toDouble())
            features.setData(index, 1, csvRecord["floor"].toDouble())

            orientationVector += csvRecord["orientation"]

            label.setData(index, csvRecord["price"].toDouble())
        }

        val orientationMatrix = oneHot(orientationVector)
        features = features.replaceColumn(2, orientationMatrix)


        return DataSet(features, label)
    }

    private fun oneHot(data: List<String>): Matrix {
        var unqueData = mutableSetOf<String>()
        unqueData.addAll(data)
        val dataIndex = mutableListOf<Int>()
        for (item in data) {
            dataIndex += unqueData.indexOf(item)
        }

        val dim1 = data.size
        val dim2 = unqueData.size
        val matrix = Matrix(dim1, dim2)

        dataIndex.forEachIndexed { i, j ->
            matrix.setData(i, j, 1.0)
        }

        return matrix
    }

}


fun main(args: Array<String>) {
    val ds = DataSetReader.loadFromCsv("E:\\开发\\JavaWorkspace\\ml\\machine-learning\\data\\price.csv")
    println(ds.features)
}

