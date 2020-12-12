'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the icecreamParlor function below.
function icecreamParlor(m, arr) {
let map = new Map();
let temp  =[];
for (let i =0; i< arr.length;i++){
    if(map.get(arr[i])==null){
        map.set(arr[i],[i+1]);
    }
    else{
        if(map.get(arr[i]).length<2)
        map.set(arr[i],[map.get(arr[i])[0],i+1]);
    }    
}
for(let i =0; i< arr.length;i++){
    if(m-arr[i]==arr[i]&& map.get(arr[i]).length>1){
        let temp=map.get(arr[i]);
        return [temp[0],temp[1]];
    }
    else if(map.get(m-arr[i])!=null&&m-arr[i]!==arr[i]){
        return i+1<map.get(m-arr[i])[0]?[i+1,map.get(m-arr[i])[0]]:[map.get(m-arr[i])[0],i+1];
    }
}
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const m = parseInt(readLine(), 10);

        const n = parseInt(readLine(), 10);

        const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

        let result = icecreamParlor(m, arr);

        ws.write(result.join(" ") + "\n");
    }

    ws.end();
}
