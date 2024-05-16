package site.ylan.k07_filedb.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class BookDataBaseHelper(
    private val context: Context,
    private val name: String,
    private val version: Int
) :
    SQLiteOpenHelper(context, name, null, version) {

    // 数据库表创建脚本
    private val createBook = "create table Book (" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)"
    // 数据库表创建脚本
    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase) {
        // 创建数据库表逻辑
        db.execSQL(createBook)
        db.execSQL(createCategory)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 升级数据库表逻辑
        // 删除旧表
        db.execSQL("drop table if exists Book")
        db.execSQL("drop table if exists Category")
        // 重新创建表
        onCreate(db)
    }

}