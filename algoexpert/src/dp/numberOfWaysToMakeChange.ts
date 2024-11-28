function safeGetValue({memo, i, j, d}:{memo: number[][], d: number, i:number, j: number}) {
  if (i < 0 || i >= memo.length) return d;
  if (j < 0 || j >= memo[i].length) return d;
  return memo[i][j];
}
export function numberOfWaysToMakeChange(n: number, denoms: number[]) {
  denoms.sort();
  // j -> CoinAmount
  // i -> CoinValue
  let memo: number[][] = [];
  denoms.forEach((_, i) => {
    memo.push(new Array(n + 1));
    memo[i][0] = 1;
  });
  
  for(let i = 0; i < denoms.length; i++) {
    for(let j = 1; j <= n; j++) {
      const v = safeGetValue({memo, i: i - 1, j, d: 0});
      let h = safeGetValue({memo, i, j: j - denoms[i], d: 0});
      memo[i][j] = v + h;
    }
  }

  return memo[denoms.length - 1][n];
}
