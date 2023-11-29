package com.zretc.plane;

import java.awt.*;

/**
 * 精灵类，用于表示游戏中的可绘制对象。
 */
public class Sprite {
    /**
     * 图片对象，表示精灵的外观。
     */
    protected Image img;

    /**
     * x坐标，表示精灵的横向位置。
     */
    protected int x;

    /**
     * y坐标，表示精灵的纵向位置。
     */
    protected int y;

    /**
     * 精灵的宽度。
     */
    protected int width;

    /**
     * 精灵的高度。
     */
    protected int height;

    /**
     * 精灵在x轴上的移动步长。
     */
    protected int xStep;

    /**
     * 精灵在y轴上的移动步长。
     */
    protected int yStep;
}
