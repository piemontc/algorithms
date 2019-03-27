package com.piemonte.chris.trie

import com.piemonte.chris.models.Node

object Driver extends App {

  val trie = new Trie
  val root = Node(value = None, endOfWord = false)

  trie.insertWord(root, "HELLO")
  trie.insertWord(root, "hi")
  trie.insertWord(root, "hill")
  trie.insertWord(root, "home")
  trie.insertWord(root, "house")
  trie.insertWord(root, "Hemp")
  trie.insertWord(root, "hEaRt")
  trie.insertWord(root, "halt")
  trie.insertWord(root, "happy")
  trie.insertWord(root, "hungry")
  trie.insertWord(root, "hype")
  trie.insertWord(root, "hen")
  trie.insertWord(root, "henny")
  trie.insertWord(root, "honor")
  trie.insertWord(root, "he")
  trie.insertWord(root, "h")

  trie.displayResults(trie.search(root, "he"))
}