import org.scalatest.FunSuite

class BowlingSuite extends FunSuite {

  test("bowling score 20 rolls: 10 pairs of 5 and 1") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score(Frame('5','1'),Frame('5','1'),Frame('5','1'),Frame('5','1'),Frame('5','1'),
      Frame('5','1'), Frame('5','1'), Frame('5','1'), Frame('5','1'), Frame('5','1'))

    assert(result == 60)
  }

  test("bowling score 20 rolls: 10 pairs of 9 and miss") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score(Frame('9','-'),Frame('9','-'),Frame('9','-'),Frame('9','-'),Frame('9','-'),
      Frame('9','-'), Frame('9','-'), Frame('9','-'), Frame('9','-'), Frame('9','-'))

    assert(result == 90)
  }

  test("21 rolls: 10 pairs of 5 and spare, with a final 5") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score(Frame('5','/'),Frame('5','/'), Frame('5','/'), Frame('5','/'), Frame('5','/'),
      Frame('5','/'), Frame('5','/'), Frame('5','/'), Frame('5','/'), Frame('5','/', '5'))

    assert(result == 150)
  }

  test("bowling score 12 rolls: 12 strikess") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score(Frame('X'),Frame('X'),Frame('X'),Frame('X'),Frame('X'),Frame('X'),Frame('X'),
      Frame('X'),Frame('X'),Frame('X', 'X', 'X'))

    assert(result == 300)
  }

}