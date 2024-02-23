package com.example.ddalkkak_android.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ddalkkak_android.data.LinkInfo

@Database(
    entities = [
        LinkInfo::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun linkInfoDao(): LinkInfoDao
}