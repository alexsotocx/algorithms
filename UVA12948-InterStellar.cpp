//Esteban Foronda Sierra
using namespace std;
#include <algorithm>
#include <iostream>
#include <iterator>
#include <numeric>
#include <sstream>
#include <fstream>
#include <cassert>
#include <climits>
#include <cstdlib>
#include <cstring>
#include <string>
#include <cstdio>
#include <vector>
#include <cmath>
#include <queue>
#include <deque>
#include <stack>
#include <list>
#include <map>
#include <set>

template <class T> string toStr(const T &x)
{ stringstream s; s << x; return s.str(); }
template <class T> int toInt(const T &x)
{ stringstream s; s << x; int r; s >> r; return r;}

#define D(x) cout << #x << " " << x << endl
#define MAXN 310
#define ll long long
#define pii pair <ll, ll>
#define piii pair <pii, ll>
#define psi pair <string, int>
#define INF 10000000000ll
vector <vector<piii> > g(MAXN, vector<piii>());
map <string, int> planets;
pii d[MAXN][MAXN];

void bellmanFord(int start, int stops,  int n) {
  for(int i = 0; i < n; ++i) d[0][i] = pii(INF, INF);
  d[0][start] = pii(0LL, 0LL);
  for(int x = 1; x <= stops; ++x) {
    for(int k = 0; k < n; ++k) d[x][k] = d[x - 1][k];
    for(int i = 0; i < n; ++i) {
      for(int j = 0; j < g[i].size(); ++j) {
        //D(x);D(i);D(j);
        piii next = g[i][j];
        int nextNode = next.first.first;
        int cost = next.first.second;
        int t = next.second;
        //D(nextNode);
        //D(cost);
        //D(t);

        pii aux = pii(d[x - 1][i].first + cost, d[x - 1][i].second + t);
        //D(aux.first);
        //D(aux.second);
        //D(d[x - 1][nextNode].first);
        //D(d[x - 1][nextNode].second);
        d[x][nextNode] = min(d[x][nextNode], aux);
        //D(d[x][nextNode].first);
        //D(d[x][nextNode].second);
        //D("------------");
      }
    }
  }
}

int main(){
  int p, f, q;
  bool prints = false;
  while(cin >> p >> f >> q) {
    if(prints){
      printf(".\n");
    }
    prints = true;
    for(int i = 0; i < p; ++i) {
      string name;
      cin >> name;
      planets[name] = i;
      g[i] = vector<piii>();
    }
    for(int i = 0; i < f; ++i) {
      int c, t;
      string x, y;
      cin >> x >> y >> c >> t;
      g[planets[x]].push_back(piii(pii(planets[y], c), t));
    }
    string start;
    cin >> start;
    int valueStart = planets[start];
    vector <psi> queries;
    int maximunStops = -1;
    for(int i = 0; i < q; ++i) {
      string name;
      int stops;
      cin >> name >> stops;
      maximunStops = max(maximunStops, stops + 1);
      queries.push_back(psi(name, min(stops + 1, p - 1)));
    }
    bellmanFord(valueStart, min(maximunStops + 1, p), p);
    for(int i = 0; i < q; ++i) {
      string name = queries[i].first;
      int stops = queries[i].second;
      int nameValue = planets[name];
      if(d[stops][nameValue].first == INF && d[stops][nameValue].second == INF)
        printf("* *\n");
      else
        printf("%lld %lld\n", d[stops][nameValue].first, d[stops][nameValue].second);
    }

  }
	return 0;
}
