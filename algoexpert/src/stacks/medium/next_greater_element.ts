export function nextGreaterElement(array: number[]) {
  const stack: number[] = [];
  const result: number[] = new Array(array.length);

  const loopArray = () => {
    for(let i = array.length - 1; i >= 0; i--) {
      let nextMajor = -1;
      while(stack.length > 0) {
        if (stack[stack.length -1] <= array[i]) stack.pop();
        else {
          nextMajor = stack[stack.length - 1];
          break;
        }
      }

      stack.push(array[i]);
      result[i] = nextMajor;
    }
  }

  loopArray();
  loopArray();
  return result;
}

