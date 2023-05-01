package fr.alefaux.pollochon.core.network

import fr.alefaux.pollochon.core.model.DataResponse

interface HelloNetworkDataSource {
    suspend fun sayHello(): DataResponse<Nothing>
}
