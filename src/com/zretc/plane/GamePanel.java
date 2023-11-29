package com.zretc.plane;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏面板类，继承自Panel，实现了Runnable和KeyListener接口。
 */
public class GamePanel extends Panel implements Runnable, KeyListener {
    private Map map = new Map();
    private Hero hero = new Hero();
    private List<HeroBullet> heroBullets = new ArrayList<>();
    private int addHeroBulletCount = 0;
    private boolean up, right, down, left;

    /**
     * 重写update方法，用双缓冲技术解决闪烁问题。
     *
     * @param g 画笔对象
     */
    @Override
    public void update(Graphics g) {
        Image tmp = createImage(Map.WIDTH, Map.HEIGHT); // 创建一个临时图片，将所有图片绘制到 tmp 上，这时候没有刷新屏幕
        Graphics gTmp = tmp.getGraphics();
        map.paint(gTmp, this);
        hero.paint(gTmp, this);
        for (HeroBullet bullet : heroBullets) {
            bullet.paint(gTmp, this);
        }
        g.drawImage(tmp, 0, 0, this);
    }

    /**
     * 游戏主循环。
     */
    @Override
    public void run() {
        while (true) {
            addHeroBullet();
            map.move();
            for (HeroBullet bullet : heroBullets) {
                bullet.move();
            }
            hero.move(up, right, down, left);
            repaint(); // 重新调用 paint 方法
            try {
                Thread.sleep(40L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 添加英雄子弹的方法。
     */
    private void addHeroBullet() {
        addHeroBulletCount++;
        if (addHeroBulletCount == 5) {
            HeroBullet heroBullet = new HeroBullet(hero, 0, -7);
            heroBullets.add(heroBullet);
            heroBullet = new HeroBullet(hero, -2, -7);
            heroBullets.add(heroBullet);
            heroBullet = new HeroBullet(hero, 2, -7);
            heroBullets.add(heroBullet);
            heroBullet = new HeroBullet(hero, -4, -7);
            heroBullets.add(heroBullet);
            heroBullet = new HeroBullet(hero, 4, -7);
            heroBullets.add(heroBullet);
            addHeroBulletCount = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 处理按键按下事件。
     *
     * @param e 按键事件对象
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            default:
                break;
        }
    }

    /**
     * 处理按键释放事件。
     *
     * @param e 按键事件对象
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            default:
                break;
        }
    }
}
