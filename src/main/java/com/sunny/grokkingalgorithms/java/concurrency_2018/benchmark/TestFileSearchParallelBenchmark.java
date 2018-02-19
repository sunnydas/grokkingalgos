package com.sunny.grokkingalgorithms.java.concurrency_2018.benchmark;

import com.sunny.grokkingalgorithms.java.concurrency_2018.FileSearch;
import com.sunny.grokkingalgorithms.java.concurrency_2018.FileSearchParallel;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sundas on 2/19/2018.
 */
public class TestFileSearchParallelBenchmark {

  @Benchmark
  public static void testSequentialSearch(){
    String fileDir = "";
    FileSearchParallel.searchFilesParallel(new File(fileDir), "sunny.txt");
  }

  public static void main(String[] args) throws Exception{
    Options opt = new OptionsBuilder()
        .include(TestFileSearchParallelBenchmark.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(opt).run();
  }
}
