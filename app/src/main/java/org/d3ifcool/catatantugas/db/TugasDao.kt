package org.d3ifcool.catatantugas.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TugasDao {

    @Insert
    fun insert(tugas: TugasEntity)
}