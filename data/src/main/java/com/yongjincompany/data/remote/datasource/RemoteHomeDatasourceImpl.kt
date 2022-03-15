package com.yongjincompany.data.remote.datasource

import com.yongjincompany.data.remote.api.HomeApi
import com.yongjincompany.data.remote.response.MyProfileResponse
import com.yongjincompany.data.remote.response.TodayCommitResponse
import com.yongjincompany.data.remote.response.WeeklyCommitResponse
import com.yongjincompany.data.util.HttpHandler
import javax.inject.Inject

class RemoteHomeDatasourceImpl @Inject constructor(
    private val homeApi: HomeApi
) : RemoteHomeDataSource {
    override suspend fun fetchGithubProfile(userId: String): MyProfileResponse =
        HttpHandler<MyProfileResponse>()
            .httpRequest { homeApi.fetchGithubProfile(userId) }
            .sendRequest()

    override suspend fun fetchDayCommit(userName: String): TodayCommitResponse =
        HttpHandler<TodayCommitResponse>()
            .httpRequest { homeApi.fetchDayCommit(userName) }
            .sendRequest()

    override suspend fun fetchWeekCommit(userName: String): WeeklyCommitResponse =
        HttpHandler<WeeklyCommitResponse>()
            .httpRequest { homeApi.fetchWeekCommit(userName) }
            .sendRequest()
}