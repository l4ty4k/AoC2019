package com.l4ty4k.aoc

object Direction extends Enumeration {
  type Direction = Value
  val Left: Direction = Value("L")
  val Right: Direction = Value("R")
  val Up: Direction = Value("U")
  val Down: Direction = Value("D")
}
