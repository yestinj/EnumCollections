# EnumCollections

This project was created to microbenchmark the efficiency of different Set and
Map implementations. In particular, HashSet versus EnumSet, and HashMap versus EnumMap

These are very simple benchmarks, and at present only create each collection, and
perform a few common operations on them.

Use is made of https://github.com/openjdk/jmh.

This is a synthetic benchmark, and real world performance will inevitably be different.
