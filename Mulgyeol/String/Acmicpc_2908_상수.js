let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

function solution(input) {
  let A = Number(input[0].split("").reverse().join(""));
  let B = Number(input[1].split("").reverse().join(""));

  console.log(A > B ? A : B);
}

solution(input);
