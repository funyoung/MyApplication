package com.example.dsalg

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class IndexSortTest {
    private val result = arrayOf(12, 29, 32, 34, 34, 45, 64, 78)
    private val data = arrayOf(45, 34, 78, 12, 34, 32, 29, 64)

    private val radixArray = intArrayOf(97, 53, 88, 59, 26, 41, 88, 31, 22)
    private val radixExpected = intArrayOf(22, 26, 31, 41, 53, 59, 88, 88, 97)

    @Before
    fun setup() {
        data.shuffle()
    }

    @Test
    fun improveInsertSort_correct() {
        IndexSort.improveInsertSort(data)
        assertArrayEquals(result, this.data)
    }
}