'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the luckBalance function below.
function luckBalance(k, contests) {
let sortedContest = contests.filter(value=>value[1]==1).sort(function(a,b){return -a[0]+b[0]});
let retVal = contests.filter(value=>value[1]==0).reduce((prev,curr)=>{
    return prev+curr[0];
},0)
let win= k;
for(let i =0; i<sortedContest.length; i++){
    if(sortedContest[i][1]===1){
        if(win>0){
        retVal+=sortedContest[i][0];
        }
        else if(win<=0){
        retVal-=sortedContest[i][0];
        }
        win--;
    }
    else if(sortedContest[i][1]===0){
        retVal+=sortedContest[i][0];
    }
    
}
return retVal;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    let contests = Array(n);

    for (let i = 0; i < n; i++) {
        contests[i] = readLine().split(' ').map(contestsTemp => parseInt(contestsTemp, 10));
    }

    const result = luckBalance(k, contests);

    ws.write(result + '\n');

    ws.end();
}
