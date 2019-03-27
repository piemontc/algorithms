package com.piemonte.chris.trie

import scala.collection.mutable.ListBuffer
import com.piemonte.chris.models.Node

trait TrieHelper {

  def insertNodeAtIndex(parent: Node, index: Int, value: Char, isEnd: Boolean): Unit = {
    parent.children(index) = Some(Node(value = Some(value), endOfWord = isEnd))
  }

  def traverseNodes(node: Node, prefix: String): List[String] = {
    val results = ListBuffer.empty[String]
    
    if(node.endOfWord) results += prefix
    
    getPresentNodes(node).map(n =>
      traverseNodes(n, s"${prefix}${n.value.get}").map(w => results += w))
    
    results.toList
  }

  def getValueAtIndex(parent: Node, index: Int): Option[Char] = {
    parent.children(index).getOrElse(return None).value
  }

  def getIndex(c: Char): Int = {
    c match {
      case 32 => 26 // space
      case 45 => 27 // hyphen
      case 46 => 28 // period
      case _ => c -97
    }
  }

  def getNodeAtIndex(parent: Option[Node], index: Int): Option[Node] = {
    parent.getOrElse(return None).children(index)
  }

  def getPresentNodes(node: Node): List[Node] = {
    val nodes = ListBuffer.empty[Node]
    
    node.children.flatten.map(child => nodes += child)
    
    nodes.toList
  }
}