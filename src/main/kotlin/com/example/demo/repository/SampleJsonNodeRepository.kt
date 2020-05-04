package com.example.demo.repository

import com.example.demo.entity.SampleJsonNodeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SampleJsonNodeRepository: JpaRepository<SampleJsonNodeEntity, Long> {
}