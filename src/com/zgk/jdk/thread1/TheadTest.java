package com.zgk.jdk.thread1;

/**
 * 如果不使用多线程，只能时 乔峰攻击慕容复，直到莫容复死后，才能由段誉发起对鸠摩智的攻击
 * 
 * */
public class TheadTest {

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
		while (!murongfu.isDead()) {
			qiaofeng.attackHero(murongfu);
		}

		// 段誉攻击鸠摩智
		while (!jiumozhi.isDead()) {
			duanyu.attackHero(jiumozhi);
		}

	}

}
