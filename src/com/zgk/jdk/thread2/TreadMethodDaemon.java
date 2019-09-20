package com.zgk.jdk.thread2;

import com.zgk.jdk.thread1.KillTread;
import com.zgk.jdk.thread1.ThreadHero;

/**
 * setDaemon：守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程
 * 下面例子中将线程t设置为守护线程，还没有执行线程就结束了。不会输出内容 
 * 
 */
public class TreadMethodDaemon {

	public static void main(String[] args) {


		Thread t = new Thread("测试线程") {
			
			@Override
			public void run() {
				int seconds =0;
				while(true) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 System.out.printf("已经玩了LOL %d 秒%n", seconds++);
				}
			}
			
		};
		
		t.setDaemon(true);
		t.start();
	}
}
