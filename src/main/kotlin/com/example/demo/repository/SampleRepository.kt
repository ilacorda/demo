package com.example.demo.repository

import com.example.demo.entity.SampleEntity
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*

interface SampleRepository : JpaRepository<SampleEntity, Long> {
}