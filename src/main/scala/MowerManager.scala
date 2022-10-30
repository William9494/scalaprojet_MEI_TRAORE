package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.Source


// This class is responsible of creating and managing 'Mowers'
class MowerManager(var x_max: Option[Int], var y_max: Option[Int]) {
  def this() = this(Option(0), Option(0))

  def initializeDim(filePath: String): Unit = {
    try {
      val src = Source.fromFile(filePath)
      val dimTerrain = src.getLines().next()
      src.close()
      if (dimTerrain.length() != 3) {
        Console.println("The file is in a wrong format")
      }
      if (Character.isDigit(dimTerrain.charAt(0)) && Character.isDigit(dimTerrain.charAt(2))) {
        this.x_max = Option(dimTerrain.charAt(0).asDigit)
        this.y_max = Option(dimTerrain.charAt(2).asDigit)
      }

      else {
        Console.println("The file is in a wrong format")
      }
    } catch {
      case _:
        NoSuchElementException => println("The file empty")
    }
  }


  // function to read a file of instructions
  def instantiateMowers(filePath: String): ArrayBuffer[Mower] = {
    val mowers = ArrayBuffer[Mower]()
    val blockedPoints = ArrayBuffer[(Int, Int)]()
    // To know if we read a instruction line (i=j) or a position line (i=2j+1)
    var i = 1
    var mower = new Mower()
    for (line <- Source.fromFile(filePath).getLines) {
      if (i != 1) {
        if (i % 2 == 1) {
          for (instruction <- line) {
            mower.move(instruction, this.x_max.get, this.y_max.get,blockedPoints)
          }
          mowers.append(mower)
          blockedPoints.append(mower.getPosition())
        }
        else {
          mower = new Mower(line.charAt(0).asDigit, line.charAt(2).asDigit, line.charAt(4))
        }
      }
      i = i + 1
    }
    mowers
  }
}
