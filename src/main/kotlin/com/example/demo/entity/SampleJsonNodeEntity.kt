package com.example.demo.entity

import com.fasterxml.jackson.databind.JsonNode
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.*

@Entity
@Table(name = "tests")
@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
data class SampleJsonNodeEntity (
        @Id @GeneratedValue
        val id: Long?,
        val name: String?,

        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        var data: JsonNode?
) {

    /**
     * Dependently on use-case this can be done differently:
     * https://stackoverflow.com/questions/37873995/how-to-create-empty-constructor-for-data-class-in-kotlin-android
     */
    constructor(): this(null, null, null)
}