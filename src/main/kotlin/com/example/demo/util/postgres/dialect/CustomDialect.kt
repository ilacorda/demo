package com.example.demo.util.postgres.dialect

import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.array.StringArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.dialect.PostgreSQL10Dialect
import java.sql.Types

class CustomDialect : PostgreSQL10Dialect {
    constructor() : super() {
        this.registerHibernateType(Types.OTHER, StringArrayType::class.java.name)
        this.registerHibernateType(Types.OTHER, IntArrayType::class.java.name)
        this.registerHibernateType(Types.OTHER, JsonStringType::class.java.name)
        this.registerHibernateType(Types.OTHER, JsonBinaryType::class.java.name)
        this.registerHibernateType(Types.OTHER, JsonNodeBinaryType::class.java.name)
        this.registerHibernateType(Types.OTHER, JsonNodeStringType::class.java.name)
    }
}