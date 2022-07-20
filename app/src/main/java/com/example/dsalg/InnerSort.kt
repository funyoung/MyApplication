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
         * 插入排序算法，比较移动版，插入迭代循环起止索引变化
         */
        fun <T: Comparable<T>> improveInsertSortOpt(array: Array<T>) {
            for (i in 1 until array.size) {
                var j = i
                // 已排子序列[0, j]调整有序，最右侧元素a[j]需要往前检测调整插入
                val tmp = array[j]
                // j左边元素比目标元素值大则移动，否则内层循环迭代完成，把目标元素值保存到位置j
                while (j > 0 && tmp < array[j - 1]) {
                    array[j] = array[j - 1]
                    j--
                }
                array[j] = tmp
            }
        }

        /**
         * 插入排序算法，比较移动版，已排子序列在右侧
         * 已排子序列[n-1, n-1]，待排子序列[0, n-2]，每次循环从[n-2, 0], 插入右侧已排子序列[i, n-1]
         */
        fun <T : Comparable<T>> improveInsertSortRight(array: Array<T>) {
            for (i in array.size - 2 downTo 0) {
                var j = i
                val tmp = array[j]
                while (j < array.size - 1) {
                    if (array[j + 1] < tmp) {
                        array[j] = array[j + 1]
                        j++
                    } else {
                        break
                    }
                }
                array[j] = tmp
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