package io.github.precodertech.codingjava;

import java.util.List;

/** There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
*/

//TO-DO
class GetCriticalConnections {
    public static void main(String[] args) {
        
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (int server = 0; server < n; server++) {
            System.out.println(ifConnectionExists(server, server+1, connections));
        }
        return null;
    }
    
    public boolean ifConnectionExists(int server1, int server2, List<List<Integer>> connections) {
        for (List<Integer> connection: connections) {
            if (connection.contains(server1) && connection.contains(server2)) {
                return true;
            }
            if (connection.contains(server1) || connection.contains(server2)) {
                if (connection.get(0) == server1)
                    server1 = connection.get(1);
                if (connection.get(0) == server2)
                    server2 = connection.get(1);
                if (connection.get(1) == server1)
                    server1 = connection.get(0);
                if (connection.get(1) == server2)
                    server2 = connection.get(0);
            }
        }
        return false;
    }
}