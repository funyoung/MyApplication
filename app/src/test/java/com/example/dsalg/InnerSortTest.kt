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

    @Test
    fun shellSort_correct() {
        InnerSort.shellSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun hibbardShellSort_correct() {
        InnerSort.hibbardShellSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun selectSort_correct() {
        InnerSort.selectSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun quickSort_correct() {
        InnerSort.quickSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun mergeSort_correct() {
        InnerSort.mergeSort(data)
        assertArrayEquals(result, data)
    }

    @Test
    fun bucketSort_correct() {
        val array = intArrayOf(7, 3, 8, 9, 6, 1, 8, 1, 2)
        val expected = intArrayOf(1, 1, 2, 3, 6, 7, 8, 8, 9)
        InnerSort.bucketSort(array, 10)
        assertArrayEquals(expected, array)
    }

    @Test
    fun lsdRadixSort_correct() {
        val array = intArrayOf(97, 53, 88, 59, 26, 41, 88, 31, 22)
        val expected = intArrayOf(22, 26, 31, 41, 53, 59, 88, 88, 97)
        InnerSort.lsdRadixSort(array, 2, 10)
        assertArrayEquals(expected, array)
    }
}