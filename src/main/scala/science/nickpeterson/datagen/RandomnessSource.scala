package science.nickpeterson.datagen

/** RandomnessSource that uses the same algorithm as java.util.Random.
  *
  * @param seed Random seed, as a Long.
  */
case class RandomnessSource(seed: Long) {

  /** Get n random bits, represented as an integer.
    *
    * @param n Number of desired bits.  Should satisfy 1 <= n <= 32.
    * @return Integer whose last n bits are pseudorandom.
    */
  def getBits(n: Int): (RandomnessSource, Int) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)
    val value = (seed >>> (48 - n)).toInt
    (RandomnessSource(newSeed), value)
  }
}
