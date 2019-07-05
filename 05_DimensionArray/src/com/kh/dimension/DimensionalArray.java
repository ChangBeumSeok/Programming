package com.kh.dimension;

import java.util.Scanner;

public class DimensionalArray {
	// ������ �迭 : ������ �迭 �������� �ϳ��� ���� ��
	public void method1() {
		/* ������ �迭 ����
		 * �ڷ���[][] �迭��;
		 * �ڷ���[] �迭��[];
		 * �ڷ��� �迭��[][];
		 */
		
		int[][] arr1;
		int[] arr2[];
		int arr3[][];
		
		// -> ������ �ϰ� �Ǹ� stack�� ���۷��� ���� ����
		
		/* ������ �迭 �Ҵ�
		 * �迭�� = new �ڷ���[��ũ��][��ũ��];
		 * */
		
		arr1 = new int[3][5];
		
		// -> �Ҵ��� �ϸ� heap ������ �ش� ũ�⸸ŭ�� ������ �Ҵ�
		
		// ���� ���̸� �˰��� �Ѵٸ�?
		System.out.println("���� ���� : " + arr1.length);
		
		// ���� ���̸� �˰��� �Ѵٸ�?
		System.out.println("���� ���� : " + arr1[0].length);
		
		// ****
		// ****
		// ****
		// ****
		// ****
		
		// �ܺ� for�� -> ���� ����
		// ���� for�� -> ���� ����
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < arr1.length; i++) { // -> ��
			for(int j = 0; j < arr1[i].length; j++) { // -> ��
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void method2() {
		int[][] arr = new int[3][5];
		
		// 1 2 3 4 5
		// 6 7 8 9 10
		// 11 12 13 14 15
		
		// �ʱ�ȭ ���
		// 1. �ε����� �����Ͽ� �� ���
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		arr[0][4] = 5;
		
		// 2. ��ø for���� �̿��Ͽ� �� ���
		int value = 1;
		for(int i = 0; i < arr.length; i++) { // ���� �������ִ� for��
			for(int j = 0; j < arr[i].length; j++) { // ���� �������ִ� for��
				arr[i][j] = value++;
			}
		}
		
		// 3. ����ؼ� Ȯ��
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void method3() {
		// ������ �迭�� �Ҵ�� �ʱ�ȭ ���ÿ�
		int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
				       {11, 12, 13, 14, 15}};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public void method4() {
		// ���� �迭
		// ���� ���������� �� �࿡ ���� ���� ������ �������� ���� ����
		// �ڷ����� ���� 1���� �迭 �������� �ϳ��� ���� ���� 
		// 2���� �迭�̹Ƿ� �����ִ� 1���� �迭�� ���̰� �� ���� �ʿ�X
		
		int[][] arr = new int[3][]; 
		
		arr[0] = new int[2]; // 0���� 2��
		arr[1] = new int[1]; // 1���� 1��
		arr[2] = new int[3]; // 2���� 3��
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		// ���� �迭 �ʱ�ȭ�� ���
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = value++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void method5() {
		// �����迭�� �Ҵ�� �ʱ�ȭ ���ÿ�
		int[][] arr = {{1, 2}, {3}, {4, 5, 6}};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	public void method6() {
		// double�� 2�� 4�� �迭�� �����
		// 3�� �л��� ����(0��), ����(1��) ������ �Է� �ް�
		// ������ ��(3��)���� �հ踦 ���
		double[][] arr = new double[2][4];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++) {
			double sum = 0;
			
			for(int j = 0; j < arr[i].length-1; j++) {
				
				if(i == 0) { // ù ��° ���� ���
					System.out.print(j+1 + "�� �л� ���� ���� : ");
				}else { // �� ��° ���� ���
					System.out.print(j+1 + "�� �л� ���� ���� : ");
				}
				
				arr[i][j] = sc.nextDouble();
				
				sum += arr[i][j];
			}
			
			arr[i][3] = sum;
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				System.out.print("���� ���� : ");
			}else {
				System.out.print("���� ���� : ");
			}
			
			for(int j = 0; j < arr[i].length; j++) {
				if(j < arr[i].length - 1) {
					System.out.print(arr[i][j] + " ");
				}else {
					System.out.print("�հ� : " + arr[i][j]);
				}
			}
			
			System.out.println();
		}
		
		System.out.println("���� ���� ��� : " + arr[0][3] / 3);
		System.out.println("���� ���� ��� : " + arr[1][3] / 3);
		
	}
	
	public void method7() {
		// char�� 2���� �迭 5�� 5���� ����� ��� ���� �Է� �޾�
		// �ش� ��ǥ�� ���� 'X'�� ��ȯ�� 2���� �迭 ����ϱ�
		// �ݺ� �����ϵ� ���̳� �� �Է½� 0�̸� 5�̻��� ���� �Է� �Ǹ�
		// ���α׷� ����
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][5];
		int row; // ��
		int col; // ��
		
		while(true) {
			System.out.print("�� �ε��� �Է� : ");
			row = sc.nextInt();
			System.out.print("�� �ε��� �Է� :");
			col = sc.nextInt();
			
			if(row < 0 || row > 4 || col < 0 || col > 4) {
				break;
			}
			
			arr[row][col] = 'X';
			
			System.out.println("\t0\t1\t2\t3\t4\t");
			for(int i = 0; i < arr.length; i++) {
				System.out.print(i + "\t");
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
			}
			
		}
		System.out.println("���α׷��� �����մϴ�.");
		
	}
	
	public void method8() {
		// 1~10 ������ ���� ���� 3�� 3�� �迭�� �ߺ� ���� �ֱ�
		
		// 1. ������ �迭�� �̿��ؼ� ���� �ߺ� ����
		int[] arr = new int[3*3];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		// 2. �� �迭�� 3�� 3�� �迭�� ���
		int[][] newArr = new int[3][3];
		
		int index = 0; // arr�� 0��~������ �ε������� �����ϱ� ���� ����
		for(int i = 0; i < newArr.length; i++) {
			for(int j = 0; j < newArr[i].length; j++) {
				newArr[i][j] = arr[index++];
			}
		}
		
		System.out.println("===== ������ �迭 ��� =====");
		for(int i = 0; i < newArr.length; i++) {
			for(int j = 0; j < newArr[i].length; j++) {
				System.out.print(newArr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}