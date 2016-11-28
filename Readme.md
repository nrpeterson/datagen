# Random Data Generation Library

This library provides fully functional facilities for random data generation, 
for testing and other purposes.

## Purpose

This library is (at least currently) entirely intended as a simple task through
which to learn the Shapeless library.  

## API Stability

For the moment, this is ENTIRELY a playground project; so, no guarantees are
made that the API will remain stable. 

## This library provides:

1. A `RandomnessSource`, providing a source of random bits.  This uses the same
algorithm as `java.lang.Random`, except it returns new instances rather than 
mutating state in place.

2. A `RandomGenerator[A]` typeclass, instances of which represent means of 
randomly choosing `A` instances.

3. Instances of `RandomGenerator` for several primitive types, such as Int,
Char, Long, Float, and Double.

4. Automatic derivation of `RandomGenerator` instances for:
    
    * Singleton types (case objects, etc)
    * Products of types with known instances, and isomorphic types (case 
      classes, tuples, etc)
    * Coproducts of types with known generators, and isomorphic types (e.g. 
      sealed traits with implementations). A top-level type is chosen
      uniformly at random, and then the type-specific generator is invoked.
      
## Have Any Suggestions?

If you happen to spot this, and have any suggestions/pointers, please do let me
know!  Filing an issue here is probably easiest.
