package com.example.trafficcop.model

import javax.persistence.*

@Entity
@Table(name = "t_numbers")
data class Numbers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var userId: Long = 0L,
)
