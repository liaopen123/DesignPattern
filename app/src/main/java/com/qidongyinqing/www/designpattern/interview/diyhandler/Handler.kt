package cn.com.almostlover.interview.diyhandler

open class Handler{

    var mLooper:Looper
    var mQueue :MessageQueue

    constructor() {
        this.mLooper = Looper.myLooper()
        this.mQueue = mLooper.mQueue
    }

    fun sendMessage( msg:Message){
        msg.target = this
        mQueue.enqueueMessage(msg)
    }


    fun handlerMessage(msg:Message){

    }


    fun dispatchMessage(msg:Message){
        handlerMessage(msg)

    }
}