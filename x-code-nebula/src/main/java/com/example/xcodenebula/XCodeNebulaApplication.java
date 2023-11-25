package com.example.xcodenebula;

import com.example.config.NebulaConfig;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XCodeNebulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XCodeNebulaApplication.class, args);

        NebulaConfig nebulaConfig = new NebulaConfig();
        try {
            nebulaConfig.test();

        } catch (IOErrorException e) {
            throw new RuntimeException(e);
        }

    }

}
