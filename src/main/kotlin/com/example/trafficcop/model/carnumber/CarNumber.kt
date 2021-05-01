package com.example.trafficcop.model.carnumber

import javax.persistence.*

@Entity
@Table(name = "t_car_numbers")
data class CarNumber(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var userId: Long = 0L,

    /** Номер */
    @Column(name = "number", length = 14, unique = true, nullable = false)
    var number: String = "",
)
