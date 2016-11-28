package science.nickpeterson.datagen

import shapeless._

/** Example usage. */

case class Coordinates(x: Double, y: Double)
case class ColoredPoint(isRed: Boolean, coords: Coordinates)
case class NumberedPoint(number: Int, coords: Coordinates)

sealed trait A
case object B extends A

case object C extends A

case class D(int: Int) extends A

object Hello

object Main extends App {


  val src = RandomnessSource(11071234L)

  type AnyPoint = ColoredPoint :+: NumberedPoint :+: CNil

  val gen = RandomGenerator.repeat(RandomGenerator[AnyPoint], 10)

  gen.run(src)._2 foreach println

  val gen2 = RandomGenerator.repeat(RandomGenerator[A], 40)

  gen2.run(src)._2 foreach println

}
