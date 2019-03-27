package com.piemonte.chris.trie

import com.piemonte.chris.trie.models.Node
import com.piemonte.chris.trie.data.States

object Driver extends App {
  val query = args(0)
  val trie = new Trie
  val root = Node(value = None, endOfWord = false)

  States.states.map(state => trie.insertWord(root, state))

  trie.displayResults(trie.search(root, query))
}