package com.example.demo.pojo

data class SamplePojo(
        val payload: String,
        val flag: Boolean
)  {
    constructor(map: Map<String, Any>) : this(map["payload"] as String, map["flag"] as Boolean)

    fun toMap() : Map<String, Any> {
        return mapOf("payload" to payload, "flag" to flag)
    }
}