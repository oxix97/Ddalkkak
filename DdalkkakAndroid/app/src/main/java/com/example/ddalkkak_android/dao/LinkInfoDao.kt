package com.example.ddalkkak_android.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ddalkkak_android.data.LinkInfo

@Dao
interface LinkInfoDao {
    @Query("select * from linkinfo")
    suspend fun getAll() : List<LinkInfo>

    @Insert
    suspend fun insert(link: LinkInfo)

    @Delete
    suspend fun delete(link : LinkInfo)
}