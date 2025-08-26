package com.trustledger.aitrustledger.models

data class LevelCondition(
    val level: Int,
    val minInvestment: Double,
    val activeMembers: Int,
    val directBusiness: Double,
    val groupSell: Double
)
