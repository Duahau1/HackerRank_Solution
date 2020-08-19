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

// Complete the alternate function below.
function alternate(s) {
let pattern =/^(.)(.)(\1\2)*\1?$/;
let searchString = [...s];
var uniqueItems = Array.from(new Set(s));
let arr =[...uniqueItems];
let min =0;
for(let i =0; i< arr.length; i++){
    for(let j = i+1; j< arr.length;j++){
        let retVal = searchString.filter((value,index,array)=>{
           return  value===arr[i] || value===arr[j]
        }).join("");

        if(pattern.test(retVal)&& retVal.length>min){
            min=retVal.length;
        }
    }
}
    return min;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const l = parseInt(readLine().trim(), 10);

    const s = readLine();

    const result = alternate(s);

    ws.write(result + '\n');

    ws.end();
}
