package com.bestbuy.storelocator.data.db

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.bestbuy.storelocator.data.local.StoreDao
import com.bestbuy.storelocator.data.model.Store

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */

@Database(
    entities = [Store::class],
    version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class StoresDatabase: RoomDatabase() {

    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var instance: StoresDatabase? = null

        fun getInstance(context: Context): StoresDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): StoresDatabase {
            return Room.databaseBuilder(context, StoresDatabase::class.java, "store-db")
                .addCallback(object : RoomDatabase.Callback() {
                })
                .build()
        }
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}
