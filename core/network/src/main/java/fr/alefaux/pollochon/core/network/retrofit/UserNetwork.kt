package fr.alefaux.pollochon.core.network.retrofit

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User
import fr.alefaux.pollochon.core.network.UserNetworkDataSource
import fr.alefaux.pollochon.core.network.model.CreateUser
import fr.alefaux.pollochon.core.network.model.UserApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private interface UserService {
    @GET("/users/exists")
    suspend fun checkUserExists(
        @Query("id") firebaseId: String
    ): Response<UserApi>

    @POST("/users ")
    suspend fun createUser(
        @Body createUser: CreateUser
    ): Response<UserApi>

    @GET("/users/{id}/friends")
    suspend fun getFriendsByUserId(
        @Path(value = "id") userId: Int
    ): Response<List<UserApi>>
}

class UserNetwork(
    retrofit: Retrofit
) : UserNetworkDataSource {

    private val networkApi = retrofit.create(UserService::class.java)

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

    override suspend fun getFriendsByUserId(userId: Int): DataResponse<List<User>> {
        val response = networkApi.getFriendsByUserId(userId)
        return when (response.code()) {
            404 -> DataResponse.NotFound
            200 -> {
                val data = response.body()

                return if (data != null) {
                    DataResponse.Success(data.map { it.toUser() })
                } else {
                    DataResponse.Unknown
                }
            }
            else -> DataResponse.Unknown
        }
    }
}
