package genetics
import scala.util.Random
import scala.collection.immutable.ListMap

object GeneticAlgorithm {
  def geneticAlgorithm[T](incubator: List[Double] => T, costFunction: T => Double, numberOfGenes: Int): T = {
    /**
     * Uses a genetic algorithm to optimize a generic problem
     *
     * @param incubator     Determines how instances of type T are created from a List of Doubles (genes)
     * @param costFunction  Determines the cost for a given instance of T
     * @param numberOfGenes The size of the List expected by the incubator
     * @tparam T The type to be optimized
     * @return An instance of T with minimal cost
     */
    val num_of_gen_an: Int = 100
    var gen_num: Int = 100000
    val best_an: Int = 10
    val mutation_rate: Double = 0.6
    var mainList: List[List[Double]] = List.empty
    var costList: List[Double] = List.empty
    //Not worth making 100k generations for one value, since it makes it pretty accurate within 10k generations
    //With accuracy of +/- 1 * pow(10, -9)
    if (numberOfGenes == 1){
      gen_num = 10000
    }
    def mutation(an: List[Double]): List[Double] = {
      var mutated_an: List[Double] = List.empty
      for (element <- an) {
        var gene: Double = element
        if (an.size > 1)  {
          if (Random.nextDouble() <= mutation_rate) {
            //Math.random() * 0.25 = Minimum_value of 0, Maximum_value of 0.25 -> by adding 0.875, we can get
            //Similar chances for both decreasing and increasing of the gene value.
            //Inner mutation by approximately 12% seems quite efficient
            gene = gene * (Math.random() * 0.25 + 0.875)
            if (Random.nextDouble() <= 0.2) {
              if (Random.nextDouble() <= 0.5) {
                gene -= 1
              }
              else {
                gene += 1
              }
            }
          }
        }
        else {
          if (gene > -0.0001 && gene < 0.0001) {
            gene = -2
          }
          gene *= (Math.random() * 0.25 + 0.875)
        }
        mutated_an ::= gene
      }
      mutated_an
    }

    def crossover(an1: List[Double], an2: List[Double]): List[Double] ={
      var an_genes: List[Double] = List.empty
      for (a <- an1.indices) {
        var gene: Double = an1(a)
        if (an1.size == 1) {
          gene = (an1(a) + an2(a))/2
        }
        else {
          if (Random.nextDouble() <= mutation_rate) {
            gene = an2(a)
          }
        }
        an_genes ::= gene
      }
      an_genes
    }
    //Population
    for (_ <- 1 to num_of_gen_an) {
      var an_gene: List[Double] = List.empty
      for (_ <- 1 to numberOfGenes) {
        if (numberOfGenes > 1) {
          if(Random.nextDouble() >= 0.5) {
            an_gene ::= Random.nextInt(50000).toDouble
          } else {
            an_gene ::= Random.nextInt(50000).toDouble * (-1)
          }
        } else {
          an_gene ::= Random.nextInt(50000).toDouble
        }
      }
      mainList ::= an_gene
    }

    for (i <- 1 to gen_num) {
      costList = List.empty
      //Sorting using cost function + if the optimal result was achieved, it returns earlier
      //In the majority of cases, Single Value is found either within 50-200 gen or with 10000 gen
      var map_cost: Map[List[Double], Double] = Map.empty
      for (animalGene <- mainList) {
        map_cost += (animalGene -> costFunction(incubator(animalGene)))
        if (costFunction(incubator(animalGene)) == 0) {
          println("Gen solved - " + i)
          return incubator(animalGene)
        }
      }
      map_cost = ListMap(map_cost.toSeq.sortWith(_._2.abs < _._2.abs):_*)
      val gen_list: List[List[Double]] = map_cost.keys.toList
      mainList = List.empty
      for (a <- 0 until  best_an) {
        mainList ::= gen_list(a)
      }
      while (mainList.size != num_of_gen_an) {
        // crossover
        val an1: Int = Random.nextInt(best_an)
        var an2: Int = Random.nextInt(best_an)
        while (an1 == an2) {
          an2 = Random.nextInt(best_an)
        }
        mainList ::= crossover(mainList(an1), mainList(an2))
        // mutation
        if (mainList.size != num_of_gen_an) {
          val animal: List[Double] = mainList(Random.nextInt(best_an - 1))
          mainList ::= mutation(animal)
        }
      }
    }
    var map_cost: Map[List[Double], Double] = Map.empty
    for (an_gene <- mainList) {
      map_cost += (an_gene -> costFunction(incubator(an_gene)))
      if (costFunction(incubator(an_gene)) == 0) {
        return incubator(an_gene)
      }
    }
    map_cost = ListMap(map_cost.toSeq.sortWith(_._2.abs < _._2.abs):_*)
    val gen_list: List[List[Double]] = map_cost.keys.toList
    println("Gen solved - " + gen_num )
    incubator(gen_list.head)
  }
}
