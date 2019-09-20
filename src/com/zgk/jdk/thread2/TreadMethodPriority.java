package com.zgk.jdk.thread2;

import com.zgk.jdk.thread1.KillTread;
import com.zgk.jdk.thread1.ThreadHero;

/**
 * setPriority：线程优先级
 * 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源。
 * 测试效果，没看出什么区别来。(￣▽￣)"
 * 
 */
public class TreadMethodPriority {

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
		KillTread t = new KillTread(qiaofeng, murongfu);
		t.setPriority(Thread.MAX_PRIORITY);
		// 段誉攻击鸠摩智
		KillTread t2 = new KillTread(duanyu, jiumozhi);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t.start();
		t2.start();
	}
}
