package com.example.dsalg

/**
 * 8.2.1 Insert sort
 *
 */
class InnerSort {
    companion object {
        fun <T : Comparable<T>> improveInsertSort(array: Array<T>) {
            for (i in 1 until array.size) {
                val tmp = array[i]
                var j = i - 1
                while (j >=0 && tmp < array[j]) {
                    array[j + 1] = array[j]
                    j--
                }
                array[j + 1] = tmp
            }
        }
    }
}