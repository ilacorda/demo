package com.example.demo.pojo

import junit.framework.Assert.assertEquals
import org.junit.Test

class SamplePojoTest {

    private val pojo = SamplePojo("Test", true)
    private var map = mapOf("payload" to "Test", "flag" to true)

    @Test
    fun toPojo() {
        assertEquals(pojo, SamplePojo(map))
    }

    @Test
    fun toMap() {
        assertEquals(map, pojo.toMap())
    }
}