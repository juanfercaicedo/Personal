## Big(O)
- Big(O) is a way of meassuring the efficiency of our code
    - It compares two codes mathematically and determines which one is more efficient
- We can meassure thee efficiency with:
    - **Time complexity**: The number of operations it needs to complete something
    - **Space complexity**: The amount of RAM an algorithm needs to run a completion
- Head and tail are variables that are pointers that point to a node
- Variables that are pointers different from variables like intengers for example
--- 
- We are going to see omega, theta and omicron(O)
    - For the best case we use omega 𝛀
    - For the middle clase we use theta θ
    - And for the worst case we use omicron Ο
---
## Big(O) Notation
- O(n), where n is the number of operations we do
    - O(n) is proportional 
--
## Simplifying things
- We can simplify things by:
1. Dropping constants:
```java
    public static void printItems(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(i);
        }

         for(int j = 0; i < n; j++) {
            System.out.println(j);
        }
    }

    public static void main(String[]args) {
        printItems(10);
    }
```
- We have n + n operations
    - 10 + 10 = 20 -> 2n
- It not O(2n), we can just leave it as O(n)
2. Drop non-dominants
```java
    public static void printItems(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        } // O(n^2) operations

        for(int k = 0; k < n; k++){
            System.out.println(k);
        } //O(n) operations
    }

    public static void main(String[]args) {
        printItems(10);
    }
```     
- We have: O(n ^ 2) + O(n)
    - Since O(n ^ 2) grows faster than O(n), we can just write O(n ^ 2)
---
## O(n^2)
```java
    public static void printItems(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static void main(String[]args) {
        printItems(10);
    }
```
- They ran in N * N = n^2
- It grows really fast, in time complexity it means that is not efficient
---
## O(1)
```java
    public static int addItems(int n) {
        return n + n;
    }

    public static void main(String[]args) {
        printItems(10);
    }
```
- There is only one operation `+`
- O(1) is the most efficient one, we always need to try to achive O(1) complexity
---
## O(log n)
- The data has to be sorted
- It consists on dividing and looking on the half of an array
- For example:
```java
int[] completeArray = [1, 2, 3, 4, 5, 6, 7, 8];

// we want to search for number 1, so we do the following:
// the array is divided to the half
int[] firstHalf = [1, 2, 3, 4];
int[] secondHalf = [5, 6, 7, 8];
// we compare does 1 fit in the first half or the second one?
// we get the first half, so we don't look up the numbers in the second half
int[] fisrtHalf1 = [1, 2];
int[] fisrtHalf2 = [3, 4];
// We do the same
int[] fisrtHalf3 = [1]; // Until we find the element we are looking for
// It took 3 steps to find the number
// 2^3 = 8 -> log ₂8 = 3
```
- O(log n), is the second most efficient after O(1)
