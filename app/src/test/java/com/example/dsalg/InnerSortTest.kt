package com.example.dsalg

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class InnerSortTest {
    private val result = arrayOf(12, 29, 32, 34, 34, 45, 64, 78)
    private val data = arrayOf(45, 34, 78, 12, 34, 32, 29, 64)

    @Before
    fun setup() {
        data.shuffle()
    }

    @Test
    fun improveInsertSort_correct() {
        InnerSort.improveInsertSort(data)
        assertEquals(result, data)
    }
}