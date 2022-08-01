package com.example.dsalg

/**
 * 索引排序，各种排序的索引排序版本。与直接操作数组array中的数据不同，此版本会重新开辟n个元素的索引
 * 数组，元素的比较和移动操作在索引数组中进行。
 */
class IndexSort {
    companion object {
        /**
         * 插入排序算法, 比较移动版
         * 从第2位元素开始，依次把元素插入左侧已经排好队的序列中。
         *
         */
        inline fun <reified T : Comparable<T>> improveInsertSort(array: Array<T>) {
            val index = IntArray(array.size) { 0 }
            for (i in 1..array.lastIndex) {
                val tmp = array[i]
                var j = i - 1
                while (j >= 0 && array[index[j]] > tmp) {
                    index[j + 1] = index[j]
                    j--
                }
                index[j + 1] = i
            }
            val t = Array(array.size) { array[index[it]] }
            for (i in t.indices) {
                array[i] = t[i]
            }
        }
    }
}