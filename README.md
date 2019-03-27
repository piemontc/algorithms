# Data Structures

## Trie

### What is a trie?
Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N, where M is maximum string length and N is number of keys in tree. Using Trie, we can search the key in O(M) time. However the penalty is on Trie storage requirements.  
  
(Geeks for Geeks | https://www.geeksforgeeks.org/trie-insert-and-search/)

### What does this program do?
Search for all states that begin with a given prefix. Matches are printed to the console.

### How do I compile this program?
sbt compile

### How do I run this program?
sbt "run [search string]"  
sbt "runMain com.piemonte.chris.trie.Driver [search string]"
