package org.example;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment ee = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> stringDataSource = ee.readTextFile("/root/images.txt");

        stringDataSource.print();


        System.out.println("Hello World!");
    }
}
