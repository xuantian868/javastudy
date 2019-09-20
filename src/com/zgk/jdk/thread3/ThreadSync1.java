package com.zgk.jdk.thread3;

import com.zgk.jdk.thread1.ThreadHero;

/**
 * 演示同步,对象乔峰的初始血量是10000，分别增加10000个伤害线程及10000个恢复线程，理想结果最后的血量hp应该还是10000
 * 如果不加synchronized 同步锁，最后的血量hp可能不是10000.
 * 增加同步锁synchronized后，结果才是10000
 * 如果不在线程中增加synchronized ,也可以在ThreadHero对象的方法上增加
 * 
 * public synchronized void recover(){
        hp=hp+1;
    }
     public void hurt(){
        //使用this作为同步对象
        synchronized (this) {
            hp=hp-1;   
        }
    }
 */
public class ThreadSync1 {

	public static void main(String[] args) {
		
		Object synObj =new Object();
		final ThreadHero gareen = new ThreadHero();
		gareen.name = "乔峰";
		gareen.hp = 10000;

		System.out.printf("乔峰的初始血量是 %.0f%n", gareen.hp);

		// 多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题

		// 假设乔峰有10000滴血，并且在基地里，同时又被对方多个英雄攻击

		// 用JAVA代码来表示，就是有多个线程在减少乔峰的hp
		// 同时又有多个线程在恢复乔峰的hp

		// n个线程增加乔峰的hp

		int n = 10000;

		Thread[] addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					synchronized(gareen) {
						gareen.recover();
					}
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i] = t;
		}

		// n个线程减少乔峰的hp
		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					synchronized(gareen) {
						gareen.hurt();
					}
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			reduceThreads[i] = t;
		}

		// 等待所有增加线程结束
		for (Thread t : addThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 等待所有减少线程结束
		for (Thread t : reduceThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 代码执行到这里，所有增加和减少线程都结束了

		// 增加和减少线程的数量是一样的，每次都增加，减少1.
		// 那么所有线程都结束后，乔峰的hp应该还是初始值

		// 但是事实上观察到的是：
		System.out.printf("%d个增加线程和%d个减少线程结束后%n乔峰的血量变成了 %.0f%n", n,n,gareen.hp);

	}
}
