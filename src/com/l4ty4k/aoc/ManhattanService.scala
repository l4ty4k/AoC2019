package com.l4ty4k.aoc

import com.l4ty4k.aoc.Direction.Direction

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext

class ManhattanService(implicit inputReader: InputReader, ec: ExecutionContext) {

  import ManhattanService._

  def getIntersection: Point = {
    val steps1: Seq[Step] = parseSteps(inputReader.readLine).expand
    val steps2: Seq[Step] = parseSteps(inputReader.readLine).expand

    val route1: Seq[Point] = getRoute(steps1, Seq(Point(0, 0)))
    val route2: Seq[Point] = getRoute(steps2, Seq(Point(0, 0)))

    getIntersections(route1, route2).filter(_ != Point(0, 0)).sortWith(sortPointsByManhattanDesc).head

  }

  private def sortPointsByManhattanDesc(p1: Point, p2: Point): Boolean = {
    Math.abs(p1.x) + Math.abs(p1.y) < Math.abs(p2.x) + Math.abs(p2.y)
  }

  private def getIntersections(route1: Seq[Point], route2: Seq[Point]): Seq[Point] = {
    route1.intersect(route2)
  }

  @tailrec
  private def getRoute(steps: Seq[Step], result: Seq[Point]): Seq[Point] = {
    steps match {
      case Nil => result
      case _ =>
        val points = result :+ getPoints(result.last, steps.head.dir)
        getRoute(steps.tail, points)
    }
  }

  private def getPoints(location: Point, dir: Direction): Point = {
    dir match {
      case Direction.Right               => location.copy(x = location.x + 1)
      case Direction.Left                => location.copy(x = location.x - 1)
      case com.l4ty4k.aoc.Direction.Up   => location.copy(y = location.y + 1)
      case com.l4ty4k.aoc.Direction.Down => location.copy(y = location.y - 1)
    }
  }

  private def parseSteps(stePlistString: String): Seq[Step] = {
    stePlistString.split(',').map { step =>
      Step.fromString(step)
    }
  }

}

object ManhattanService {

  implicit class StepTransformer(seq: Seq[Step]) {
    def expand: Seq[Step] = {
      val buf = ArrayBuffer.empty[Step]
      seq.foreach { s =>
        for (i <- 1 to s.dist) {
          buf += (Step(s.dir, 1))
        }
      }
      buf.toSeq
    }

  }
}
