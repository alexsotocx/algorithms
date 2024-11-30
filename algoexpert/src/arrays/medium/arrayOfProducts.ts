function safeGet(array: number[], pos: number, deff: number) {
  if (!(pos >= 0 && pos < array.length)) return deff;
  return array[pos];
}
export function arrayOfProducts(array: number[]) {
  const n = array.length;
  const rightZum = new Array(n).fill(1);
  const leftZum = new Array(n).fill(1);

  array.forEach((e, i) => {
    const revN = n - i - 1;
    rightZum[i] *= safeGet(rightZum, i - 1, 1) * e;
    leftZum[revN] *= safeGet(leftZum, revN + 1, 1) * array[revN];
  });

  array.forEach((e, i) => {
    array[i] = safeGet(rightZum, i - 1, 1);
    array[i] *= safeGet(leftZum, i  + 1, 1) ;
  })
  return array;
}


