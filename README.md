# Java Concurrency In Practice Examples
###代码注解说明

**@ThreadSafe**  
表示 这个类是线程安全的。  

**@NotThreadSafe**  
表示 这个类不是线程安全的。  

**@Immutable**  
表示 类是不可变的，不可变对象是线程安全的。  

**@GuardedBy(lock)**  
**@GuardedBy("this")**  
受对象内部锁保护  

**@GuardedBy("fieldName")**  
受 与fieldName引用相关联的锁 保护。  
  
**@GuardedBy("ClassName.fieldName")**  
受 一个类的静态field的锁 保存。  

**@GuardedBy("methodName()")**  
锁对象是 methodName() 方法的返值，受这个锁保护。  

**@GuardedBy("ClassName.class")**  
受 ClassName类的直接锁对象保护。而不是这个类的某个实例的锁对象。  
