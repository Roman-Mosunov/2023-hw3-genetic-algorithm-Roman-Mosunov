package genetics.geometry


object Polynomial {

  def costFunction(points: List[Point]): Polynomial => Double = {
    Polynomial => var cost: Double = 0.0
      for(i <- points) {
        cost += Math.abs(i.y - Polynomial.evaluate(i.x))
      }
      cost
  }

  def incubator(genes: List[Double]): Polynomial = {
    new Polynomial(genes)
  }

}

/**
 * Represents a polynomial given its coefficients ending with the constant coefficient
 *
 * Ex. new Polynomial(List(1.5, -2.2, 5)) represents 1.5*pow(x, 2) - 2.2*x + 5
 *
 */



class Polynomial(var coefficients: List[Double]) {
  def evaluate(x: Double): Double = {
    var power: Int = coefficients.size - 1
    var result : Double = 0.0
    for (i <- coefficients){
      if ( power != 0){
        result += i * Math.pow(x,power)
        power -= 1
      }
      else{
        result += i
      }
    }
    result
  }

}
