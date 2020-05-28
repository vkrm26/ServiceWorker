package `in`.softcrunch.serviceworker

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import java.util.concurrent.Executors

class ServiceWorker(val name : String) {

    var threadPoolExecutor = Executors.newSingleThreadExecutor()


    var handler = object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.obj != null) {
                var pair = msg.obj as TaskResult<Any>
                pair.task.onTaskComplete(pair.result)
            }
        }

    }

    fun <T> addTask(task: Task<T>) {
        threadPoolExecutor.execute {
            Log.d("App" , name + " --- executing request....")
            var result = task.onExecuteTask()
            handler.obtainMessage(1, TaskResult(task, result)).sendToTarget()
            Log.d("App" , name + " --- executing response....")
        }
    }



}