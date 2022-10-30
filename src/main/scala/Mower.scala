package main.scala

import scala.collection.mutable.ArrayBuffer

// This class allow us to to build a mow
class Mower(var x: Int = 0, var y: Int = 0, var dir: Char = 'N') {
  // get the current position of the mow
  def getPosition() = (this.x, this.y)

  // get the current direction of the mow

  def getDirection() = this.dir

  private def notblockedPoints(x: Int, y: Int, x_max: Int, y_max: Int, blockedPoints: ArrayBuffer[(Int, Int)]) = {
    (x >= 0) && (y >= 0) && (x <= x_max) && (y <= y_max) && !(blockedPoints contains(x, y))
  }
  // Creation of the move function of the mowers. Which allows the mowers to move and change direction.
  //Direction constants.
  //N represents North.
  //E represents East.
  //W represents West.
  //S represents South.
  def move(instance: Char, x_max: Int, y_max: Int, blockedPoints: ArrayBuffer[(Int, Int)]): Unit = {
    instance match {
      case 'A' => dir match {
        case 'N' =>
          if (notblockedPoints(x, y + 1, x_max, y_max, blockedPoints)) {
            y = y + 1
          }
          else {
            println(x, y)
          }
        case 'S' =>
          if (notblockedPoints(x, y - 1, x_max, y_max, blockedPoints)) {
            y = y - 1
          }
          else {
            println(x, y)
          }
        case 'E' =>
          if (notblockedPoints(x + 1, y, x_max, y_max, blockedPoints)) {
            x = x + 1
          }
          else {
            println(x, y)
          }
        case 'W' =>
          if (notblockedPoints(x - 1, y, x_max, y_max, blockedPoints)) {
            x = x - 1
          }
          else {
            println(x, y)
          }
      }//changing direction
      case 'G' => dir match {
        case 'N' => dir = 'W'
        case 'S' => dir = 'E'
        case 'E' => dir = 'N'
        case 'W' => dir = 'S'
      }

      case 'D' => dir match {
        case 'N' => dir = 'E'
        case 'S' => dir = 'W'
        case 'W' => dir = 'N'
        case 'E' => dir = 'S'
      }
      case _ =>
    }
  }
}
