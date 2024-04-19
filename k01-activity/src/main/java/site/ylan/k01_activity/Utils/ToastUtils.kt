package site.ylan.k01_activity.Utils

import android.content.Context
import android.widget.Toast

//object ToastUtils {
//    fun show(ctx: Context?, desc: String?) {
//        Toast.makeText(ctx, desc, Toast.LENGTH_SHORT).show()
//    }
//}

class ToastUtils {
    companion object{
        @JvmStatic
        fun show(ctx: Context?, desc: String?) {
            Toast.makeText(ctx, desc, Toast.LENGTH_SHORT).show()
        }
    }
}