package com.zgk.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 找出满足条件的Hero hp>100 && damage<50 使用匿名内部类
 * 
 * @author Demo_Local
 * @CreateDate: 20190917
 */
public class Lambda2 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("wang" + i, r.nextInt(1000), r.nextInt(100)));

		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		System.out.println("使用匿名内部类，筛选出 hp>100 && damange<50的英雄");
		HeroChecker check = new HeroChecker() {

			@Override
			public boolean test(Hero h) {
				return h.getHp()>100&&h.getDamage()<50;
			}
			
		};
		filter(heros,check);
	}

	private static void filter(List<Hero> heros,HeroChecker check) {
		for (Hero hero : heros) {
			if (check.test(hero)) {
				System.out.print(hero);
			}

		}
	}

}
