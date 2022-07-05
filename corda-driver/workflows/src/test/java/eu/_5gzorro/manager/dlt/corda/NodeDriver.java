package eu._5gzorro.manager.dlt.corda;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.corda.core.identity.CordaX500Name;
import net.corda.testing.driver.DriverParameters;
import net.corda.testing.driver.NodeParameters;
import net.corda.testing.node.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.corda.testing.driver.Driver.driver;

/**
 * Allows you to run your nodes through an IDE (as opposed to using deployNodes). Do not use in a production
 * environment.
 */
public class NodeDriver {
    public static void main(String[] args) {
        final List<User> rpcUsers =
                ImmutableList.of(new User("user1", "test", ImmutableSet.of("ALL")));

        driver(new DriverParameters()
            .withInMemoryDB(false)
            .withStartNodesInProcess(true)
            .withWaitForAllNodesToFinish(true), dsl -> {
                    try {
                        dsl.startNode(new NodeParameters()
                                .withCustomOverrides(Stream.of(new String[][]{
                                    {"h2port", "40001"},
                                    {"apiUrl", "http://localhost:8082"},
                                }).collect(Collectors.toMap(data -> data[0], data -> data[1])))
                                .withProvidedName(new CordaX500Name("PartyA", "London", "GB"))
                                .withRpcUsers(rpcUsers)).get();
                        dsl.startNode(new NodeParameters()
                                .withCustomOverrides(Stream.of(new String[][]{
                                    {"h2port", "40002"},
                                    {"apiUrl", "http://localhost:8082"},
                                }).collect(Collectors.toMap(data -> data[0], data -> data[1])))
                                .withProvidedName(new CordaX500Name("PartyB", "New York", "US"))
                                .withRpcUsers(rpcUsers)).get();
                    } catch (Throwable e) {
                        System.err.println("Encountered exception in node startup: " + e.getMessage());
                        e.printStackTrace();
                    }

                    return null;
                }
        );
    }
}
