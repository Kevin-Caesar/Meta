package com.example.config;

import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.SessionPool;
import com.vesoft.nebula.client.graph.SessionPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.BindSpaceFailedException;
import com.vesoft.nebula.client.graph.exception.ClientServerIncompatibleException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.net.NebulaPool;
import com.vesoft.nebula.client.graph.net.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin_Caesar
 * @date 2023/07/24
 */
public class NebulaConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(NebulaConfig.class);

    NebulaPool nebulaPool = new NebulaPool();

    private static void prepare() {
        NebulaPool pool = new NebulaPool();
        Session session;
        NebulaPoolConfig nebulaPoolConfig = new NebulaPoolConfig();
        nebulaPoolConfig.setMaxConnSize(100);
        List<HostAddress> addresses = Arrays.asList(new HostAddress("127.0.0.1", 9669));
        try {
            boolean initResult = pool.init(addresses, nebulaPoolConfig);
            if (!initResult) {
                LOGGER.error("pool init failed.");
                return;
            }

            session = pool.getSession("root", "nebula", false);
            session.execute("CREATE SPACE IF NOT EXISTS test(vid_type=fixed_string(20));" + "USE test;" + "CREATE TAG IF NOT EXISTS player(name string, age int);");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            pool.close();
        }

    }

    public NebulaPool getNebulaPool() {
        return nebulaPool;
    }

    public void test() throws IOErrorException {
        prepare();

        List<HostAddress> addresses = Arrays.asList(new HostAddress("127.0.0.1", 9669));
        String spaceName = "demo_basketballplayer";
        String user = "root";
        String password = "nebula";
        SessionPoolConfig sessionPoolConfig = new SessionPoolConfig(addresses, spaceName, user, password);
        SessionPool sessionPool = new SessionPool(sessionPoolConfig);
        if (!sessionPool.init()) {
            LOGGER.error("session pool init failed.");
            return;
        }
        ResultSet resultSet;
        try {
            resultSet = sessionPool.execute("match (v:player) return v limit 1;");
            System.out.println(resultSet.toString());
        } catch (IOErrorException | ClientServerIncompatibleException | AuthFailedException |
                 BindSpaceFailedException e) {
            e.printStackTrace();
            sessionPool.close();
            System.exit(1);
        }
    }
}
