package site.ylan.k12_materialdesign.utils

import android.content.Context
import android.widget.Toast

fun String.showToastShort(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun Int.showToastShort(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.showToastLong(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun Int.showToastLong(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}