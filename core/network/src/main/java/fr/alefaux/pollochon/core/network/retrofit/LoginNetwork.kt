package fr.alefaux.pollochon.core.network.retrofit

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User
import fr.alefaux.pollochon.core.network.LoginNetworkDataSource
import fr.alefaux.pollochon.core.network.model.CreateUser
import fr.alefaux.pollochon.core.network.model.UserApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

private interface LoginService {
    @GET("/users/exists")
    suspend fun checkUserExists(
        @Query("id") firebaseId: String
    ): Response<UserApi>

    @POST("/users ")
    suspend fun createUser(
        @Body createUser: CreateUser
    ): Response<UserApi>
}

class LoginNetwork(
    retrofit: Retrofit
) : LoginNetworkDataSource {

    private val networkApi = retrofit.create(LoginService::class.java)

    override suspend fun checkUserExists(firebaseId: String): DataResponse<User> {
        val response = networkApi.checkUserExists(firebaseId)
        return when (response.code()) {
            200 -> {
                val data = response.body()

                return if (data != null) {
                    DataResponse.Found(data.toUser())
                } else {
                    DataResponse.Unknown
                }
            }

            404 -> DataResponse.NotFound
            else -> DataResponse.Unknown
        }
    }

    override suspend fun createUser(firebaseId: String, pseudo: String): DataResponse<User> {
        val createUser = CreateUser(pseudo, firebaseId)
        val response = networkApi.createUser(createUser)

        return when (response.code()) {
            201 -> {
                val data = response.body()

                return if (data != null) {
                    DataResponse.Success(data.toUser())
                } else {
                    DataResponse.Unknown
                }
            }

            400 -> DataResponse.BadRequest(null)
            409 -> DataResponse.Conflict
            else -> DataResponse.Unknown
        }
    }
}
