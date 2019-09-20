package com.zgk.jdk.thread2;

import com.zgk.jdk.thread1.ThreadHero;

/**
 * yield：当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
 * 测试效果，没有发现由暂停，没看出什么区别来。(￣▽￣)"
 */
public class TreadMethodYield {

	public static void main(String[] args) {

		ThreadHero qiaofeng = new ThreadHero();
		qiaofeng.name = "乔峰";
		qiaofeng.hp = 6162;
		qiaofeng.damage = 1;

		ThreadHero murongfu = new ThreadHero();
		murongfu.name = "慕容复";
		murongfu.hp = 3000;
		murongfu.damage = 30;

		ThreadHero duanyu = new ThreadHero();
		duanyu.name = "段誉";
		duanyu.hp = 5000;
		duanyu.damage = 1;

		ThreadHero jiumozhi = new ThreadHero();
		jiumozhi.name = "鸠摩智";
		jiumozhi.hp = 4550;
		jiumozhi.damage = 80;

		// 乔峰攻击慕容复
		Thread t1 = new Thread("乔峰攻击慕容复") {

			@Override
			public void run() {
				super.run();
				System.out.println("threadname："+Thread.currentThread().getName());
				while(!murongfu.isDead()) {
					qiaofeng.attackHero(murongfu);
				}
			}
			
		};
		
		// 段誉攻击鸠摩智
		Thread t2 = new Thread("段誉攻击鸠摩智") {

			@Override
			public void run() {
				super.run();
				
				System.out.println("threadname："+Thread.currentThread().getName());
				while(!jiumozhi.isDead()) {
					Thread.yield();
					duanyu.attackHero(jiumozhi);
				}
			}
		};
		
		t1.setPriority(5);
		t2.setPriority(5);
		t1.start();
		t2.start();
	}
}
