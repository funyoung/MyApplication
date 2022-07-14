package com.example.dsalg

import org.junit.Assert.*
import org.junit.Test

class InsertSortTest {
    @Test
    fun improveInsertSort_correct() {
        val data = arrayOf(45, 34, 78, 12, 34, 32, 29, 64)
        val result = arrayOf(12, 29, 32, 34, 34, 45, 64, 78)
        InsertSort.improveInsertSort(data)
        assertEquals(result, data)
    }
}