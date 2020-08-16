package com.avi.objectspool

import com.avi.objectspool.models.TestObject

class Test {
    fun get(): TestObject {
        return object : TestObject() {
            protected fun finalize() {

            }
        }
    }
}