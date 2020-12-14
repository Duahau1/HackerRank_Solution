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

// Complete the twoPluses function below.
function twoPluses(ogrid) {
    let resetGrid= ogrid.map(value=>{
        return value.match(/[A-Z]/g);
    });
    let retVal=[];
    for(let i=0; i<ogrid.length;i++){
        retVal.push([])
    }
    let count=0;
let width = ogrid.length%2==0?ogrid.length-1:ogrid.length;
let height = ogrid[0].length%2==0?ogrid[0].length-1: ogrid[0].length;
let max = Math.min(width,height);

for(let w=max; w>=3;w-=2){
    let grid=ogrid.map(value=>{
        return value.match(/[A-Z]/g);
    });
for(let z=w;z>=3;z-=2){
for(let i =1; i<grid.length-1; i++){
    for(let j = 1; j<grid[i].length-1;j++){
       let increment= Math.floor(z/2);
       let temp=increment;
       if(grid[i][j]==='G'
       &&i+increment<grid.length
       &&i-increment>=0
       &&j-increment>=0
       &&j+increment<grid[0].length){
        while(temp>0&&grid[i-temp][j]==='G'
                &&grid[i][j-temp]==='G'
                &&grid[i+temp][j]==='G'
                &&grid[i][j+temp]==='G'){
                temp--;
        }
        if(temp==0){
            retVal[count].push(z*2-1);   
            while(increment>0){   
                    grid[i-increment][j]='X';
                    grid[i][j-increment]='X';
                    grid[i+increment][j]='X';
                    grid[i][j+increment]='X';
                    increment--;   
                }
        console.log(grid)
        console.log("------------")
        }
       } 
    }
}
}
count++;
}    
            console.log(retVal)

    let ret= retVal.map(value=>
    {
        if(value.length>1){
            return value[0]*value[1];
        }
        else if(value.length==1){
            return value[0];
        }
        else{
            return 0
        }
    }
    ).sort(function(a,b){return b-a})[0];
    return ret!=0?ret:1;
    


}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nm = readLine().split(' ');

    const n = parseInt(nm[0], 10);

    const m = parseInt(nm[1], 10);

    let grid = [];

    for (let i = 0; i < n; i++) {
        const gridItem = readLine();
        grid.push(gridItem);
    }

    let result = twoPluses(grid);

    ws.write(result + "\n");

    ws.end();
}
