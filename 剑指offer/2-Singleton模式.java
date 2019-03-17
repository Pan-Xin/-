// 关键点： 1 Lazy loading; 2 线程安全

// 必要的：
// 1 private 构造函数；
// 2 static method getter；
// 3 static 变量


// 1 懒汉式-非线程安全
public class Singleton{
	// static method需要访问static变量；同时static变量在内存区只有一份
	private static Singleton s; 

	// 构造函数必须是private的，不然会被别的类调用来new对象
	private Singleton(){}

	// 调用方式为Singleton.getSingleton, 所以应该为static method
	public static Singleton getSingleton(){ // 这里是非线程安全的
		if(s == null)
			s = new Singleton();
		return s;
	}
}


// 2 懒汉式-线程安全
public class Singleton{
	private static Singleton s;

	private Singleton(){}

	public static synchronized Singleton getSingleton(){ // 加上同步锁，但是并发性降低，比如要访问这个单例模式的其他方法会被阻挡住
		if(s == null)
			s = new Singleton();
		return s;
	}
}


// 3 饿汉式-线程安全
public class Singleton{
	private static Singleton s = new Singleton(); // 虽然是线程安全的，但是如果这个singleton用不到的话就浪费了

	private Singleton(){}

	public static Singleton getSingleton(){
		return Singleton();
	}
}

// 使用静态代码块
public class Singleton{
	private static Singleton s; // 饿汉式

	static{
		s = new Singleton();
	}

	private Singleton(){}

	public static Singleton getSingleton(){
		return s;
	}
}


// 4 懒汉式-考虑缩小同步代码块大小
// 双锁
public class Singleton{
	private static volatile Singleton s; // 声明为volatile从而保证可见性

	private Singleton(){}

	public static Singleton getSingleton(){ 
		if(s == null){
			// s = null的时候线程AB都能进入这个区域
			// 然后线程A进入同步代码块来new了一个对象
			// 这时候线程B又会进入同步代码块
			// 如果不double check s的话，那么B又会new一次
			// 所以需要双锁
			synchronized(Singleton.class){ // 因为是单例模式，所以加的是类锁 
				if(s == null) 
					s = new Singleton();
			}
		}
		return s;
	}
}

// 5 使用静态内部类
public class Singleton{
	// 静态内部类
	private static class staticInnerClass{
		private static final Singleton s = new Singleton();
	}

	private Singleton(){}

	public static final Singleton getSingleton(){
		// 只有在主动调用这个的时候，内部类才会被装载
		// classloader的机制又能保证初始化instance的时候只有一个进程
		return staticInnerClass.s;
	}

}


// 6 枚举
// 枚举类型是在第一次使用的时候才会被初始化->lazy loading
// 并且默认的构造函数就是private修饰的，且为线程安全
public enum Singleton{
	INSTANCE;
}


// 7 序列化问题
// 传统的单例写法如果实现了序列化接口就不能再保持单例
// 因为readObject() 方法每次会返回新的对象
// 所以需要重写
private Object readResolve(){
	return INSTANCE;
}