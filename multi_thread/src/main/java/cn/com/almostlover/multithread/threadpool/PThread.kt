package cn.com.almostlover.multithread.threadpool


class PThread(target: Runnable, name: String, pool: ThreadPool) : Thread(name) {

    var pool: ThreadPool = pool
    var target: Runnable
    var isShutdown: Boolean = false
    var isIdle = false

    init {
        this.target = target
    }

    override fun run() {
        isIdle = false
        if (target != null) {
            //运行任务
            target.run()
        }
        //任务结束了 到闲置模式
        isIdle = true
        try {
            //该任务结束了  不关闭线程 而是翻入线程池空闲队列
            pool.repool(this)
            synchronized(this) {
            }
        } catch (e: InterruptedException) {

        }
        isIdle = false

    }
    @Synchronized
    fun setTarget1(newTarget:Runnable){
            target = newTarget
    }

    //关闭线程
    fun shutdown(){
        isShutdown = true

    }

}