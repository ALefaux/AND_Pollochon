package fr.alefaux.pollochon.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ProposalApi(
    val id: Int,
    val title: String
)
