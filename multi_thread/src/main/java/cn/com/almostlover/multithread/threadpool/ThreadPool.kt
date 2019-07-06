package cn.com.almostlover.multithread.threadpool

class ThreadPool {


    //空闲的线程队列
    var idleThreads = ArrayList<PThread>(5)

    //已经有的线程总数
    var threadCounter: Int = 0

    var isShoutDown: Boolean = false;

    constructor() {
        threadCounter = 0
    }

    companion object {
        private var instance: ThreadPool? = null

        fun getInstance1(): ThreadPool {
            if (instance == null) {
                instance = ThreadPool()
            }
            return instance as ThreadPool
        }
    }

    fun getCreatedThreadsCount(): Int {
        return threadCounter
    }


    //将线程放入池中
    fun repool(repoolingThread: PThread) {
        if (!isShoutDown) {
            idleThreads.add(repoolingThread)
        } else {
            repoolingThread.shutdown()
        }
    }


    fun shutdown() {
        isShoutDown = true
        for ((index, item) in idleThreads.withIndex()) {
            item.shutdown()
        }
    }

    //执行任务
    fun start(target: Runnable) {
        var thread: PThread? = null
        //如果有空闲的 直接使用
        if (idleThreads.isNotEmpty()) {
            val lastIndex = idleThreads.size - 1
            thread = idleThreads.get(lastIndex)
            idleThreads.removeAt(lastIndex)
            //立即执行这个任务
            thread.setTarget1(target)

        } else {
            //没用空闲的
            threadCounter++
            thread = PThread(target, "PThread #$threadCounter", this);
            thread.start()

        }




    }
}