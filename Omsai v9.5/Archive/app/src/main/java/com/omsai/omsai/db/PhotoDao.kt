package com.omsai.omsai.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entity: List<Photo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: Photo)

    @Query("SELECT * FROM Photo")
    fun load(): List<Photo>

    @Query("SELECT * FROM Photo where isprinted='false'")
    fun loadNonPrinted(): List<Photo>

    @Query("SELECT * FROM Photo where isprinted=0 limit 1")
    fun loadPhotoForPrint(): Photo

    @Query("Delete FROM Photo")
    fun deleteCompanyDocument()

    @Query("SELECT * FROM Photo ORDER BY isprinted , time DESC")
    fun getAllPhotos(): Flow<List<Photo>>

    @Query("SELECT * FROM Photo where isPhoto='false' AND msg=:msg1 AND filename =:name")
    fun getMSG(msg1: String, name: String): Photo?

}