package fr.alefaux.pollochon.core.data.repository.hello

import fr.alefaux.pollochon.core.model.DataResponse

interface HelloRepository {
    suspend fun sayHello(): DataResponse<Nothing>
}
