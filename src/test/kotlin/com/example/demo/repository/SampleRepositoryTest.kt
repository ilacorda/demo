package com.example.demo.repository

import com.example.demo.DbTestInitializer
import com.example.demo.entity.SampleEntity
import com.example.demo.pojo.SamplePojo
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
    lateinit var sampleRepository: SampleRepository

    lateinit var dto: SamplePojo
    lateinit var entity: SampleEntity

    @Before
    fun setUp() {
        dto = SamplePojo("Test", true)
        entity = SampleEntity(null,
                "POJO",
                dto.toMap()
        )
    }

    @Test
    fun createPojo() {
        val id = sampleRepository.save(entity).id!!
        assertNotNull(sampleRepository.getOne(id))
        assertEquals(sampleRepository.getOne(id).data?.let { SamplePojo(it) }, dto)
    }

}