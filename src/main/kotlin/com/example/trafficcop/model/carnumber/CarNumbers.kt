package com.example.trafficcop.model.carnumber

import javax.persistence.*

@Entity
@Table(name = "t_car_numbers")
data class CarNumbers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var userId: Long = 0L,

    /** Номер */
    @Column(name = "number", length = 14)
    var number: String = "",
)
