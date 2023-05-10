package fr.alefaux.pollochon.core.network.retrofit

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurvey
import fr.alefaux.pollochon.core.network.HomeNetworkDataSource
import fr.alefaux.pollochon.core.network.model.HomeSurveyApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header

private interface HomeService {
    @GET("/home")
    suspend fun getHomeSurveys(
        @Header("userId") userId: Int
    ): Response<HomeSurveyApi>
}

class HomeNetwork(
    retrofit: Retrofit
) : HomeNetworkDataSource {

    private val networkApi = retrofit.create(HomeService::class.java)

    override suspend fun getHomeData(userId: Int): DataResponse<HomeSurvey> {
        val response = networkApi.getHomeSurveys(userId)
        return when (response.code()) {
            200 -> {
                val data = response.body()

                return if (data != null) {
                    DataResponse.Success(data.toHomeSurvey())
                } else {
                    DataResponse.Unknown
                }
            }

            404 -> DataResponse.NotFound
            else -> DataResponse.Unknown
        }
    }
}
