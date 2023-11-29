package com.zretc.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * 英雄子弹类，继承自Sprite类，用于表示英雄飞机发射的子弹。
 */
public class HeroBullet extends Sprite {
    /**
     * 子弹图片静态成员，用于保存子弹图片。
     */
    private static final Image myImg;

    // 初始化子弹图片
    static {
        try {
            myImg = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResourceAsStream("bullet.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构造方法，初始化英雄子弹的属性。
     *
     * @param hero   发射子弹的英雄飞机对象
     * @param xStep  子弹在x轴上的步长
     * @param yStep  子弹在y轴上的步长
     */
    public HeroBullet(Hero hero, int xStep, int yStep) {
        this.width = 6;
        this.height = 14;
        // 子弹初始位置位于英雄飞机中心
        this.x = hero.x + hero.width / 2 - width / 2;
        this.y = hero.y;
        this.xStep = xStep;
        this.yStep = yStep;
    }

    /**
     * 绘制子弹的方法。
     *
     * @param g  画笔对象
     * @param gp 游戏面板对象
     */
    public void paint(Graphics g, GamePanel gp) {
        // 绘制子弹图片
        g.drawImage(myImg, x, y, gp);
    }

    /**
     * 移动子弹的方法。
     */
    public void move() {
        // 子弹沿着指定步长移动
        x += xStep;
        y += yStep;
    }
}
