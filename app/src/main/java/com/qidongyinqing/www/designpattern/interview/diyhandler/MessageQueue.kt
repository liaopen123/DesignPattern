package cn.com.almostlover.interview.diyhandler

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class MessageQueue{


    companion object{
            var Tag :String = "MessageQueue"
        }

    var mItems : Array<Message?>
    internal var mPutIndex: Int = 0
    var mCount:Int = 0
    var mTakeIndex:Int = 0

    var mLock: Lock
    var mNotEmpty: Condition
    var mNotFull: Condition

    constructor(){
        mItems = arrayOfNulls<Message>(50)

        mLock = ReentrantLock()
        mNotEmpty = mLock.newCondition()
        mNotFull = mLock.newCondition()
    }


    fun next():Message?{
        var msg :Message? = null
        try {
           mLock.lock()
            while (mCount<=0){
             mNotEmpty.await()
                System.out.println("队列空了，进行阻塞")
            }

            msg = mItems[mTakeIndex]
            mItems[mTakeIndex] = null
           if(++mTakeIndex>=mItems.size){
               mTakeIndex =0
           }
            mCount--
            mNotFull.signalAll()

        }catch (exception:Exception){
            exception.printStackTrace()
        }

        return msg
    }


    fun enqueueMessage(message :Message){
        try {
            mLock.lock()

            while (mCount>=mItems.size) {
                mNotFull.await()
                System.out.println("队列满了，阻塞~~~")
            }
                mItems[mPutIndex] = message
                if(++mPutIndex>=mItems.size){
                    mPutIndex=0
                }
            mCount++

            mNotEmpty.signalAll()

        }catch (exception:Exception){
            exception.printStackTrace()
        }finally {

            mLock.unlock()
        }

    }

}