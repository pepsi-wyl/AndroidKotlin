package site.ylan.k09_medil

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.FileProvider
import site.ylan.k09_medil.databinding.ActivityCameraAlbumBinding
import java.io.File

class CameraAlbumActivity : AppCompatActivity() {

    private val binding: ActivityCameraAlbumBinding by lazy {
        ActivityCameraAlbumBinding.inflate(layoutInflater)
    }

    private val takePhotoRequestCode = 100001
    private val fromAlbumRequestCode = 100002
    private lateinit var imageUri: Uri
    private lateinit var outputImage: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // takePhotoBtn拍照
        binding.takePhotoBtn.setOnClickListener {

            // 创建File对象，用于存储拍照后的图片 getExternalCacheDir()得到应用关联缓存目录 路径为/sdcard/Android/data/<package name>/cache
            outputImage = File(externalCacheDir, "output_image.jpg")
            if (outputImage.exists()) outputImage.delete()
            outputImage.createNewFile()

            // 构建imageUri，运行设备的系统版本高于Android 7.0，使用本地真实路径的Uri被认为不安全
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // FileProvider是一种特殊的ContentProvider，使用了和ContentProvider类似的机制来对数据进行保护，可以选择性地将封装过的Uri共享给外部，从而提高了应用的安全性
                FileProvider.getUriForFile(
                    this,
                    "site.ylan.k09_medil.CameraAlbumActivity.fileprovider",
                    outputImage
                )
            } else {
                Uri.fromFile(outputImage)
            }

            // 启动相机程序
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, takePhotoRequestCode)
        }

        // fromAlbumBtn选取照片
        binding.fromAlbumBtn.setOnClickListener {
            // 打开文件选择器并只允许选择图片文件
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, fromAlbumRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            // 拍照
            takePhotoRequestCode -> {
                if (resultCode == Activity.RESULT_OK) {
                    // 将拍摄的照片显示出来
                    binding.imageView.setImageBitmap(
                        // 有些手机认为打开摄像头进行拍摄时手机应该是横屏的，因此回到竖屏的情况下就会发生90度的旋转
                        rotateIfRequired(
                            // 照片解析成Bitmap对象
                            BitmapFactory.decodeStream(
                                contentResolver.openInputStream(imageUri)
                            )
                        )
                    )
                }
            }
            // 选取照片
            fromAlbumRequestCode -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    data.data?.let { uri ->
                        // 将选择的照片显示出来
                        binding.imageView.setImageBitmap(
                            // 获取照片
                            getBitmapFromUri(uri)
                        )
                    }
                }
            }
        }
    }

    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation = exif.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL
        )
        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
            else -> bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedBitmap = Bitmap.createBitmap(
            bitmap, 0, 0, bitmap.width, bitmap.height,
            matrix, true
        )
        bitmap.recycle()
        return rotatedBitmap
    }

    private fun getBitmapFromUri(uri: Uri) =
        contentResolver.openFileDescriptor(uri, "r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }

}