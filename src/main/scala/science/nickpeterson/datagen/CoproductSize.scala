package science.nickpeterson.datagen

import shapeless.Nat._0
import shapeless._
import shapeless.ops.nat.ToInt

/** Trait used as a witness of the number of (top-level) types in a given coproduct.
  * @tparam A Coproduct whose cardinality is desired
  */
trait CoproductSize[A <: Coproduct] {
  /** Size of the coproduct. */
  type N <: Nat

  /** Size of hte coproduct, in value-space. */
  def size(implicit toInt: ToInt[N]): Int = toInt()
}

object CoproductSize {
  /** Aux object for CoproductSize. */
  type Aux[A <: Coproduct, Size <: Nat] = CoproductSize[A] {type N = Size}

  /** CoproductSize indicating that the 'empty coproduct' contains no types. */
  implicit val cnilSize = new CoproductSize[CNil] { type N = _0 }

  /** Recursively build the size of a coproduct A :+: B, where B is already a Coproduct.
    *
    * Adds 1 to the size of the 'tail' coproduct B.
    *
    * @param size CoproductSize Aux object giving the size of the 'tail' coproduct B.
    * @tparam A New type to add to the coproduct
    * @tparam B Existing types in the coproduct
    * @tparam Size Size of the 'tail' coproduct B
    * @return CoproductSize instance for A :+: B
    */
  implicit def sizeRecurse[A, B <: Coproduct, Size <: Nat](implicit size: CoproductSize.Aux[B, Size]) =
    new CoproductSize[A :+: B] { type N = Succ[Size]}
}
