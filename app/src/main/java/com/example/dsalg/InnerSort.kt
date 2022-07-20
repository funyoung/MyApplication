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
         * 数组array的第i个元素右侧间隔step个元素的子序列排序, i, i + step, i + 2step, ...(<n)
         * 待排子序列显示小序列，位置i的首元素在已排子子序列，右侧+n*step为待排子子序列
         */
        private fun <T : Comparable<T>> modInsertSort(array: Array<T>, start: Int, delta: Int) {
            var i = start + delta
            while (i < array.size) {
                for (j in i downTo start + delta) {
                    if (array[j] < array[j - delta]) {
                        // swap elements in the array
                        array[j] = array[j - delta].also { array[j - delta] = array[j] }
                    } else {
                        break
                    }
                }

                i += delta
            }
        }

        /**
         * Shell排序，插入排序在待排序列已经正序时，仅需要O(n)的时间复杂度和O(1)的空间复杂度，另一方面，待排序列较小时，
         * 插入排序的效率尚可。因此Shell先用插入排若干个小序列，然后小序列逐渐变大（同时更接近有序）。关键在于产生序列
         * 互质性，否则原序列中元素被重复多次挪动插入，性能更差
         */
        fun <T : Comparable<T>> shellSort(array: Array<T>) {
            var delta = array.size / 2
            while (delta > 0) {
                for (j in 0 until delta) {
                    modInsertSort(array, j,  delta)
                }
                delta /= 2
            }

            if (delta > 0) {
                modInsertSort(array, 0, 1)
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