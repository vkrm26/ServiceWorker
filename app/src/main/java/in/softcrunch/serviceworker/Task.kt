package `in`.softcrunch.serviceworker

interface Task<Any> {
    fun onExecuteTask(): Any
    fun onTaskComplete(t : Any)
}