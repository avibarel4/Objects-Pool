package com.avi.objectspool

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val poolTester = PoolTester()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        buttonICreateItem.setOnClickListener {
            createItem()
        }

        val first = poolTester.get()
        Log.i("TEST_POOL", "First: $first")
        val second = poolTester.get()
        Log.i("TEST_POOL", "Second: $second")
        val third = poolTester.get()
        Log.i("TEST_POOL", "Third: $third")
    }

    private fun createItem() {
        val item = poolTester.get()
        Log.i("TEST_POOL", "New Item: $item")

        textAvailableItems.text = "Items: ${poolTester.getAvailableItemsCount()}"
    }
}