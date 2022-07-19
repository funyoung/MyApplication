package com.example.dsalg

/**
 * 8.2.1 Insert sort
 *
 */
class InnerSort {
    companion object {
        /**
         * 插入排序算法, 比较移动版
         * 从第2位元素开始，依次把元素插入左侧已经排好队的序列中。
         *
         */
        fun <T : Comparable<T>> improveInsertSort(array: Array<T>) {
            for (i in 1 until array.size) {
                val tmp = array[i]
                var j = i - 1
                while (j >= 0 && tmp < array[j]) {
                    array[j + 1] = array[j]
                    j--
                }
                array[j + 1] = tmp
            }
        }

        /**
         * 插入排序，逆序交换版
         *
         */
        fun <T : Comparable<T>> swapInsertSort(array: Array<T>) {
            for (i in 1 until array.size) {
                for (j in i - 1 downTo 0) {
                    if (array[j] > array[j + 1]) {
                        // swap j and j + 1 element in the array
                        array[j] = array[j + 1].also { array[j + 1] = array[j] }
                    } else {
                        break
                    }
                }
            }
        }

        /**
         * 冒泡排序算法
         * 从左向右一次两两比较相邻元素，较大值交换到右边，直到已经排好的子队列。
         */
        fun <T : Comparable<T>> improveBubbleSort(array: Array<T>) {
            val sz = array.size
            for (i in 0 until sz) {
                var swapped = false
                for (j in 0 until sz - i - 1) {
                    if (array[j] > array[j + 1]) {
                        array[j] = array[j + 1].apply { array[j + 1] = array[j] }
                        swapped = true
                    }
                }

                if (!swapped) {
                    break
                }
            }
        }

        fun <T : Comparable<T>> heapSort(array: Array<T>) {
            val heap = MaxHeap(array)
            for (i in array.size - 1 downTo 0) {
                array[i] = heap.deleteMax()
            }
        }
    }
}