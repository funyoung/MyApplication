package com.example.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Simple {
    /// 吐出3个数，每过100毫秒吐一个
    fun buffering() : Flow<Int> = flow {
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }
}