package com.example.dsalg

/**
 * 最大堆
 */
class MaxHeap<T : Comparable<T>>(private val data:Array<T>) {
    private var n = data.size

    init {
        val firstLeaf = (1 + data.size) / 2
        for (i in firstLeaf - 1 downTo 0) {
            shiftDown(i)
        }
    }

    fun deleteMax() : T {
        return data[0].apply {
            data[0] = data[--n]
            shiftDown(0)
        }
    }

    private fun shiftDown(index: Int) {
        val l = 2 * index + 1
        if (l < n) {
            val r = if (l < n - 1) l + 1 else l
            val t = if (data[l] > data[r]) l else r
            if (data[t] > data[index]) {
                data[t] = data[index].apply { data[index] = data[t] }
                shiftDown(t)
            }
        }
    }
}