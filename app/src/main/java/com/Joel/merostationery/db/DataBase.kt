package com.Joel.merostationery.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.Joel.merostationery.dao.UserDAO
import com.Joel.merostationery.entity.Product


@Database(
    entities = [(Product::class)],
    version = 1
)
abstract class DataBase:RoomDatabase() {
    abstract fun getUserDAO(): UserDAO


    companion object{
        @Volatile
        private var instance: DataBase?=null
        fun getInstance(context: Context): DataBase {
            if(instance == null){
                synchronized(DataBase::class.java){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private  fun buildDatabase(context: Context): DataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "StationaryShop"
            ).build()
        }
    }
}


