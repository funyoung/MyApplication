package com.example.dsalg

class OutSort {
    companion object {
        inline fun <reified T : Comparable<T>> replacementSelection(src: Array<T>, heap: Array<T>) : Array<T> {
            val h = MinHeap(heap)
            val list = mutableListOf<T>()
            for (i in src) {
                if (!h.flow(i, list)) {
                    break
                }
            }
            return list.toTypedArray()
        }
    }
}