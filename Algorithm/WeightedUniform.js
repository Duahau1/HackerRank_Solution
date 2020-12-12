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

// Complete the weightedUniformStrings function below.
function weightedUniformStrings(ss, queries) {
    let map = new Map();
    let tempMap = new Map();
    let s=ss.match(/(.)(\1)*/gm);
    let tempSlot=0;
    for(let i = 0; i<=25;i++){
        map.set(String.fromCharCode(i+65).toLowerCase(),i+1);
    }
    for(let i =0 ;i<s.length;i++){
        if(tempMap.get(s[i].charAt(0))!=null&&tempMap.get(s[i].charAt(0))>s[i].length){
            continue;
        }
        else{
            tempMap.set(s[i].charAt(0),s[i].length);
        }
    }
    return queries.map((value)=>{
        let bool = false;
        tempMap.forEach((key,entry)=>{
            if( Number(value%map.get(entry))==0&&Number(value/map.get(entry))<=key ){
                bool =true;
            }
        })
        if(bool){
            return 'Yes';
        }
        return 'No';
    })
    
    
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    const queriesCount = parseInt(readLine(), 10);

    let queries = [];

    for (let i = 0; i < queriesCount; i++) {
        const queriesItem = parseInt(readLine(), 10);
        queries.push(queriesItem);
    }

    let result = weightedUniformStrings(s, queries);

    ws.write(result.join("\n") + "\n");

    ws.end();
}
