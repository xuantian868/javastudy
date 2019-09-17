package com.zgk.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 找出满足条件的Hero hp>100 && damage<50 使用Lambda聚合操作 要了解聚合操作，首先要建立Stream和管道的概念 Stream
 * 和Collection结构化的数据不一样，Stream是一系列的元素，就像是生产线上的罐头一样，一串串的出来。 管道指的是一系列的聚合操作。
 * 
 * 管道又分3个部分 管道源：在这个例子里，源是一个List 中间操作：
 * 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
 * 结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 * 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach， 什么都不返回,
 * 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断
 * 
 * @author Demo_Local
 * @CreateDate: 20190917
 */
public class Lambda4 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("wang" + i, r.nextInt(1000), r.nextInt(100)));
		}
		heros.add(heros.get(0));
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		System.out.println("使用Lambda，筛选出 hp>100 && damange<50的英雄");
		heros.stream().filter(h -> h.getHp() > 100 && h.getDamage() < 50).forEach(h -> System.out.println(h));

		System.out.println("limit,取前几条");
		heros.stream().limit(3).forEach(h -> System.out.println(h));

		System.out.println("skip,跳过前几条");
		heros.stream().skip(3).forEach(h -> System.out.println(h));

		System.out.println("distinct,去除重复");
		heros.stream().distinct().forEach(h -> System.out.println(h));
	}

}
