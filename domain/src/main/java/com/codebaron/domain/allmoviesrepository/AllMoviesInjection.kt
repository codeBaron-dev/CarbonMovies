package com.codebaron.domain.allmoviesrepository

import com.codebaron.domain.repositories.BaseEndPoints
import com.codebaron.domain.repositories.RepositoriesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 * @see RepositoriesManager
 * @see AllMoviesRepositoryImplementation
 * @see BaseEndPoints
 */
@Module
@InstallIn(SingletonComponent::class)
object AllMoviesInjection {

    @Singleton
    @Provides
    fun providesOtpRepository(baseEndPoints: BaseEndPoints): RepositoriesManager =
        AllMoviesRepositoryImplementation(baseEndPoints)
}