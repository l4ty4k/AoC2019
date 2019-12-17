package com.l4ty4k.aoc

object Day3 extends App {
  import concurrent.ExecutionContext.Implicits.global

  implicit val reader: InputReader = new InputReader
  val manhattanService             = new ManhattanService()
  val res: Point = manhattanService.getIntersection
  val dist = Math.abs(res.x) + Math.abs(res.y)
  System.out.println(s"x:${res.x} - y:${res.y} = ${dist}")

}
