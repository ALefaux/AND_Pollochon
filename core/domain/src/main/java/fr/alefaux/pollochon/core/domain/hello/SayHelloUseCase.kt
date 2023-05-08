package fr.alefaux.pollochon.core.domain.hello

import fr.alefaux.pollochon.core.model.DataResponse

interface SayHelloUseCase {
    suspend fun invoke(): DataResponse<Unit>
}
