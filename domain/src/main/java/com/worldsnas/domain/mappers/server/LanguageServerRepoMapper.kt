package com.worldsnas.domain.mappers.server

import com.worldsnas.domain.repomodel.LanguageRepoModel
import com.worldsnas.domain.servermodels.LanguageServerModel
import com.worldsnas.panther.Mapper
import javax.inject.Inject

class LanguageServerRepoMapper @Inject constructor(
): Mapper<LanguageServerModel, LanguageRepoModel> {
    override fun map(item: LanguageServerModel): LanguageRepoModel =
        LanguageRepoModel(
            0,
            item.iso,
            item.name
        )
}