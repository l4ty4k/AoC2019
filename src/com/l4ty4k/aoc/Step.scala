package com.l4ty4k.aoc

import com.l4ty4k.aoc.Direction.Direction

import scala.util.Try

case class Step(
    dir: Direction,
    dist: Int,
)
object Step {

  def stay: Step = {
    Step(Direction.Down, 0)
  }

  def fromString(step: String): Step = {
    val splitted = step.splitAt(1)
    Try {
      Step(Direction.withName(splitted._1), splitted._2.toInt)
    }
  }.getOrElse(Step.stay)

}
