package fr.alefaux.pollochon.core.network.retrofit

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.network.HelloNetworkDataSource
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

private interface HelloService {
    @GET("/")
    suspend fun sayHello(): Response<Unit>
}

class HelloNetwork(
    retrofit: Retrofit
) : HelloNetworkDataSource {
    private val networkApi = retrofit.create(HelloService::class.java)

    override suspend fun sayHello(): DataResponse<Nothing> {
        return if (networkApi.sayHello().isSuccessful) {
            DataResponse.Success
        } else {
            DataResponse.Error
        }
    }
}
