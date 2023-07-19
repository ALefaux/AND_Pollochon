package fr.alefaux.pollochon.feature.survey.create.di

import fr.alefaux.pollochon.feature.survey.create.CreateSurveyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val createSurveyModule = module {
    viewModel { CreateSurveyViewModel() }
}
