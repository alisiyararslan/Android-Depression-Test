package com.alisiyararslan.depressiontest.roomdb

import androidx.room.*
import com.alisiyararslan.depressiontest.model.Test
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TestDao {
    @Query("SELECT * FROM Test")
    fun getAll(): Flowable<List<Test>>

    @Insert
    fun insert(test: Test) : Completable

    @Delete
    fun delete(test: Test) : Completable

    @Update
    fun update(test: Test) : Completable
}