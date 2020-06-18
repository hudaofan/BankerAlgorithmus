package com.brainshark.banker;

import java.util.Scanner;

import com.brainshark.banker.algorithms.Algorithms;

public class Banker {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		while (true) {
			System.out.print("请输入题号(1)or(2):");
			Algorithms.algorithms(new Scanner(System.in).nextInt());
			System.out.println("-----------------");
			System.out.println("-----------------");
		}

	}

}
