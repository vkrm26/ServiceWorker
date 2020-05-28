package `in`.softcrunch.serviceworker

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.button1
import android.graphics.BitmapFactory
import kotlinx.android.synthetic.main.activity_main.button2
import kotlinx.android.synthetic.main.activity_main.img1
import kotlinx.android.synthetic.main.activity_main.img2
import okhttp3.OkHttpClient
import okhttp3.Request



class MainActivity : AppCompatActivity() {

    val IMAGE_1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg"
    val IMAGE_2 = "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var serviceWorker1 = ServiceWorker("first")
        var serviceWorker2 = ServiceWorker("second")


        button1.setOnClickListener {
            serviceWorker1.addTask(object : Task<Bitmap> {
                override fun onExecuteTask(): Bitmap {
                    val request = Request.Builder().url(IMAGE_1).build()
                    val response = OkHttpClient().newCall(request).execute()
                    return BitmapFactory.decodeStream(response.body?.byteStream())
                }

                override fun onTaskComplete(bitmap : Bitmap) {
                    img1.setImageBitmap(bitmap)
                }
            })

            serviceWorker1.addTask(object : Task<Bitmap> {
                override fun onExecuteTask(): Bitmap {
                    val request = Request.Builder().url(IMAGE_1).build()
                    val response = OkHttpClient().newCall(request).execute()
                    return BitmapFactory.decodeStream(response.body?.byteStream())
                }

                override fun onTaskComplete(bitmap : Bitmap) {
                    img1.setImageBitmap(bitmap)
                }
            })

            serviceWorker1.addTask(object : Task<Bitmap> {
                override fun onExecuteTask(): Bitmap {
                    val request = Request.Builder().url(IMAGE_1).build()
                    val response = OkHttpClient().newCall(request).execute()
                    return BitmapFactory.decodeStream(response.body?.byteStream())
                }

                override fun onTaskComplete(bitmap : Bitmap) {
                    img1.setImageBitmap(bitmap)
                }
            })

            serviceWorker1.addTask(object : Task<Bitmap> {
                override fun onExecuteTask(): Bitmap {
                    val request = Request.Builder().url(IMAGE_1).build()
                    val response = OkHttpClient().newCall(request).execute()
                    return BitmapFactory.decodeStream(response.body?.byteStream())
                }

                override fun onTaskComplete(bitmap : Bitmap) {
                    img1.setImageBitmap(bitmap)
                }
            })
        }

        button2.setOnClickListener {
            serviceWorker2.addTask(object : Task<Bitmap> {
                override fun onExecuteTask(): Bitmap {
                    val request = Request.Builder().url(IMAGE_2).build()
                    val response = OkHttpClient().newCall(request).execute()
                    return BitmapFactory.decodeStream(response.body?.byteStream())
                }

                override fun onTaskComplete(bitmap : Bitmap) {
                    img2.setImageBitmap(bitmap)
                }
            })
        }
    }
}
