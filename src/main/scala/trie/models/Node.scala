package com.piemonte.chris.trie.models

case class Node(children: Array[Option[Node]] = Array.fill(29)(None), 
  var value: Option[Char],
  var endOfWord: Boolean
)