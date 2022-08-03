package com.example.dsalg


class MinHeap<T : Comparable<T>> (private val data: Array<T>) {
    private var n = data.size

    init {
        // build minimum heap with origin data array
        val firstLeaf = (n - 1) / 2
        for (i in firstLeaf downTo 0) {
            shiftDown(i)
        }
    }

    private fun getTop() : T {
        return data[0]
    }

    fun flow(t: T, dst: MutableList<T>) : Boolean {
        if (n > 0) {
            dst.add(getTop())

            return if (t < getTop()) {
                data[0] = data[--n]
                shiftDown(0)
                n > 0
            } else {
                data[0] = data[n - 1]
                data[n - 1] = t
                shiftDown(0)
                true
            }
        }

        return false
    }

    private fun shiftDown(index: Int) {
        val l = 2 * index + 1
        if (l < n) {
            val t = if (l < n - 1 && data[l] < data[l + 1]) l else l + 1
            if (data[t] < data[index]) {
                data[t] = data[index].also { data[index] = data[t] }
                shiftDown(t)
            }
        }
    }

    private fun shiftUp(index: Int) {

    }
}