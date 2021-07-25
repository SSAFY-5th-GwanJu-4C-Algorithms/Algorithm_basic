let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

function solution(input) {
  let T = Number(input[0]);
  let idx = 1;
  for (let i = 0; i < T; i++) {
    const p = input[idx++];
    const commandLength = p.length;
    let num = Number(input[idx++]);
    let array = input[idx++];
    array = array.slice(1, -1);

    let flag = false;
    for (let i = 0; i < commandLength; i++) {
      if (p[i] === "R") {
        array = array.split(",").reverse().join(",");
      } else {
        if (num === 0) {
          console.log("error");
          flag = true;
          break;
        }
        array = array.slice(2);
        num--;
      }
    }

    if (!flag) {
      console.log("[" + array + "]");
    }
  }
}

solution(input);
