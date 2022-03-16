package com.yongjincompany.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yongjincompany.data.local.entity.MyProfileRoomEntity
import com.yongjincompany.data.local.entity.TodayCommitRoomEntity
import com.yongjincompany.data.local.entity.WeeklyCommitRoomEntity
import com.yongjincompany.data.local.entity.YearCommitRoomEntity

@Dao
interface HomeDao {
    @Query("SELECT * FROM myProfile")
    suspend fun fetchGithubProfile(): MyProfileRoomEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyProfile(myProfileRoomEntity: MyProfileRoomEntity)

    @Query("SELECT * FROM todayCommit")
    suspend fun fetchDayCommit(): TodayCommitRoomEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayCommit(todayCommitRoomEntity: TodayCommitRoomEntity)

    @Query("SELECT * FROM weekCommit")
    suspend fun fetchWeekCommit(): WeeklyCommitRoomEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeekCommit(weeklyCommitRoomEntity: WeeklyCommitRoomEntity)

    @Query("SELECT * FROM yearCommit")
    suspend fun fetchYearCommit(): YearCommitRoomEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertYearCommit(yearCommitRoomEntity: YearCommitRoomEntity)
}