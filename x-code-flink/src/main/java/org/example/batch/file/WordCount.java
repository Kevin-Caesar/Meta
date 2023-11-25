package org.example.batch.file;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.connector.source.SourceReader;
import org.apache.flink.api.connector.source.SourceReaderFactory;
import org.apache.flink.api.connector.source.lib.util.IteratorSourceReaderBase;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author Kevin_Caesar
 * @date 2023/11/25
 */
public class WordCount {

    public static void main(String[] args) throws Exception {
//        String inputFile = "/root/images.txt";
        String inputFile = "D:\\Downloads\\Destination Gateway Genmask Flags Metric.txt";

        String outputFile = "D:\\Downloads\\sumMetric.txt";
//        String outputFile = "/root/test.csv";

        ExecutionEnvironment ee = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<String> metric = ee.readTextFile(inputFile);

        FlatMapOperator<String, Tuple2<String, Integer>> flatMapOperator = metric.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] s = value.split(" ");

                for (String s1 : s) {
                    out.collect(new Tuple2<>(s1, 1));
                }
            }
        });

        AggregateOperator<Tuple2<String, Integer>> sum = flatMapOperator.groupBy(0).sum(1);

        sum.writeAsCsv(outputFile);
    }


}
