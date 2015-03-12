import org.scalatest.FunSuite

class BowlingSuite extends FunSuite {

  test("bowling score 20 rolls: 10 pairs of 5 and 1") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score("51515151515151515151")

    assert(result == 60)
  }

  test("bowling score 20 rolls: 10 pairs of 9 and miss") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score("9-9-9-9-9-9-9-9-9-9-")

    assert(result == 90)
  }

  test("21 rolls: 10 pairs of 5 and spare, with a final 5") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score("5/5/5/5/5/5/5/5/5/5/5")

    assert(result == 150)
  }

  test("bowling score 12 rolls: 12 strikes") {
    val bowling: Bowling = new Bowling()

    val result: Integer = bowling.score("XXXXXXXXXXXX")

    assert(result == 300)
  }

}