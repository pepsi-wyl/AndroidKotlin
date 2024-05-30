//package site.ylan.k10_service
//
//import android.os.AsyncTask
//import android.widget.Toast
//
//class DownloadTask : AsyncTask<Unit, Int, Boolean>() {
//
//    // 后台任务开始执行之前调用，用于进行一些界面上的初始化操作
//    override fun onPreExecute() {
//        // 显示进度对话框
//        progressDialog.show()
//    }
//
//    // 执行具体的耗时任务
//    override fun doInBackground(vararg params: Unit?) = try {
//        while (true) {
//            // 这是一个虚构的方法
//            val downloadPercent = doDownload()
//            // 发布进度
//            publishProgress(downloadPercent)
//            if (downloadPercent >= 100) break
//        }
//        true
//    } catch (e: Exception) {
//        false
//    }
//
//    override fun onProgressUpdate(vararg values: Int?) {
//        // 更新下载进度
//        progressDialog.setMessage("Downloaded ${values[0]}%")
//    }
//
//    override fun onPostExecute(result: Boolean?) {
//        // 关闭进度对话框
//        progressDialog.dismiss()
//        // 在这里提示下载结果
//        if (result == true) {
//            Toast.makeText(context, "Download succeeded", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(context, " Download failed", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//}