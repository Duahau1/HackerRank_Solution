'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}



/*
 * Complete the 'getNumDraws' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER year as parameter.
 */
const fetch = require('axios');
async function getNumDraws(year) {
let count = 0; 
for(let i = 0 ; i <= 10 ; i ++){  
  let url =`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team1goals=${i}&team2goals=${i}&page=${1}`;
  let datas1 = await fetch(url).then((res)=>res.data);
  count+=datas1.total;
}
return count;

}

async function main() {
