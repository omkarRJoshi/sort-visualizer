package com.sorting.visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class SortArray extends JPanel{
	
	private static final long serialVersionUID = 4999157483852441803L;
	final int WINDOW_WIDTH = 1300;
	final int WINDOW_HEIGHT = 720;
	int[] arr;
	int[] bar_colors;
	int BAR_WIDTH = 4;
	int NUM_BARS = WINDOW_WIDTH / BAR_WIDTH - 100;
	int SLEEP_TIME = 1;
	
	public SortArray() {
		arr = new int[NUM_BARS];
		bar_colors = new int[NUM_BARS];
		
		createArray();
		setBackground(Color.darkGray);
		
	}
	
	public void createArray() {
		Random rand = new Random();
		for(int i = 0; i < NUM_BARS; i++) {
			arr[i] = 1 + rand.nextInt(NUM_BARS);
			bar_colors[i] = 0;
		}

	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D)g.create();
		super.paintComponent(graphics);
		for(int x = 0; x < arr.length; x++) {
			int height = arr[x] * 2;
			int xBegin = x + BAR_WIDTH * x + 100;
			int yBegin = WINDOW_HEIGHT - height - 100;
			int val = bar_colors[x];
			
			if(val == 255) {
				graphics.setColor(Color.red);
			}
			else if(val == 128) {
				graphics.setColor(Color.green);
			}
			else if(val == 100)
				graphics.setColor(new Color(135,206,250));
			else {
				graphics.setColor(Color.white);
			}
			graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
			
		}
	}
	
	public void sleepFor(long sleepTimeInMilli) {
		long sleepTimeInNano = 1000000 * sleepTimeInMilli;
		long timeElapsed;
		final long startTime = System.nanoTime();
		do {
			timeElapsed = System.nanoTime() - startTime;
		}while(timeElapsed < sleepTimeInNano);
	}
	
	public void changeColor(int i, int j, int colorA, int colorB, long sleepInMilli) {
		bar_colors[i] = colorA;
		bar_colors[j] = colorB;
		repaint();
		sleepFor(sleepInMilli);
		bar_colors[i] = 0;
		bar_colors[j] = 0;
	}
	
	public void constantColor(int i, int colorA, long sleepInMilli) {
		bar_colors[i] = colorA;
		repaint();
		sleepFor(sleepInMilli);
	}
	
	public void changeSingleColor(int i, int colorA, int colorB, int begin) {
		int start = i - 6;
		while(start < i) {
			if(start > begin)
				bar_colors[start] = colorA;
			start++;
		}
		bar_colors[i] = colorB;
	}
	
	public void changeSingleColor(int i, int color, int border, boolean left, int diff) {
		diff = diff / 20;
		if(left) {
			int start = i + diff;
			while(start >= i) {
				if(start > border && start < arr.length)
					bar_colors[start] = color;
				start--;
			}
		}
		else {
			int start = i - diff;
			while(start <= i) {
				if(start < border && start >= 0)
					bar_colors[start] = color;
				start++;
			}
		}
		repaint();
	}
}
