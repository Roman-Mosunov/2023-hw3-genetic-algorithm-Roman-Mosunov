package genetics.geometry

object SingleValue {

  def costFunction(number: Double): SingleValue => Double = (guess: SingleValue) {
    null
  }

  def incubator(genes: List[Double]): SingleValue = {
    null
  }

}

class SingleValue(var value: Double) {
  override def toString: String = {
    value.toString
  }
}
