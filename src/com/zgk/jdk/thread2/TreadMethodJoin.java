package com.zgk.jdk.thread2;

/**
 *  join：加入到当前线程中
 * 使用join后，会将线程加入到主线程中，并且执行完该线程后，才会执行后面的
 * 可以将join注释后再观察执行结果
 * 
 * 
 */
public class TreadMethodJoin {

	public static void main(String[] args) {

		Thread t1 = new Thread() {

			@Override
			public void run() {
				 
				for(int i=1;i<101;i++) {
					System.out.printf("档案i= %d %n", i);
				}
			}
		};

		t1.start();
		//代码执行到这里，一直是main线程在运行
		try {
			t1.join(); //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走,
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				 
				for(int i=1;i<101;i++) {
					System.out.printf("档案j= %d %n", i);
				}
			}
		};
		t2.start();
	}
}
