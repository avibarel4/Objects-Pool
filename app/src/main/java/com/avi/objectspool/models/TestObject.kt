package com.avi.objectspool.models

open class TestObject {
    override fun toString(): String {
        return super.toString().split('@').lastOrNull() + " - HashCode: ${this.hashCode()}"
    }
}