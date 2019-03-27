package com.piemonte.chris.trie

import com.piemonte.chris.models.Node

class Trie {

  def insertWord(root: Node, word: String): Node = {
    val wordLower = word.toLowerCase
    val c: Char = wordLower(0)
    val index: Int = TrieHelper.getIndex(c)
    val length = wordLower.length
    
    if(TrieHelper.getValueAtIndex(root, index).equals(None)) 
      TrieHelper.insertNodeAtIndex(root, index, c, (length == 1))
    else if(length == 1) root.children(index).get.endOfWord = true

    if(length > 1) insertWord(root.children(index).get, wordLower.slice(1, length))
    
    root
  }

  def search(root: Node, word: String): Either[List[String], String] = {
    val wordLower = word.toLowerCase
    var endNode: Option[Node] = if(wordLower.length > 0) Some(root) else None
    
    wordLower.map(letter => endNode = TrieHelper.getNodeAtIndex(endNode, TrieHelper.getIndex(letter)))

    Left(TrieHelper.traverseNodes(endNode.getOrElse(return Right("nomatch")), wordLower))
  }

  def displayResults(r: Either[List[String],String]): Unit = {
    val results = r.left.getOrElse(r.right.getOrElse("Sorry, something went wrong"))

    results match {
      case x: String => println(x)
      case _ => for(w <- results.asInstanceOf[List[String]]) println(w)
    }
  }
}