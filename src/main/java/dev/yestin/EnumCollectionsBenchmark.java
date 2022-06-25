package dev.yestin;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;

/**
 * A class that uses JMH to test the performance of different collections implementations,
 * namely HashSet versus EnumSet, and HashMap versus EnumMap.
 */
public class EnumCollectionsBenchmark {
    @Benchmark
    public void hashMapBenchmark(Blackhole blackhole) {
        Map<TestEnum, String> enums = new HashMap<>();
        benchmarkMap(enums, blackhole);
        blackhole.consume(enums);
    }

    @Benchmark
    public void enumMapBenchmark(Blackhole blackhole) {
        Map<TestEnum, String> enums = new EnumMap<>(TestEnum.class);
        benchmarkMap(enums, blackhole);
        blackhole.consume(enums);
    }

    @Benchmark
    public void hashSetBenchmark(Blackhole blackhole) {
        Set<TestEnum> enums = new HashSet<>();
        benchmarkSet(enums, blackhole);
        blackhole.consume(enums);
    }

    @Benchmark
    public void enumSetBenchmark(Blackhole blackhole) {
        Set<TestEnum> enums = EnumSet.noneOf(TestEnum.class);
        benchmarkSet(enums, blackhole);
        blackhole.consume(enums);
    }

    private void benchmarkSet(Set<TestEnum> enums, Blackhole blackhole) {

        enums.add(TestEnum.ONE);
        enums.add(TestEnum.TWO);
        enums.add(TestEnum.THREE);
        enums.add(TestEnum.FOUR);
        enums.add(TestEnum.FIVE);

        boolean contains1 = enums.contains(TestEnum.ONE);
        boolean contains2 = enums.contains(TestEnum.TWO);
        boolean contains3 = enums.contains(TestEnum.THREE);
        boolean contains4 = enums.contains(TestEnum.FOUR);
        boolean contains5 = enums.contains(TestEnum.FIVE);

        blackhole.consume(contains1);
        blackhole.consume(contains2);
        blackhole.consume(contains3);
        blackhole.consume(contains4);
        blackhole.consume(contains5);

        enums.remove(TestEnum.ONE);
        enums.remove(TestEnum.TWO);
        enums.remove(TestEnum.THREE);
        enums.remove(TestEnum.FOUR);
        enums.remove(TestEnum.FIVE);

        contains1 = enums.contains(TestEnum.ONE);
        contains2 = enums.contains(TestEnum.TWO);
        contains3 = enums.contains(TestEnum.THREE);
        contains4 = enums.contains(TestEnum.FOUR);
        contains5 = enums.contains(TestEnum.FIVE);

        blackhole.consume(contains1);
        blackhole.consume(contains2);
        blackhole.consume(contains3);
        blackhole.consume(contains4);
        blackhole.consume(contains5);
    }

    private void benchmarkMap(Map<TestEnum, String> enums, Blackhole blackhole) {

        enums.put(TestEnum.ONE, "test1");
        enums.put(TestEnum.TWO, "test2");
        enums.put(TestEnum.THREE, "test3");
        enums.put(TestEnum.FOUR, "test4");
        enums.put(TestEnum.FIVE, "test5");

        boolean contains1 = enums.containsKey(TestEnum.ONE);
        boolean contains2 = enums.containsKey(TestEnum.TWO);
        boolean contains3 = enums.containsKey(TestEnum.THREE);
        boolean contains4 = enums.containsKey(TestEnum.FOUR);
        boolean contains5 = enums.containsKey(TestEnum.FIVE);

        blackhole.consume(contains1);
        blackhole.consume(contains2);
        blackhole.consume(contains3);
        blackhole.consume(contains4);
        blackhole.consume(contains5);

        enums.remove(TestEnum.ONE);
        enums.remove(TestEnum.TWO);
        enums.remove(TestEnum.THREE);
        enums.remove(TestEnum.FOUR);
        enums.remove(TestEnum.FIVE);

        contains1 = enums.containsKey(TestEnum.ONE);
        contains2 = enums.containsKey(TestEnum.TWO);
        contains3 = enums.containsKey(TestEnum.THREE);
        contains4 = enums.containsKey(TestEnum.FOUR);
        contains5 = enums.containsKey(TestEnum.FIVE);

        blackhole.consume(contains1);
        blackhole.consume(contains2);
        blackhole.consume(contains3);
        blackhole.consume(contains4);
        blackhole.consume(contains5);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EnumCollectionsBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
