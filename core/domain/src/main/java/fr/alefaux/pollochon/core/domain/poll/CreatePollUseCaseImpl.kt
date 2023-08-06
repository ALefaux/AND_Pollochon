package fr.alefaux.pollochon.core.domain.poll

import fr.alefaux.pollochon.core.data.repository.poll.PollRepository
import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class CreatePollUseCaseImpl(
    private val getUserUseCase: GetUserUseCase,
    private val pollRepository: PollRepository,
): CreatePollUseCase {
    override suspend operator fun invoke(
        title: String,
        type: SurveyType
    ): Flow<DataResponse<Unit>> {
        return getUserUseCase.getUser()
            .catch {
                val a = 42
            }
            .map { user ->
                pollRepository.postSurvey(title, type, user.id)
            }
    }
}