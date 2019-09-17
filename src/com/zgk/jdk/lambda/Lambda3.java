package com.zgk.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 找出满足条件的Hero hp>100 && damage<50 使用Lambda
 * 
 * @author Demo_Local
 * @CreateDate: 20190917
 */
public class Lambda3 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("wang" + i, r.nextInt(1000), r.nextInt(100)));

		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		System.out.println("使用Lambda，筛选出 hp>100 && damange<50的英雄");
		/**
		 * 
		 * Lambda表达式可以看成是匿名类一点点演变过来。
		 * Lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想
		 * Lambda表达式虽然带来了代码的简洁，但是也有其局限性。
		 * 1. 可读性差，与啰嗦的但是清晰的匿名类代码结构比较起来，Lambda表达式一旦变得比较长，就难以理解
		 * 2. 不便于调试，很难在Lambda表达式中增加调试信息，比如日志
		 * 3. 版本支持，Lambda表达式在JDK8版本中才开始支持，如果系统使用的是以前的版本，考虑系统的稳定性等原因，而不愿意升级，那么就无法使用。
		 * Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。 
		 * 
		 * */
		filter(heros,c->c.getHp()>100&&c.getDamage()<50);
		
		//引用静态方法
		System.out.println("在lambda中引用静态方法");
		filter(heros,c->Lambda3.test(c));
		System.out.println("直接引用静态方法");
		filter(heros,Lambda3::test);
		
		System.out.println("直接引用对象方法");
		//引用对象方法，需要先创建对象
		Lambda3 lam3 = new Lambda3();
		filter(heros,lam3::test2);
	}
	
	private static boolean test(Hero c) {
		return c.getHp()>100&&c.getDamage()<50;
	}
	
	private boolean test2(Hero c) {
		return c.getHp()>100&&c.getDamage()<50;
	}

	private static void filter(List<Hero> heros,HeroChecker check) {
		for (Hero hero : heros) {
			if (check.test(hero)) {
				System.out.println(hero);
			}
		}
	}

}
