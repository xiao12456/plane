package com.zretc.plane;

import javax.swing.*;

/**
 * 游戏主程序入口类。
 */
public class Main {

    /**
     * 主方法，程序入口。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建 JFrame 窗口
        JFrame window = new JFrame();
        // 设置窗口的位置和大小
        window.setBounds(100, 100, Map.WIDTH + 12, Map.HEIGHT + 36);
        // 设置窗口标题
        window.setTitle("竖版飞行类游戏");
        // 设置窗口关闭操作
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建游戏面板对象
        GamePanel gp = new GamePanel();
        // 将游戏面板添加到窗口中
        window.add(gp);
        // 为游戏面板添加键盘事件监听器
        gp.addKeyListener(gp);
        // 创建并启动游戏线程
        new Thread(gp).start();
        // 让窗体可见
        window.setVisible(true);
    }
}
