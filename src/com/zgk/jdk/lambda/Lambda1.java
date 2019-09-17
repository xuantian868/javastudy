package com.zgk.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 找出满足条件的Hero hp>100 && damage<50
 * 使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据
 * @author Demo_Local
 * @CreateDate: 20190917
 */
public class Lambda1 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("wang" + i, r.nextInt(1000), r.nextInt(100)));

		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		System.out.println("筛选出 hp>100 && damange<50的英雄");
		filter(heros);
	}

	private static void filter(List<Hero> heros) {
		for (Hero hero : heros) {
			if (hero.hp > 100 && hero.damage < 50) {
				System.out.print(hero);
			}
				
		}
	}

}
