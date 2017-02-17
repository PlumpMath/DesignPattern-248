package com.cc.single;

/**
 * 单例模式 2016年12月29日 16:10:09
 * 
 * @author chao
 *         单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处
 *         ：
 * 
 *         1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 
 *         2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 
 *         3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。
 *         （比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class Single {

	// 1、首先将构造函数定义成私有的
	private Single() {
	};

	// 2、一个对象 实例化 懒汉式
	public static Single single;// 需要的时候new对象 线程不安全

	// 饿汉式
	// public static Single single = new Single();//当类加载的时候就实例化了一个对象，不管需要不需要
	// 线程安全

	// 3、定义静态的方法
	/*public static Single getSingle() {
		if (single == null) {
			single = new Single();
			System.out.println("第一次调用，需要实例化对象");
		} else {
			System.out.println("该对象已经实例化过了 不需要在实例化了");
		}
		return single;
	}*/
	//synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，因为每次调用getInstance()，
	//都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了
	public static Single getSingle(){
		if (single == null) {
			synchronized(single){
				single = new Single();
				System.out.println("第一次调用，需要实例化对象");
			}
		} else {
			System.out.println("该对象已经实例化过了 不需要在实例化了");
		}
		return single;
	}
	
    /* 此处使用一个内部类来维护单例 */
	private static class SingletonFactory {
		private static Single instance = new Single();
	}
	/* 获取实例 */  
	public static Single getInstance() {
		return SingletonFactory.instance;
	}
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return single;  
    }
}
