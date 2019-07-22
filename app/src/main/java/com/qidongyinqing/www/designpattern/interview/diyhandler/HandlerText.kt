package cn.com.almostlover.interview.diyhandler

import java.util.*

class HandlerText {


    companion object{

        fun test(){


                Looper.prepare()
                val handler = object : Handler() {
                    fun handleMessage(message: Message) {
                        System.out.println( "main thread recv message------" + message.obj.toString())
                    }
                }

                for (i in 0..99) {
                    Thread(Runnable {
                        val msg = Message()

                            msg.obj = UUID.randomUUID().toString()
                        System.out.println("sup thread " + Thread.currentThread().name + ": send message------" + msg.obj)
                        handler.sendMessage(msg)
                    }).start()
                }
                Looper.loop()
            }

        }



}