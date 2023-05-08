package fr.alefaux.pollochon.core.domain.hello

import fr.alefaux.pollochon.core.data.repository.hello.HelloRepository
import fr.alefaux.pollochon.core.model.DataResponse

class SayHelloUseCaseImpl(
    private val helloRepository: HelloRepository
) : SayHelloUseCase {
    override suspend fun invoke(): DataResponse<Unit> {
        return helloRepository.sayHello()
    }
}
