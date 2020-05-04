package com.example.demo.repository

import com.example.demo.entity.SampleMapEntity
import org.springframework.data.jpa.repository.JpaRepository;

interface SampleMapRepository :  JpaRepository<SampleMapEntity, Long>{
}