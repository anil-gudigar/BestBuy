package com.bestbuy.storelocator.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bestbuy.storelocator.data.model.Store

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
@Dao
interface StoreDao {

    @Query("SELECT * FROM store")
    fun getStore(): LiveData<List<Store>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(storeList: List<Store>)
}