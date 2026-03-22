Implementation and Complexity Analysis of Lists, Stacks, and Queues
📌 Overview

This repository contains a Java-based project focused on the implementation and algorithmic complexity analysis of fundamental data structures: Lists, Stacks, and Queues.

The primary goal of this project is to evaluate how different structural designs impact the performance and execution time of standard operations (such as inserting, deleting, and accessing elements).
⚙️ Implementation Details

A key architectural decision in this project is the strict use of Linked Lists as the foundational building block for all data structures.

    No Arrays: Array-based implementations were intentionally avoided to focus purely on node-based memory allocation.

    Tail Pointers: The project explores the performance differences between linked lists implemented with and without tail pointers.

    Core Operations: Methods like popFront (for Stacks) and Dequeue (for Queues) are explicitly built on top of these linked list variations to demonstrate the shift in time complexity when a tail reference is maintained.

📊 Complexity Analysis

The project includes a detailed Big O analysis of the implemented structures. By comparing the variations (with vs. without a tail pointer), the analysis demonstrates the optimization of append and dequeue operations from O(n) to O(1) in specific scenarios.
Implemented Structures:

    Linked Lists (Singly linked and double linked list, evaluated with/without tail references)

    Stacks (LIFO behavior, utilizing popFront via linked nodes)

    Queues (FIFO behavior, utilizing Dequeue via linked nodes)

🚀 Technologies Used

    Language: Java

    Concepts: Data Structures, Algorithmic Complexity, Big O Notation, Object-Oriented Programming (OOP)

💻 How to Run

    Clone this repository:
    Bash

    git clone [your-repository-url]

    Open the project in your preferred Java IDE (Eclipse, IntelliJ, VS Code, etc.).

    Compile and run the main test files to see the console outputs and performance comparisons for the different data structures.
