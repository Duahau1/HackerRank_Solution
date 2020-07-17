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
 * Complete the 'getTotalGoals' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING team
 *  2. INTEGER year
 */
const fetch = require("axios");
async function getTotalGoals(team, year) {
let url=`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team1=${team}&page=${1}`;
let count = 0; 
let datas1 = await fetch(url).then((res)=>res.data);
let total_pages = datas1.total_pages;
let total = datas1.total;
for(let i =1 ; i <=total_pages ; i ++){  
  url =`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team1=${team}&page=${i}`;
  datas1 = await fetch(url).then((res)=>res.data);
  for(let product in datas1.data){
      count+= Number(datas1.data[product].team1goals);
  }
}
//Team 2
let url2=`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team2=${team}&page=${1}`;
let count2 = 0; 
let datas2  = await fetch(url2).then((res)=>res.data);
let total_pages2 = datas2.total_pages;
let total2 = datas2.total;
for(let i =1 ; i <=total_pages2 ;i ++){  
  url2 =`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team2=${team}&page=${i}`;
  datas2 = await fetch(url2).then((res)=>res.data);
  for(let product in datas2.data){
      count2+= Number(datas2.data[product].team2goals);
  }
}
return count+count2; 
}

async function main() {
