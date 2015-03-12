class Bowling {
  def score(tries: String): Int = {
    val throws: IndexedSeq[Throw] = tries.map(c => c match {
      case 'X' => Strike()
      case '/' => Spare()
      case '-' => Zero()
      case x => NormalThrow(x.asDigit)
    });

   throws.foldLeft((0, List[Throw]()))((result: (Int, List[Throw]), currentThrow: Throw) => {
     if (result._2.size < throws.size - 1) {
       result._2 match {
         case Nil => (result._1 + currentThrow.value, List(currentThrow))
         case h1 :: h2 :: tail if h2 == Strike() => (result._1 + 2 * currentThrow.value + h1.value, currentThrow :: result._2)
         case h1 :: h2 :: tail if h1 == Spare() => (result._1 + 2 * currentThrow.value - h2.value, currentThrow :: result._2)
         case h :: tail => (result._1 + currentThrow.value, currentThrow :: result._2)
       }
     } else {
       result._2 match {
         case h1 :: h2 :: tail if h1 == Spare() => (result._1  + currentThrow.value - h2.value, currentThrow :: result._2)
         case h :: tail => (result._1 + currentThrow.value, currentThrow :: result._2)
       }
     }
   })._1
  }
}

trait Throw {
  def value: Int;
}

case class Zero(value: Int = 0) extends Throw
case class Strike(value:Int = 10) extends Throw
case class Spare(value: Int = 10) extends Throw
case class NormalThrow(value: Int) extends Throw

