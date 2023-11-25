package org.example.stream.port;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author Kevin_Caesar
 * @date 2023/11/25
 */
public class WordCountStream {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
//        String inputFile = "/root/images.txt";
        String inputFile = "D:\\Downloads\\Destination Gateway Genmask Flags Metric.txt";

        String outputFile = "D:\\Downloads\\sumMetric.txt";
//        String outputFile = "/root/test.csv";


        DataStreamSource<String> metric = see.readTextFile(inputFile);
        see.setParallelism(2);
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = metric.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] s = value.split(" ");

                for (String s1 : s) {
                    out.collect(new Tuple2<>(s1, 1));
                }
            }
        }).keyBy(0).sum(1);

        sum.print();
        see.execute();
    }
}
