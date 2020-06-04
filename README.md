##Demo to work with Hibernate Types

This repository shows the use of [hibernate-types](https://github.com/vladmihalcea/high-performance-java-persistence)
and in particular the mapping of JSONB data type in Postgres with Hibernate and JPA. 

The project is a Gradle one and it uses the following Hibernate Type dependency: 

```com.vladmihalcea:hibernate-types-52:2.5.0```

It consists of the following main packages: 

* ```com.example.demo``` including the bootstrap StringBoot class
* ```com.example.demo.entity``` holding the Sample Entity and an abstract Hibernate class to deal with ID, equals, toString and hashCode.
* ```com.example.demo.pojo``` including the PoJo class for the JSON properties
* ```com.example.demo.repository``` including the Repository
* ````com.example.demo.util.postgres.dialect```` including the custom dialect for Postgres



##References
[Mapping JSON collections using JPA and Hibernate](https://vladmihalcea.com/how-to-map-json-collections-using-jpa-and-hibernate/)
[Resolving Hibernate No Dialect Mapping - Hibernate Types](https://vladmihalcea.com/hibernate-no-dialect-mapping-for-jdbc-type/)

