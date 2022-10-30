package main.scala

object Main extends App {
  //reading the files
  val testFile = "src/test/resources/testfile.txt"
  val manager = new MowerManager()
  manager.initializeDim(testFile)
  val mowers = manager.instantiateMowers(testFile)
  //print the results
  println("position finale des tondeuses :")
  var i = 0
  while (i<mowers.size){
    println(s"Tondeuse ${i+1} : ${mowers(i).x} ${mowers(i).y} ${mowers(i).getDirection()}")
    i += 1
  }
}
