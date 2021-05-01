package com.example.trafficcop.module.carnumber.repository

import com.example.trafficcop.model.carnumber.CarNumber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarNumbersRepository : JpaRepository<CarNumber, Long>
