package com.l4ty4k.aoc

import java.io.BufferedReader

import scala.io.{BufferedSource, Source}

class InputReader {
  private val input: BufferedSource = Source.fromInputStream(System.in)
  private val reader: BufferedReader = input.bufferedReader()

  def readLine: String = {
    reader.readLine()
  }
}
