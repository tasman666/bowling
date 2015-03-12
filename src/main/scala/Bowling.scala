class Bowling {
  def score(frames: Frame*): Int =
    frames.foldLeft((0: Int, NormalScore(0, 0): Score))((result: (Int, Score), frame: Frame) => {
        val newScore: Score =
          frame match {
            case Frame('X') => Strike()
            case Frame(x,y) if y =='/' => Spare(x)
            case Frame(x,y) if y =='-' && x == '-' => NormalScore(0,0)
            case Frame(x,y) if x =='-' => NormalScore(0, y.asDigit)
            case Frame(x,y) if y =='-' => NormalScore(x.asDigit, x.asDigit)
            case Frame(x,y) => NormalScore(x.asDigit, x.asDigit + y.asDigit)
            case Frame(x,y,z) if y == '/' => Spare(x, 10)
            case Frame(x,y,z) => Strike(x, x + y + z)
          }
        val scoreNumber = result._2 match {
          case NormalScore(firstThrow, value) => newScore.value
          case Spare(_,_) => newScore.value + newScore.firstThrow
          case Strike(_,_) => newScore.value + newScore.value
        }
        (result._1 + scoreNumber, newScore)
      }
    )._1

}
case class Frame(tries: Char*)
trait Score {
  val firstThrow: Int;
  val value: Int;
}

case class NormalScore(firstThrow: Int, value: Int) extends Score
case class Strike(firstThrow:Int = 10, value:Int = 10) extends Score
case class Spare(firstThrow: Int, value: Int = 10) extends Score

