package fr.alefaux.pollochon.core.data.repository.hello

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.network.HelloNetworkDataSource

class HelloRepositoryImpl(
    private val helloNetworkDataSource: HelloNetworkDataSource
) : HelloRepository {
    override suspend fun sayHello(): DataResponse<Nothing> {
        return helloNetworkDataSource.sayHello()
    }
}
