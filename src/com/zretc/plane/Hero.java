package com.zretc.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * 英雄飞机类，继承自Sprite类，用于表示玩家控制的飞机。
 */
public class Hero extends Sprite {

    /**
     * 构造方法，初始化英雄飞机的属性。
     */
    public Hero() {
        this.width = 60;
        this.height = 76;
        this.x = (Map.WIDTH - width) / 2;
        this.y = Map.HEIGHT - height;
        this.xStep = 5;
        this.yStep = 5;
        try {
            // 读取飞机图片资源
            img = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResourceAsStream("plane01.png")));
        } catch (IOException e) {
            // 处理异常，抛出运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 绘制英雄飞机的方法。
     *
     * @param g  画笔对象
     * @param gp 游戏面板对象
     */
    public void paint(Graphics g, GamePanel gp) {
        // 绘制飞机图片
        g.drawImage(img, x, y, gp);
    }

    /**
     * 控制英雄飞机移动的方法。
     *
     * @param up    是否向上移动
     * @param right 是否向右移动
     * @param down  是否向下移动
     * @param left  是否向左移动
     */
    public void move(boolean up, boolean right, boolean down, boolean left) {
        if (up) {
            // 向上移动
            y -= yStep;
            // 确保飞机不超出上边界
            if (y < 0) {
                y = 0;
            }
        }
        if (right) {
            // 向右移动
            x += xStep;
            // 确保飞机不超出右边界
            if (x > Map.WIDTH - width) {
                x = Map.WIDTH - width;
            }
        }
        if (down) {
            // 向下移动
            y += yStep;
            // 确保飞机不超出下边界
            if (y > Map.HEIGHT - height) {
                y = Map.HEIGHT - height;
            }
        }
        if (left) {
            // 向左移动
            x -= xStep;
            // 确保飞机不超出左边界
            if (x < 0) {
                x = 0;
            }
        }
    }
}
