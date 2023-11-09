#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define INF 1e9

using namespace std;

int d[20'001];
vector<pair<int,int>> adj[20'001];
priority_queue<pair<int,int>> pq;
int main() {
    int n, m, st;   cin >> n >> m >> st;
    for(int i=0;i<m;i++){
        int u,v,z;
        cin >> u >> v >> z;
        adj[u].push_back({v,z});
    }
    //거리 배열을 충분히 큰 값으로 초기화
    fill(d, d+20'001, INF);

    d[st] = 0; //시작 지점을 0으로 값 넣어줌

    pq.push({-0 ,st});

    while(!pq.empty()){
        int min_dist, min_index;
        tie(min_dist, min_index) = pq.top(); pq.pop();
        min_dist = -min_dist;

        if(min_dist != d[min_index]){continue;}

        for(int i=0; i<adj[min_index].size(); i++){
            int target_dist, target_index;
            tie(target_dist, target_index) = adj[min_index][i];

            if(d[target_index] >= target_dist + d[min_index]){
                d[target_index] = target_dist + d[min_index]
                pq.push({-(target_dist + d[min_index]), target_index});
            }
        }
    }
    for(int i=1;i<=n;i++){
        cout << d[i] << "\n";
    }


    return 0;
}