#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <tuple>

#define INF 1e9

using namespace std;

int d[20'001];
vector<pair<int,int>> adj[20'001];
priority_queue<pair<int,int>> pq; //우선순위 큐 선언
int main() {
    int n, m, st;   cin >> n >> m >> st;
    for(int i=0;i<m;i++){
        int u,v,z;
        cin >> u >> v >> z;
        //무방향 그래프 -> 양방향 그래프
        adj[u].push_back({v,z});
        adj[v].push_back({u,z});
    }
    //거리 배열을 충분히 큰 값으로 초기화
    fill(d, d+20001, INF);

    d[st] = 0; //시작 지점을 0으로 값 넣어줌

    pq.push({-0 ,st});

    while(!pq.empty()){
        int min_dist, min_index;
        tie(min_dist, min_index) = pq.top(); pq.pop();
        min_dist = -min_dist; //우선순위 큐에 들어가있는 값을 +로 변경해서 값 확인

        //최신값이 아닌 경우
        //이미 min_index를 뽑아본적이 있어 계산에 이용된 노드인 경우
        if(min_dist != d[min_index]){continue;} 

        //최단 거리 갱신
        for(int i=0; i<adj[min_index].size(); i++){
            int target_dist, target_index;
            tie(target_index, target_dist) = adj[min_index][i];

            // 현재 위치에서 연결된 간선으로 가는 것이 더 작다면
            if(d[target_index] > target_dist + d[min_index]){
                d[target_index] = target_dist + d[min_index];
                pq.push({-(target_dist + d[min_index]), target_index});
            }
        }
    }
    //결과 출력 (시작점으로 부터 출력)
    for(int i=1;i<=n;i++){
        if(d[i] == INF){cout << -1 << "\n";}
        else {cout << d[i] << "\n";}
    }


    return 0;
}