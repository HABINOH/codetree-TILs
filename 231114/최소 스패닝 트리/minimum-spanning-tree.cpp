#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void f_union(int x, int y);
int f_find(int x);
bool check_tree(int x, int y);

vector<pair<int,pair<int,int>>> adj;
int uf[10'001];
int result;

int main() {
    //노드, 간선 입력
    int n,m;    cin >> n >> m;
    //간선의 개수 만큼 그래프 입력 (비용, from, to)
    for(int i=0;i<m;i++){
        int u,v,w;
        cin >> u >> v >> w;
        adj.push_back({w,{u,v}});
    }
    //비용 기준으로 정렬
    sort(adj.begin(), adj.end());
    
    //노드 개수만큼 union 배열 초기화
    for(int i=1;i<n;i++){uf[i] = i;}
    //그래프 개수만큼 union, find 해서 스패닝 트리 찾기
    for(int i=0;i<adj.size();i++){
        //같은 부모를 가르키고 있는지 확인(아닐 때만 실행)
        if(check_tree(adj[i].second.first, adj[i].second.second)){ 
            //연결시킴(사이클 방지)
            f_union(adj[i].second.first, adj[i].second.second);
            result += adj[i].first;
        }
    }

    //결과 출력
    cout << result;
    
    return 0;
}

void f_union(int x, int y){
    int xx = f_find(x);
    int yy = f_find(y);

    uf[yy] = xx;
}

int f_find(int x){
    if(uf[x] == x){return x;}
    return uf[x] = f_find(uf[x]);
}

bool check_tree(int x, int y){
    x = f_find(x);
    y = f_find(y);
    if(x == y){return false;}
    else {return true;}
}