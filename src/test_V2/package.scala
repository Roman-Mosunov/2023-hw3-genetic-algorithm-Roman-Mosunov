package test_V2

import scala.collection.mutable.ListBuffer
import scala.util.Random

object test {

  def main(args: Array[String]) : Unit = {
    var mutation_rate : Double = 0.3
    var numberOfGenes : Int = 1
    var next_gen : List[List[Double]] = {
      List(List(10), List(5))
    }


    var sublist = new ListBuffer[Double]()
    var gen_list = new ListBuffer[List[Double]]()
    for (i <- 0 to  1) {
      for (f <- 0 to (numberOfGenes-1)) {
        sublist += next_gen(i)(f)
        println(sublist)
      }
      for (z <- 0 to math.round(numberOfGenes*mutation_rate-1).toInt){
        sublist(Random.nextInt(1)) = Random.nextInt(10000000).toDouble
        println(z)
      }
      gen_list += sublist.toList
      sublist = ListBuffer[Double]()
    }
    println(gen_list.toList)
  }
}