package tests

import genetics.GeneticAlgorithm
import genetics.geometry.SingleValue
import org.scalatest.FunSuite

class TestSingleValue extends FunSuite {

  val EPSILON: Double = 0.05

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }


  test("Genetic Algorithm Finds a Random Number") {
    var hiddenNumber = 50.0
    var computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 5000.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 2016.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 7830.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 10000.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 9020.25
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 31026.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 29922.0
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 5.985
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
    hiddenNumber = 0.001
    computed = GeneticAlgorithm.geneticAlgorithm(SingleValue.incubator, SingleValue.costFunction(hiddenNumber), 1)
    println(computed.value)

    assert(equalDoubles(hiddenNumber, computed.value))
  }

}
