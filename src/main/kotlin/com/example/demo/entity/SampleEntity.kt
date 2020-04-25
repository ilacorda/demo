package com.example.demo.entity

import com.example.demo.pojo.SamplePojo
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

data class SampleEntity (
    @Id @GeneratedValue
    val id: Long,
    val name: String,
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    var data: SamplePojo
    ) : AbstractJpaPersistable<Long>() {

}