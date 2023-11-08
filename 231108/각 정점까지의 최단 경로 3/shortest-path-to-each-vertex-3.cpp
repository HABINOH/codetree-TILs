#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

int graph[101][101];
bool vis[101];
int dist[101];

int main() {
    fill(dist, dist+101, 1e9);
    int vertax, edge;   cin >> vertax >> edge;
    for(int i=0;i<edge;i++){
        int u, v, z;

        cin >> u >> v >> z;
        graph[u][v] = z;
    }
    dist[1] = 0;
    for(int i=1; i<=vertax; i++){
        int min_index = -1;
        for(int j=1;j<=vertax;j++){ //dist값 가장 작은거 찾기
            if(vis[j]){continue;}
            if(min_index == -1 || dist[min_index] > dist[j]){
                min_index = j;
            }
        }
        vis[min_index] = true;

        for(int j=1;j<=vertax; j++){
            if(graph[min_index][j] == 0){continue;} //간선 없을 때 넘김
            dist[j] = min(dist[j], dist[min_index] + graph[min_index][j]);
        }
    }
    for(int i=2; i<=vertax; i++){
        if(dist[i] == 1e9){cout << -1 << "\n";}
        else {cout << dist[i] << "\n";}
    }
    return 0;
}