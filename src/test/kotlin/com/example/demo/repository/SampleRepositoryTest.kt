package com.example.demo.repository

import com.example.demo.DbTestInitializer
import com.example.demo.entity.SampleJsonNodeEntity
import com.example.demo.entity.SampleMapEntity
import com.example.demo.pojo.SamplePojo
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration(initializers = [DbTestInitializer::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleRepositoryTest {

    @Autowired
    lateinit var sampleMapRepository: SampleMapRepository

    @Autowired
    lateinit var sampleJsonNodeRepository: SampleJsonNodeRepository

    lateinit var dto: SamplePojo
    lateinit var mapEntity: SampleMapEntity
    lateinit var jsonNodeEntity: SampleJsonNodeEntity

    @Before
    fun setUp() {
        dto = SamplePojo("Test", true)
        mapEntity = SampleMapEntity(null,
                "POJO1",
                dto.toMap()
        )

        jsonNodeEntity = SampleJsonNodeEntity(null,
            "POJO2",
                jacksonObjectMapper().valueToTree(dto)
        )
    }

    @Test
    fun createMapPojo() {
        val id = sampleMapRepository.save(mapEntity).id!!
        assertNotNull(sampleMapRepository.getOne(id))
        assertEquals(sampleMapRepository.getOne(id).data?.let { SamplePojo(it) }, dto)
    }

    @Test
    fun createJsonNodePojo() {
        val id = sampleJsonNodeRepository.save(jsonNodeEntity).id!!
        assertNotNull(sampleJsonNodeRepository.getOne(id))
        assertEquals(jacksonObjectMapper().treeToValue(sampleJsonNodeRepository.getOne(id).data, SamplePojo::class.java), dto)
    }

}