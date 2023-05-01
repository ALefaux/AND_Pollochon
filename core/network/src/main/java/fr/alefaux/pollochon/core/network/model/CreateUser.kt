package fr.alefaux.pollochon.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUser(
    val pseudo: String,
    val firebaseId: String
)
