/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listquantification;

/**
 *
 * @author juand
 */


    import java.util.Scanner;
import java.time.*;
import java.util.Random;
public class ListQuantification
{
	static SinglyLinkedList<Integer> singleList;
	static SinglyLinkedListTail<Integer> singleListTail;
	static DoublyLinkedList<Integer> doubleList;
	static DoublyLinkedListTail<Integer> doubleListTail; 

	static int arraySize;

	static Random random;

	static Scanner scan;

	static int testNumber;
	
	static int testPosition;



	public static void main(String[] args) {
		scan = new Scanner(System.in);

		random = new Random();

		// Singly linked list
		singleList = new SinglyLinkedList<>();
		// Singly linked list tail
		singleListTail = new SinglyLinkedListTail<>();
		//DoublyLinkedList
		doubleList = new DoublyLinkedList<>();
		//DoublyLinkedListTail
		doubleListTail = new DoublyLinkedListTail<>();


		int val = -1;

		while(val != 0) {

			System.out.println("\nChoose operation:");
			System.out.println("1 - pushFront");
			System.out.println("2 - pushBack");
			System.out.println("3 - popFront");
			System.out.println("4 - popBack");
			System.out.println("5 - find");
			System.out.println("6 - topFront");
			System.out.println("7 - topBack");
			System.out.println("8 - empty");
			System.out.println("9 - erase (Reference)");
			System.out.println("10 - erase (Value)");
			System.out.println("11 - addBefore");
			System.out.println("12 - addAfter");
			System.out.println("0 - exit");

			val = scan.nextInt();

			if (val == 0) break;

			FillArrays();

			boolean showResults = true;

			if (val <= 5 || val >= 9)
			{
				System.out.println("Select the number of tests to run. Any number lower than 0 will be interpreted as a single test");

				testNumber = scan.nextInt();

				System.out.println("If you do not wish to see individual test results, type in 0. If you do, type any other number");

				showResults = scan.nextInt() != 0;
			}

			if (testNumber < 0) testNumber = 1;

			switch(val) {

			case 1: // pushFront


				PushFrontTest(showResults);

				break;
			case 2:
				PushBackTest(showResults);
				break;
			case 3:
				PopFrontTest(showResults);
				break;
			case 4:
				PopBackTest(showResults);
				break;
			case 5:
				FindTest(showResults);
				break;
			case 6:
				TopFrontTest();
				break;
			case 7:
				TopBackTest();
				break;
			case 8:
				EmptyTest();
				break;
			case 9:
			    EraseByReferenceTest(showResults);
			    break;
			case 10:
			    EraseByValueTest(showResults);
			    break;
			case 11:
			    AddBeforeTest(showResults);
			    break;
			case 12:
			    AddAfterTest(showResults);
			    break;

			}
		}

		scan.close();
	}

	static void FillArrays()
	{
		// Singly linked list
		singleList = new SinglyLinkedList<>();
		// Singly linked list tail
		singleListTail = new SinglyLinkedListTail<>();
		//DoublyLinkedList
		doubleList = new DoublyLinkedList<>();
		//DoublyLinkedListTail
		doubleListTail = new DoublyLinkedListTail<>();

		System.out.println("What power of 10 shall be tested?");
		arraySize = scan.nextInt();

		arraySize = (int)Math.pow(10, arraySize);

		int[] consistencyArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			consistencyArray[i] = random.nextInt(arraySize/4);
		}

		//Para consistencia de resultados, todas las listas serC!n llenadas de igual manera

		//SinglyLinkedList
		for(int i = 0; i < arraySize; i++) {
			singleList.pushFront(consistencyArray[i]);
		}



		//Single Tail
		for(int i = 0; i < arraySize; i++) {
			singleListTail.pushFront(consistencyArray[i]);
		}




		//DoblyLinkedList

		for(int i = 0; i < arraySize; i++) {
			doubleList.pushFront(consistencyArray[i]);
		}


		//DoblyLinkedListTail

		for(int i = 0; i < arraySize; i++) {
			doubleListTail.pushFront(consistencyArray[i]);
		}

		System.out.println("Fill successful!");

	}

	static void PushFrontTest(boolean showResults)
	{
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;

		System.out.println("pushFront Times (With" + testNumber + " pushFront operation(s) each): ");

		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");
			int insertion = random.nextInt();

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.pushFront(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.pushFront(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.pushFront(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.pushFront(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

	static void PushBackTest(boolean showResults)
	{
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;

		System.out.println("pushBack Times (With" + testNumber + "  pushBack operation(s) each): ");

		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");
			int insertion = random.nextInt();

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.pushBack(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.pushBack(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.pushBack(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.pushBack(insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

	static void PopFrontTest(boolean showResults)
	{
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;

		System.out.println("popFront Times (With" + testNumber + "  popFront operation(s) each): ");

		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.popFront();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.popFront();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.popFront();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.popFront();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

	static void PopBackTest(boolean showResults)
	{
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;

		System.out.println("popBack Times (With" + testNumber + "  popBack operation(s) each): ");

		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.popBack();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.popBack();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.popBack();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.popBack();
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

	static void FindTest(boolean showResults)
	{
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;
		
		

		System.out.println("find Times (With" + testNumber + "  find operation(s) each): ");
		System.out.println("Please note the element searched is completely random, so the search times may vary wildly between tests. If unsure of the results, try again with more tests");
		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");

			int searchParam = random.nextInt(arraySize/4);
			//Se llama con arraySize para minimizar la probabilidad de un elemento no encontrado y mantener el arreglo diverso

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.find(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.find(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.find(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.find(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

	static void TopFrontTest()
	{
		System.out.println("topFront Times: ");
		System.out.println("Please verify that all operations throw the same result to know the test was accurate");

		long startTimer = 0;
		long endTimer = 0;

		startTimer = System.nanoTime();
		int value = singleList.topFront();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = singleListTail.topFront();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLLT Verifier: " + value);

		startTimer = System.nanoTime();
		doubleList.topFront();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = doubleListTail.topFront();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLLT Verifier: " + value);
	}

	static void TopBackTest()
	{
		System.out.println("topBack Times: ");
		System.out.println("Please verify that all operations throw the same result to know the test was accurate");

		long startTimer = 0;
		long endTimer = 0;

		startTimer = System.nanoTime();
		int value = singleList.topBack();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = singleListTail.topBack();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLLT Verifier: " + value);

		startTimer = System.nanoTime();
		doubleList.topBack();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = doubleListTail.topBack();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLLT Verifier: " + value);
	}

	static void EmptyTest()
	{
		System.out.println("isEmpty Times: ");
		System.out.println("Please verify that all operations throw 'false' to know the test was accurate.");
		System.out.println("Note that due to the nature of the filling, all lists contain at least one element, therefore none are empty");


		long startTimer = 0;
		long endTimer = 0;

		startTimer = System.nanoTime();
		boolean value = singleList.isEmpty();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = singleListTail.isEmpty();
		endTimer = System.nanoTime();
		System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("SLLT Verifier: " + value);

		startTimer = System.nanoTime();
		doubleList.isEmpty();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLL Verifier: " + value);

		startTimer = System.nanoTime();
		value = doubleListTail.isEmpty();
		endTimer = System.nanoTime();
		System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
		System.out.println("DLLT Verifier: " + value);
	}

	static Node getReference(int position, List findList, boolean doubleList)
	{
		Node returnNode = null;

		//Select a random node if the position isn't defined
		if (position <= 0)
		{
			int maxTests = 3;
			int rng = random.nextInt(arraySize/4);

			while (maxTests > 0)
			{
				returnNode = findList.find(rng);

				maxTests--;

				if (returnNode != null) break;
			}
			
			testPosition = position;

			if (returnNode != null) return returnNode;

			position = arraySize/2;
			
			testPosition = position;

		}

		//Find the node in the given position

		if (!doubleList) 
		{
            SingleNode sNode = (SingleNode)findList.getHead(); 
            
			for (int i = 0; i < position; i++)
			{
                sNode = sNode.next;
			}
			
			returnNode = sNode;
		}
		else 
		{
		    DobleNode dNode = (DobleNode)findList.getHead();
		    
		    for (int i = 0; i < position; i++)
			{
                dNode = dNode.next;
			}
			
			returnNode = dNode;
		}
		
		return returnNode;
	}

	static void AddAfterTest(boolean showResults)
	{
		System.out.println("This test only focuses on the time it takes to add given a reference.");
		System.out.println("Therefore, time only runs after during the addAfter function, not finding the random nodes to test");
		
		Node sNode = null;
		Node stNode = null;
		Node dNode = null;
		Node dtNode = null;
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;
		
		if (testNumber <= 1) showResults = true;
		
		
		for (int i = 0; i < testNumber; i++) 
		{
		    if (showResults) System.out.println("Test #" + i + ":");
		    
		    sNode = getReference(0, singleList, false);
            stNode = getReference(testPosition, singleListTail, false);
            dNode = getReference(testPosition, doubleList, true);
            dtNode = getReference(testPosition, doubleListTail, true);
            
            int insertion = random.nextInt();
            
            long startTimer = 0;
            long endTimer = 0;
            
            startTimer = System.nanoTime();
			singleList.addAfter(sNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.addAfter(stNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.addAfter(dNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.addAfter(dtNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
            
            
		}
		
		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
        
        
        
        

	}
	
	static void AddBeforeTest(boolean showResults) 
	{
	    System.out.println("This test only focuses on the time it takes to add given a reference.");
		System.out.println("Therefore, time only runs after during the addBefore function, not finding the random nodes to test");
		
		Node sNode = null;
		Node stNode = null;
		Node dNode = null;
		Node dtNode = null;
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;
		
		if (testNumber <= 1) showResults = true;
		
		
		for (int i = 0; i < testNumber; i++) 
		{
		    if (showResults) System.out.println("Test #" + i + ":");
		    
		    sNode = getReference(0, singleList, false);
            stNode = getReference(testPosition, singleListTail, false);
            dNode = getReference(testPosition, doubleList, true);
            dtNode = getReference(testPosition, doubleListTail, true);
            
            int insertion = random.nextInt();
            
            long startTimer = 0;
            long endTimer = 0;
            
            startTimer = System.nanoTime();
			singleList.addBefore(sNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.addBefore(stNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.addBefore(dNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.addBefore(dtNode, insertion);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
            
            
		}
		
		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}
	
	static void EraseByReferenceTest(boolean showResults) 
	{
	    System.out.println("This test only focuses on the time it takes to erase given a reference.");
		System.out.println("Therefore, time only runs after during the erase function, not finding the random nodes to test");
		System.out.println("Please note the system might throw out errors if the list runs out of elements.");
		
		Node sNode = null;
		Node stNode = null;
		Node dNode = null;
		Node dtNode = null;
		long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;
		
		if (testNumber <= 1) showResults = true;
		
		
		for (int i = 0; i < testNumber; i++) 
		{
		    if (showResults) System.out.println("Test #" + i + ":");
		    
		    sNode = getReference(0, singleList, false);
            stNode = getReference(testPosition, singleListTail, false);
            dNode = getReference(testPosition, doubleList, true);
            dtNode = getReference(testPosition, doubleListTail, true);
            
            int insertion = random.nextInt();
            
            long startTimer = 0;
            long endTimer = 0;
            
            startTimer = System.nanoTime();
			singleList.eraseByReference(sNode);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.eraseByReference(stNode);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.eraseByReference(dNode);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.eraseByReference(dtNode);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
            
            
		}
		
		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}
	
	static void EraseByValueTest(boolean showResults) 
	{
	    long sTimer = 0;
		long stTimer = 0;
		long dTimer = 0;
		long dtTimer = 0;
		
		

		System.out.println("erase by value Times (With" + testNumber + "  find operation(s) each): ");
		System.out.println("Please note the element searched is completely random, so the system might print out that the element hasn't been found.");
		if (testNumber <= 1) showResults = true;

		for (int i = 1; i <= testNumber; i++) {

			if (showResults) System.out.println("Test #" + i + ":");

			int searchParam = random.nextInt(arraySize/4);
			//Se llama con arraySize para minimizar la probabilidad de un elemento no encontrado y mantener el arreglo diverso

			long startTimer = 0;
			long endTimer = 0;

			startTimer = System.nanoTime();
			singleList.eraseByValue(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List Time: " + (endTimer - startTimer) + " ns");
			sTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			singleListTail.eraseByValue(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Singly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			stTimer += endTimer - startTimer;


			startTimer = System.nanoTime();
			doubleList.eraseByValue(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List Time: " + (endTimer - startTimer) + " ns");
			dTimer += endTimer - startTimer;

			startTimer = System.nanoTime();
			doubleListTail.eraseByValue(searchParam);
			endTimer = System.nanoTime();
			if (showResults) System.out.println("Doubly Linked List w/ Tail Time: " + (endTimer - startTimer) + " ns");
			dtTimer += endTimer - startTimer;
		}

		if (testNumber <= 1) return;
		System.out.println("\nResults: ");
		System.out.println("Singly Linked List: " + sTimer/testNumber + "ns (Average), " + sTimer + "ns (Total)");
		System.out.println("Singly Linked List w/ Tail: " + stTimer/testNumber + "ns (Average), " + stTimer + "ns (Total)");
		System.out.println("Doubly Linked List: " + dTimer/testNumber + "ns (Average), " + dTimer + "ns (Total)");
		System.out.println("Doubly Linked List w/ Tail: " + dtTimer/testNumber + "ns (Average), " + dtTimer + "ns (Total)");
	}

}


