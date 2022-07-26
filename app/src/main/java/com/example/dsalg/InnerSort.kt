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
         * 增量除2递减，每一轮都重复上一轮已经排过序的子序列，低效。Hibbard增量序列提高互质性，排序效率更高
         * 2^k-1, 2^(k-1)-1, ..., 7, 3, 1}
         */
        fun <T : Comparable<T>> hibbardShellSort(array: Array<T>) {
            var delta = 1
            var n = array.size
            while (n > 0) {
                delta *= 2
                n /= 2
            }

            while (delta > 1) {
                for (i in 0 until delta) {
                    modInsertSort(array, i, delta - 1)
                }
                delta /= 2
            }
        }

        /**
         * 直接选择排序，一次从待排序列中选出最小元素，次小元素交换到左一，二，...N位置
         */
        fun <T : Comparable<T>> selectSort(array: Array<T>) {
            for (i in array.indices) {
                var smallest = i
                for (j in i + 1 until array.size) {
                    if (array[j] < array[smallest]) {
                        smallest = j
                    }
                }
                if (smallest != i) {
                    // swap element in smallest and i, not stable
                    // todo: to make the sorting stable, move [i, smallest) to right 1,
                    // and then store origin array[smallest] to array[i]
                    array[i] = array[smallest].also { array[smallest] = array[i] }
                }
            }
        }

        /**
         * 堆排序
         */
        fun <T : Comparable<T>> heapSort(array: Array<T>) {
            val heap = MaxHeap(array)
            for (i in array.size - 1 downTo 0) {
                array[i] = heap.deleteMax()
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

        /**
         * 快速排序
         */
        fun <T: Comparable<T>> quickSort(array: Array<T>) {
            quickSort(array, 0, array.size - 1)
        }

        private fun <T: Comparable<T>> quickSort(array: Array<T>, l: Int, r: Int) {
            if (l < r) {
                val m = l + (r - l) / 2
                // swap element with index pivot and r
                array[m] = array[r].also { array[r] = array[m] }
                val pivot = partition(array, l, r)
                quickSort(array, l, pivot - 1)
                quickSort(array, pivot + 1, r)
            }
        }

        private fun <T: Comparable<T>> partition(array: Array<T>, l: Int, r: Int) : Int {
            var i = l
            var j = r
            val pv = array[r]
            while (i != j) {
                while (array[i] <= pv && i < j) {
                    i++
                }
                if (i < j) {
                    array[j--] = array[i]
                }

                while (array[j] > pv && j > i) {
                    j--
                }
                if (j > i) {
                    array[i++] = array[j]
                }
            }

            array[i] = pv
            return i
        }

        /**
         * 归并排序 -- 2路归并
         */
        fun <T: Comparable<T>> mergeSort(array: Array<T>) {
            val tmp = array.copyOf()
            mergeSort(array, tmp, 0, array.lastIndex)
        }
        fun <T: Comparable<T>> mergeSort(array: Array<T>, tmp: Array<T>, left: Int, right: Int) {
            if (left < right) {
                val middle = left + (right - left) / 2
                mergeSort(array, tmp, left, middle)
                mergeSort(array, tmp, middle + 1, right)
                merge(array, tmp, left, right, middle)
            }
        }

        /**
         * merge tmp [left, right] back to array [left, right], i, j 分别在tmp的[left, middle]和[middle + 1, right]
         * 比较，较小的元素值写回array[k++], 最后剩余tmp[i, middle]或tmp[j, right]之一继续写回array[k++]
         * TODO: R.Sedgewick 优化, 从两端向中间开始归并，简化边界判断
         */
        fun <T: Comparable<T>> merge(array: Array<T>, tmp: Array<T>, left: Int, right: Int, middle: Int) {
            for (k in left..right) {
                tmp[k] = array[k]
            }

            var i = left
            var j = middle + 1
            var k = left

            // 比较tmp[i]和tmp[j]中较小的值写回array
            while (i <= middle && j <= right) {
                if (tmp[i] <= tmp[j]) {
                    array[k++] = tmp[i++]
                } else {
                    array[k++] = tmp[j++]
                }
            }

            // tmp[i, middle]或者tmp[j, right]写回array剩余位置
            while (i <= middle) {
                array[k++] = tmp[i++]
            }
            while (j <= right) {
                array[k++] = tmp[j++]
            }
        }

        /**
         * 8.6.1 桶式排序
         * n元数组元素的值在m之内，分配m个数据桶，1. 分别统计数组中值等于桶索引下标的个数，2. 然后每个桶累计之前所有
         * 桶（包含该桶本身）元素个数之和，3. 最后从数组右向左遍历，逐个放入它的目标位置（需要开辟临时辅助数组拷贝），
         * 数组元素值为索引取出桶的元素值为该元素以及不大于它的所有元素个数，桶内只减减一后，桶的数值为元素在目标数组的索引
         */
        fun bucketSort(array: IntArray, m: Int) {
            val count = IntArray(m) { 0 }
            for (i in array.indices) {
                count[array[i]]++
            }
            for (i in 1..count.lastIndex) {
                count[i] += count[i - 1]
            }

            val t = IntArray(array.size) { array[it] }
            for (i in t.lastIndex downTo 0) {
                array[--count[t[i]]] = t[i]
            }
        }

        /**
         * 8.6.2 基数排序，桶式排序对排序码范围很大时，可以把排序码分解成若干个组成部分（如扑克牌的花色*点数，一个自然数
         * 的个十百千...位等等）有MSD高位优先和LSD低位优先两种。存储方式有基于顺序存储和基于链式存储两种。
         */
        fun lsdRadixSort(array: IntArray, d: Int, r: Int) {
            val t = IntArray(array.size) { array[it] }
            val c = IntArray(r) { 0 }
            var radix = 1
            for (i in 1..d) {
                for (j in array.indices) {
                    t[i] = array[i]
                }
                for (j in c.indices) {
                    c[j] = 0
                }

                for (j in array) {
                    val k = (j / radix) % r
                    c[k]++
                }
                for (j in 1..c.lastIndex) {
                    c[j] += c[j - 1]
                }

                for (j in t.lastIndex downTo 0) {
                    val k = (t[j] / radix) % r
                    array[--c[k]] = t[j]
                }

                // 同步array到t
                for (j in array.indices) {
                    t[j] = array[j]
                }

                radix *= r
            }
        }
    }
}