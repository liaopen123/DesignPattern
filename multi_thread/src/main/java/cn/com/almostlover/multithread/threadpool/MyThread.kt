package cn.com.almostlover.multithread.threadpool

class MyThread(name:String) : Runnable {

    protected var  name :String = name

    override fun run() {
        try {
            Thread.sleep(100)
            println("name:$name")
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }

}