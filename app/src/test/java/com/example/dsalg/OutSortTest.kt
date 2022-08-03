package com.example.dsalg

import org.junit.Assert.*
import org.junit.Test

class OutSortTest {
    @Test
    fun replacementSelection_correct() {
        val input = intArrayOf(29,14,35,13)
        val heap = intArrayOf(16, 19, 31, 25, 21, 56, 40)
        val expect = intArrayOf(16, 19, 21, 25).toTypedArray()
        val output = OutSort.replacementSelection(input.toTypedArray(), heap.toTypedArray())
        assertArrayEquals(expect, output)
    }
}
