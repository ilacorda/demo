package com.example.demo.pojo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SamplePojo(
        val payload: String,
        val flag: Boolean
)  {
    constructor(map: Map<String, Any>) : this(map["payload"] as String, map["flag"] as Boolean)

    fun toMap() : Map<String, Any> {
        return mapOf("payload" to payload, "flag" to flag)
    }
}
