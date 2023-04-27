package tests

import genetics.geometry.Point
import org.scalatest.FunSuite

class TestPolynomial extends FunSuite {

  val EPSILON: Double = 0.5

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }


  test("Genetic Algorithm Compute Polynomial Regression") {
    var polynomial: List[Double] = List(1, 2, 1)
    var points: List[Point] = List(new Point(1, 4), new Point(0, 1), new Point(2, 9), new Point(3, 16), new Point(4, 25), new Point(5, 36), new Point(-1, 0))

  }


}
