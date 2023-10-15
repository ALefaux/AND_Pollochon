package fr.alefaux.pollochon.core.domain.poll

import fr.alefaux.pollochon.core.data.repository.poll.PollRepository
import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date

class CreatePollUseCaseImpl(
    private val getUserUseCase: GetUserUseCase,
    private val pollRepository: PollRepository,
): CreatePollUseCase {
    override suspend operator fun invoke(
        title: String,
        type: SurveyType,
        endDate: Date?,
        proposals: List<String>
    ): Flow<DataResponse<Unit>> {
        return getUserUseCase.getUser()
            .map { user ->
                pollRepository.postSurvey(title, type, user.id, endDate, proposals)
            }
    }
}