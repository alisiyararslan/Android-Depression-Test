package com.alisiyararslan.depressiontest.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alisiyararslan.depressiontest.model.Test


@Database(entities = [Test::class],version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class TestDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao
}