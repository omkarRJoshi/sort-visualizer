package com.sorting.visualizer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener{
	
	JFrame window;
	SortArray sortArray;
	JPanel buttonWrapper;
	JButton bubble, selection, merge, quick, shuffle;
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		window = new JFrame("Sort visiualizer");
		sortArray = new SortArray();
		createButtonWrapper();
		window.setSize(sortArray.WINDOW_WIDTH, sortArray.WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		sortArray.setBounds(0, 50, sortArray.WINDOW_WIDTH, 650);
		window.add(sortArray);
		window.add(buttonWrapper);
		window.setVisible(true);
	}
	
	public void createButtonWrapper() {
		buttonWrapper = new JPanel();
		buttonWrapper.setBounds(0, 0, sortArray.WINDOW_WIDTH, 50);
		buttonWrapper.setBackground(Color.darkGray);
		
		bubble = new JButton("Bubble sort");
		selection = new JButton("Selection sort");
		merge = new JButton("Merge sort");
		quick = new JButton("Quick sort");
		shuffle = new JButton("Create new array");
		
		buttonWrapper.add(bubble);
		buttonWrapper.add(selection);
		buttonWrapper.add(merge);
		buttonWrapper.add(quick);
		buttonWrapper.add(shuffle);
		
		bubble.addActionListener(this);
		bubble.setActionCommand("bubble");
		selection.addActionListener(this);
		selection.setActionCommand("selection");
		merge.addActionListener(this);
		merge.setActionCommand("merge");
		quick.addActionListener(this);
		quick.setActionCommand("quick");
		shuffle.addActionListener(this);
		shuffle.setActionCommand("shuffle");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		 TODO Auto-generated method stub
		Thread sorting = new Thread();
		String command = e.getActionCommand();
		
		switch (command) {
		case "bubble":
			sorting = new Thread(new BubbleSort(sortArray));
			break;
		case "selection":
			sorting = new Thread(new SelectionSort(sortArray));
			break;
		case "merge":
			sorting = new Thread(new MergeSort(sortArray));
			break;
		case "quick":
			sorting = new Thread(new QuickSort(sortArray));
			break;
		case "shuffle":
			sortArray.createArray();
			sortArray.repaint();
		}
		sorting.start();
	}

}
