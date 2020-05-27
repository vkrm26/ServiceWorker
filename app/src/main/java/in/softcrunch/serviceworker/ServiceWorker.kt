package `in`.softcrunch.serviceworker

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Message
import java.util.concurrent.Executors

class ServiceWorker(val name : String) {

    var threadPoolExecutor = Executors.newSingleThreadExecutor()


    var handler = object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.obj != null) {
                var pair = msg.obj as Pair<Any, Any>

                (pair.first as Task<Any>).onTaskComplete(pair.second)
            }
        }

    }

    fun addTask(task: Task<Bitmap>) {
        threadPoolExecutor.execute {
            var result = task.onExecuteTask()

            var message = Message()
            message.obj = task
            handler.obtainMessage(1, Pair(task, result)).sendToTarget()
        }
    }



}