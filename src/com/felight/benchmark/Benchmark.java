package com.felight.benchmark;

import java.util.Arrays;
import java.util.Scanner;
import com.felight.algorithms.SortAlgorithms;

public class Benchmark {
	static Scanner sc = new Scanner(System.in);
	static int[] array;
	static int sizeOfArray;

	private static void doAll() {
		Runnable obj1 = new Runnable() {
			public void run() {
				doHeapSort();
			}
		};
		Runnable obj2 = new Runnable() {
			public void run() {
				doInsertionSort();
			}
		};
		Runnable obj3 = new Runnable() {
			public void run() {
				doMergeSort();
			}
		};
		Runnable obj4 = new Runnable() {
			public void run() {
				doQuickSort();
			}
		};
		Runnable obj5 = new Runnable() {
			public void run() {
				doBubbleSort();
			}
		};
		Runnable obj6 = new Runnable() {
			public void run() {
				doSelectionSort();
			}
		};
		Thread SortAll1 = new Thread(obj1);
		Thread SortAll2 = new Thread(obj2);
		Thread SortAll3 = new Thread(obj3);
		Thread SortAll4 = new Thread(obj4);
		Thread SortAll5 = new Thread(obj5);
		Thread SortAll6 = new Thread(obj6);
		SortAll1.start();
		try {
			SortAll1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SortAll2.start();
		try {
			SortAll2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SortAll3.start();
		try {
			SortAll3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SortAll4.start();
		try {
			SortAll4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SortAll5.start();
		try {
			SortAll5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SortAll6.start();
		try {
			SortAll6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void doHeapSort() {
		System.out.println("Heap Sort Selected");
		int[] heap = new int[sizeOfArray];
		heap = array.clone();
		double heapStart = System.currentTimeMillis();
		heap = SortAlgorithms.heapSort(heap);
		double heapEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (heapEnd - heapStart));
	}

	private static void doInsertionSort() {
		System.out.println("Insertion Sort Selected");
		int[] insertion = new int[sizeOfArray];
		insertion = array.clone();
		double insertionStart = System.currentTimeMillis();
		insertion = SortAlgorithms.InsertionSort(insertion);
		double insertionEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (insertionEnd - insertionStart));
	}

	private static void doMergeSort() {
		System.out.println("Merge Sort Selected");
		int[] merge = new int[sizeOfArray];
		merge = array.clone();
		double mergeStart = System.currentTimeMillis();
		SortAlgorithms.MergeSort(merge);
		double mergeEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (mergeEnd - mergeStart));
	}

	private static void doQuickSort() {
		System.out.println("Quick Sort Selected");
		int[] quick = new int[sizeOfArray];
		quick = array.clone();
		int low = 0;
		int high = quick.length - 1;
		double quickStart = System.currentTimeMillis();
		SortAlgorithms.quickSort(quick, low, high);
		double quickEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (quickEnd - quickStart));
	}

	private static void doBubbleSort() {
		System.out.println("Bubble Sort Selected");
		int[] bubble = new int[sizeOfArray];
		bubble = array.clone();
		double bubbleStart = System.currentTimeMillis();
		bubble = SortAlgorithms.BubbleSort(bubble);
		double bubbleEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (bubbleEnd - bubbleStart));
	}

	private static void doSelectionSort() {
		System.out.println("Selection Sort Selected");
		int[] selection = new int[sizeOfArray];
		selection = array.clone();
		double selectionStart = System.currentTimeMillis();
		selection = SortAlgorithms.SelectionSort(selection);
		double selectionEnd = System.currentTimeMillis();
		System.out.println("Total time Taken to sort is:" + (selectionEnd - selectionStart));
	}

	public static void main(String[] args) {

		boolean status = true, status1 = true, status2 = true;

		do {
			// sizeOfArray = 0;
			System.out.println("Enter the Size of Array");
			try {
				sizeOfArray = sc.nextInt();
				status = false;
			} catch (Exception ex) {
				System.out.println("Invalid input Enter valid size in number");
				sc.next();
			}

		} while (status); // Repeat execution until valid input is received
		array = new int[sizeOfArray];
		outer: do { // invalid input and reselect

			int choice = 0;
			System.out.println("Choose Complexity");
			System.out.println(" 1)Best Case\n 2)Average case \n 3)Worst Case \n 4)Exit ");
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				sc.next();
				e.printStackTrace();
				System.out.println("Invalid Input! please Enter Valid Input.");
				continue outer;
			}

			switch (choice) {

			case 1:
				System.out.println("Selected Best Case:");
				for (int i = 0; i < sizeOfArray; i++)
					array[i] = (int) (Math.random() * 100);
				Arrays.sort(array);
				System.out.println("Generated Sorted Array:");
				break;

			case 2:
				System.out.println("Selected Average Case:");
				for (int i = 0; i < sizeOfArray; i++)
					array[i] = (int) (Math.random() * 100);
				System.out.println("Generated Random Array:");
				break;

			case 3:
				System.out.println("Selected Worst Case:");
				for (int i = 0; i < sizeOfArray; i++)
					array[i] = (int) (Math.random() * 100);
				Arrays.sort(array);
				for (int i = 0; i < array.length / 2; i++) {
					// swap the elements
					int temp = array[i];
					array[i] = array[array.length - (i + 1)];
					array[array.length - (i + 1)] = temp;
				}
				System.out.println("Generated Descending sorted Array:");
				break;

			case 4:
				System.exit(0);

			default:
				System.out.println("Please Enter valid choice.");
				continue outer;

			}
			inner: do {
				System.out.println("Select Option from below List");
				System.out.println(
						" 1)HeapSort \n 2)InsertionSort \n 3)Merge Sort \n 4)Quick Sort \n 5)Bubble Sort\n 6)Selection Sort\n 7)Sort Using All\n 8)Step Over\n 9)Exit");
				int SortChoice;
				try {
					SortChoice = sc.nextInt();
				} catch (Exception e) {
					sc.next();
					e.printStackTrace();
					System.out.println("Invalid Input! please Enter Valid Input.");
					continue inner;
				}

				switch (SortChoice) {

				case 1:
					doHeapSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 2:
					doInsertionSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 3:
					doMergeSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 4:
					doQuickSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 5:
					doBubbleSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 6:
					doSelectionSort();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;

				case 7:
					doAll();
					System.out.println("Press 1 to continue...");
					sc.next();
					break;
				case 8:
					continue outer;

				case 9:
					System.exit(0);
					break;

				default:
					System.out.println("Enter valid choice.");
					continue inner;

				}
			} while (status2);
		} while (status1);
		sc.close();
	}
}