package com.alisiyararslan.depressiontest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.alisiyararslan.depressiontest.roomdb.DateTypeConverter
import java.util.*

@Entity
class Test(

    var testScore:Int,

    @TypeConverters(DateTypeConverter::class)
    var date: Date,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}