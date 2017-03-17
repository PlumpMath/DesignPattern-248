package com.cc.thread;


/**
 * volatile
 * 
 * @author chao 在 java
 *         垃圾回收整理一文中，描述了jvm运行时刻内存的分配。其中有一个内存区域是jvm虚拟机栈，每一个线程运行时都有一个线程栈，
 * 
 *         线程栈保存了线程运行时候变量值信息。当线程访问某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存
 * 
 *         变量的具体值load到线程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
 * 
 *         在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象的值就产生变化了。
 *         
 *         volatile 修饰的变量每次使用都会到主内存去取，说明这个变量是不稳定的，告诉jvm这个可能随时会修改每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 *         没有使用volatile 修饰的变量 线程会把变量保存到本地内存中，而不是直接在主内存中读取，这就可能造成一个线程修改了一个变量的值，另一个线程还继续使用寄存器中的变量拷贝，造成数据不一致
 * 
 */
public class ThreadTest05 {
	public volatile static int count = 0;
	/*public static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
            return 0;  
        }
	};*/
	public static void inc(){
		//这里延迟1秒，使效果明细
		try {
			//Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) {
		//同时启动1000个线程，去进行i++计算，看看实际结果
		for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	ThreadTest05.inc();
                }
            }).start();
        }
		//这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + ThreadTest05.count);
	}
}