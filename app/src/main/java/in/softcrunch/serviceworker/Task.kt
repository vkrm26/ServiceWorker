package `in`.softcrunch.serviceworker

interface Task<T> {
    fun onExecuteTask(): T
    fun onTaskComplete(t : T)
}