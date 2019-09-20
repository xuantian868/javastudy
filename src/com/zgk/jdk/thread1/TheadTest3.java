package com.zgk.jdk.thread1;

/**
 * 使用多线程， 乔峰攻击慕容复，段誉攻击鸠摩智 ，可以同时发起
 * 
 */
public class TheadTest3 {
 

	public static void main(String[] args) {

		ThreadHero qiaofeng = new ThreadHero();
		qiaofeng.name = "乔峰";
		qiaofeng.hp = 616;
		qiaofeng.damage = 50;

		ThreadHero murongfu = new ThreadHero();
		murongfu.name = "慕容复";
		murongfu.hp = 300;
		murongfu.damage = 30;

		ThreadHero duanyu = new ThreadHero();
		duanyu.name = "段誉";
		duanyu.hp = 500;
		duanyu.damage = 65;

		ThreadHero jiumozhi = new ThreadHero();
		jiumozhi.name = "鸠摩智";
		jiumozhi.hp = 455;
		jiumozhi.damage = 80;

		// 乔峰攻击慕容复
		KillRunnable t = new KillRunnable(qiaofeng, murongfu);
		new Thread(t).start();
		// 段誉攻击鸠摩智
		new Thread(new KillRunnable(duanyu, jiumozhi)).start();

	}

}
