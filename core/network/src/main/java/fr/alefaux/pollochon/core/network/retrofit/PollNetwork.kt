package fr.alefaux.pollochon.core.network.retrofit

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.ErrorResponse
import fr.alefaux.pollochon.core.network.PollNetworkDataSource
import fr.alefaux.pollochon.core.network.model.CreateSurveyApi
import fr.alefaux.pollochon.core.network.model.ErrorResponseApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

private interface PollService {
    @POST("/polls")
    suspend fun postSurvey(
        @Body createSurvey: CreateSurveyApi
    ): Response<Unit>
}

class PollNetwork(
    retrofit: Retrofit
): PollNetworkDataSource {

    private val networkApi = retrofit.create(PollService::class.java)

    override suspend fun postSurvey(createSurvey: CreateSurveyApi): DataResponse<Unit> {
        val response = networkApi.postSurvey(createSurvey)
        return when (response.code()) {
            201 -> DataResponse.Created
            400 -> {
                val errorMessage: ErrorResponse? = response.errorBody()?.string()?.let { json ->
                    Json.decodeFromString<ErrorResponseApi>(json)
                }?.toDomain()

                DataResponse.BadRequest(errorMessage)
            }
            404 -> DataResponse.NotFound
            else -> DataResponse.Unknown
        }
    }
}
