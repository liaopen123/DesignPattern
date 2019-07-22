package cn.com.almostlover.interview.diyhandler

class Message {


    var what:Int = 0
    var arg1:Int = 0
    var arg2:Int = 0
    lateinit var obj : Any
    lateinit var target: Handler

    override fun toString(): String {
        return obj.toString()
    }



}