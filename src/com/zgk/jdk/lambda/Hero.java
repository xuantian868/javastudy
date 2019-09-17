package com.zgk.jdk.lambda;

public class Hero implements Comparable<Hero>{

	public String name;
    public int hp;//血量
        
    public int damage;//破坏力，武力值

	@Override
	public int compareTo(Hero o) {
		if(damage>o.getDamage()) {
			return 1;
		}
		return -1;
	}

	public Hero(String name, int hp, int damage) {
		super();
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]";
	}
    
	
}
