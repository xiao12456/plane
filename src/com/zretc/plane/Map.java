package com.zretc.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * 地图类，继承自Sprite类，用于显示背景地图。
 */
public class Map extends Sprite {
    /**
     * 地图的宽度
     */
    public static final int WIDTH = 480;
    /**
     * 地图的高度
     */
    public static final int HEIGHT = 652;

    /**
     * 构造方法，初始化地图属性。
     */
    public Map() {
        this.yStep = 3; // 定义地图的 y 坐标步长
        try {
            // 读取地图图片资源
            img = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResourceAsStream("background.png")));
        } catch (IOException e) {
            // 处理异常，抛出运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 绘制地图方法，绘制两张图片以形成地图滚动效果。
     *
     * @param g  画笔对象
     * @param gp 游戏面板对象
     */
    public void paint(Graphics g, GamePanel gp) {
        // 绘制第一张图片
        g.drawImage(img, 0, y, gp);
        // 绘制第二张图片，以形成滚动效果
        g.drawImage(img, 0, y - HEIGHT, gp);
    }

    /**
     * 移动地图，通过改变y坐标实现地图滚动。
     */
    public void move() {
        y += yStep;
        // 当地图滚动到底部时，重新设置y坐标，形成循环滚动效果
        if (y > Map.HEIGHT) {
            y = 0;
        }
    }
}
