package com.piemonte.chris.trie

import com.piemonte.chris.trie.models.Node
import com.piemonte.chris.trie.data.States

object Driver extends App {
  val query = if(args.length == 0) "" else args(0)
  val trie = new Trie
  val root = Node(value = None, endOfWord = false)

  States.states.map(state => trie.insertWord(root, state))

  def displayResults(r: Either[List[String],String]): Unit = {
    val results = r.left.getOrElse(r.right.getOrElse("Sorry, something went wrong"))

    results match {
      case x: String => println(x)
      case _ => for(w <- results.asInstanceOf[List[String]]) println(w)
    }
  }

  displayResults(trie.search(root, query))
}