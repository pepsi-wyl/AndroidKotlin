package site.ylan.k07_filedb.activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import site.ylan.k07_filedb.R
import site.ylan.k07_filedb.db.BookDataBaseHelper
import java.lang.NullPointerException

class DbActivity : AppCompatActivity() {

    private lateinit var dataBaseHelper: BookDataBaseHelper
    private lateinit var writableDatabase: SQLiteDatabase
    private lateinit var readableDatabase: SQLiteDatabase

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        dataBaseHelper = BookDataBaseHelper(this, "BookStore.db", 2)

        findViewById<Button>(R.id.createConnectDatabase).setOnClickListener {
            // 可写的数据库连接对象
            writableDatabase = dataBaseHelper.writableDatabase
            // 可读的数据库连接对象
            readableDatabase = dataBaseHelper.readableDatabase
        }

        findViewById<Button>(R.id.addData).setOnClickListener {
            // 返回新插入行的行 ID，如果发生错误，则为 -1
            val result1 = writableDatabase.insert("Book", null,
                ContentValues().apply {
                    put("name", "The Da Vinci Code")
                    put("author", "Dan Brown")
                    put("pages", 454)
                    put("price", 16.96)
                })
            // 返回新插入行的行 ID，如果发生错误，则为 -1
            val result2 = writableDatabase.insert("Book", null,
                ContentValues().apply {
                    put("name", "The Lost Symbol")
                    put("author", "Dan Brown")
                    put("pages", 510)
                    put("price", 19.95)
                }
            )

//            writableDatabase.execSQL(
//                "insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
//                arrayOf("The Da Vinci Code", "Dan Brown", "454", "16.96")
//            )
//            writableDatabase.execSQL(
//                "insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
//                arrayOf("The Lost Symbol", "Dan Brown", "510", "19.95")
//            )

            Log.i("TAG", "addData: $result1 + $result2")
        }

        findViewById<Button>(R.id.updateData).setOnClickListener {
            // 返回受影响的行数
            val update = writableDatabase.update(
                "Book",
                ContentValues().apply {
                    put("price", 10.99)
                },
                "name = ?",
                arrayOf("The Da Vinci Code")
            )

//            writableDatabase.execSQL(
//                "update Book set price = ? where name = ?",
//                arrayOf("10.99", "The Da Vinci Code")
//            )

            Log.i("TAG", "updateData: $update")
        }

        findViewById<Button>(R.id.deleteData).setOnClickListener {
            // 如果传入 whereClause，则受影响的行数，否则为 0。若要删除所有行并获取计数，请将“1”作为 whereClause。
            val delete = writableDatabase.delete("Book", "pages > ?", arrayOf("500"))

//            writableDatabase.execSQL("delete from Book where pages > ?", arrayOf("500"))

            Log.i("TAG", "deleteData: $delete")
        }

        findViewById<Button>(R.id.queryData).setOnClickListener {
            val cursor = writableDatabase.query("Book", null, null, null, null, null, null)
//            val cursor = writableDatabase.rawQuery("select * from Book", null)

            // 数据指针移动到第一行
            if (cursor.moveToFirst()) {
                do {
                    // 遍历Cursor对象，取出数据并打印
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("TAG", "book name is $name")
                    Log.d("TAG", "book author is $author")
                    Log.d("TAG", "book pages is $pages")
                    Log.d("TAG", "book price is $price")
                } while (cursor.moveToNext())
            }
            // 关闭Cursor对象
            cursor.close()
        }

        findViewById<Button>(R.id.replaceData).setOnClickListener {

            try {
                // 开启事务
                writableDatabase.beginTransaction()
                // 1。删除数据
                writableDatabase.delete("Book", null, null)

                // 异常
//                throw NullPointerException()

                // 2。插入数据
                writableDatabase.insert("Book", null,
                    ContentValues().apply {
                        put("name", "Game of Thrones")
                        put("author", "George Martin")
                        put("pages", 720)
                        put("price", 20.85)
                    }
                )
                // 3。提交事务
                writableDatabase.setTransactionSuccessful()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            } finally {
                // 4。结束事务
                writableDatabase.endTransaction()
            }
        }


    }


}
