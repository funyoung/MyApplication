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
        assertArrayEquals(result, this.data)
    }

    @Test
    fun improveBubbleSort_correct() {
        InnerSort.improveBubbleSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun heapSort_correct() {
        InnerSort.heapSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun swapInsertSort_correct() {
        InnerSort.swapInsertSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun improveInsertSortRight_correct() {
        InnerSort.improveInsertSortRight(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun improveInsertSortOpt_correct() {
        InnerSort.improveInsertSortOpt(data)
        assertArrayEquals(result, data)
    }

}