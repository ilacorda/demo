package com.example.demo.pojo

import java.io.Serializable

data class SamplePojo(
        val payload: String,
        val flag: Boolean
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SamplePojo) return false

        if (payload != other.payload) return false
        if (flag != other.flag) return false

        return true
    }

    override fun hashCode(): Int {
        var result = payload.hashCode()
        result = 31 * result + payload.hashCode()
        return result
    }

    override fun toString(): String {
        return "SamplePojo(payload='$payload', flag=$flag)"
    }
}