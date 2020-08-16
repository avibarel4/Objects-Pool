package com.avi.objectspool

import android.util.Log
import com.avi.objectspool.models.TestObject

class PoolTester {

    private val availableItems = mutableSetOf<TestObject>()

    @Synchronized
    fun get():TestObject {
        availableItems.firstOrNull()?.let {
            availableItems.remove(it)

            Log.e("TEST_POOL", "REUSE ${it.hashCode()}")
            return it
        }

        Log.e("TEST_POOL", "CREATE A NEW ITEM")

        val newItem = object : TestObject() {
            protected fun finalize() {
                Log.e("TEST_POOL", "Finalize Called for ${this.hashCode()}")
                availableItems.add(this)
            }
        }

        return newItem
    }

    fun getAvailableItemsCount() = availableItems.size

}