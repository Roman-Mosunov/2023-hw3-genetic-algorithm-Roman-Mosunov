package genetics.aimbot

object AimBot{

  // set this to the number of genes you'll use in your incubator method
  var numberOfDimensions: Int = 0

  // Any returned velocity must have this magnitude
  // do not change this value
  val projectileSpeed: Double = 7.0


  def costFunction(sourceLocation: PhysicsVector, targetLocation: PhysicsVector, targetVelocity: PhysicsVector): PhysicsVector => Double = {
    PhysicsVector => val result : PhysicsVector = PhysicsVector
      val answer: PhysicsVector = result.normal2d()
      val slopeT: Double = targetVelocity.y / targetVelocity.x
      val slopeP: Double = answer.y / answer.x
      val ix : Double = ((sourceLocation.y - slopeP * sourceLocation.x) - (targetLocation.y - slopeT * targetLocation.x))/ (slopeT - slopeP)
      val iy : Double = sourceLocation.y + (ix - sourceLocation.x)/answer.y
      val intersection : PhysicsVector = new PhysicsVector( ix , iy )
      val speedT: Double =  Math.sqrt(Math.pow(targetVelocity.x,2.0) + Math.pow(targetVelocity.y,2.0))
      val ratioT: Double = speedT / (projectileSpeed * (ix - sourceLocation.x)/ answer.x)
      val positionT : PhysicsVector = new PhysicsVector(targetLocation.x + ratioT * targetVelocity.x, targetLocation.y + ratioT * targetVelocity.y)
      if ((ix - sourceLocation.x)/ answer.x < 0 ){
        100000.0
      }
      else {
        intersection.distance2d(positionT) + (result.x.abs - answer.x.abs * projectileSpeed + result.y.abs - answer.y.abs * projectileSpeed - result.z.abs - answer.z.abs * projectileSpeed)
      }
  }

  def incubator(genes: List[Double]): PhysicsVector = {
    numberOfDimensions = genes.size
    if (numberOfDimensions == 3){
      new PhysicsVector(x = genes.head, y = genes(1), z = genes(2))
    }
    else{
      new PhysicsVector( x = genes.head, y = genes.last)
    }
  }

}