package com.zgk.jdk.thread1;

public class ThreadHero {

	public String name;
    public float hp;//血量
     
    public int damage;//攻击值
    
    //恢复血量
    public void recover() {
    	hp = hp + 1;
    }
    //受伤，减少血量
    public void hurt() {
    	hp = hp - 1;
    }
    
    /**
     * 当前ThreadHero发起对传入对象h的攻击
     * @param ThreadHero h 被攻击对象
     * */
    public void attackHero(ThreadHero h) {
    	  try {
              //为了表示攻击需要时间，每次攻击暂停1000毫秒
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
    	  
    	  h.hp-=damage;
          System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
          
          if(h.isDead()) {
        	  System.out.println(h.name +"死了！");
          }
    }
    
    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
