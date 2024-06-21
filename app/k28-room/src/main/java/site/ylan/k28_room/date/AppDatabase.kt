package site.ylan.k28_room.date

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import site.ylan.k28_room.date.dao.BookDao
import site.ylan.k28_room.date.dao.UserDao
import site.ylan.k28_room.date.model.Book
import site.ylan.k28_room.date.model.User

@Database(version = 3, entities = [User::class, Book::class])
abstract class AppDatabase : RoomDatabase() {

    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book (id integer primary key autoincrement not null, name text not null, pages integer not null)")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }
        }

        // AppDatabase实例
        private var instance: AppDatabase? = null

        @Synchronized
        fun getAppDatabaseInstance(context: Context): AppDatabase {
            instance?.let { return it }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build().apply { instance = this }
        }
    }

    // userDao
    abstract fun userDao(): UserDao

    // bookDao
    abstract fun bookDao(): BookDao
}