package cn.com.almostlover.interview.diyhandler

class Looper {
    companion object {
        var sThreadLocal: ThreadLocal<Looper> = ThreadLocal();

        fun prepare(){
            if (sThreadLocal.get()!=null) {
                throw  RuntimeException("error")
            }

            sThreadLocal.set(Looper());
        }

        fun myLooper():Looper{

            return  sThreadLocal.get()
        }

        fun loop(){
          var   me:Looper = myLooper()

            val queue = me.mQueue
            var msg :Message?

            while (true) {
                msg  = queue.next()
                if(msg==null||msg.target==null){
                    continue
                }
                msg.target?.dispatchMessage(msg)

            }

        }

    }

    var mQueue: MessageQueue = MessageQueue()



}