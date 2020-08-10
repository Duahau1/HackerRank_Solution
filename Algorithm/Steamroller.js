function rollArray(arr){
  if(arr[0]==undefined){
    return ;
  }
  else{
    if(!Array.isArray(arr[0])){
      return arr[0];
    }
    else{
    arr = arr[0];
    return rollArray(arr);
    }
  }
}

function steamrollArray(arr) {
  //console.log(arr);
  let temp =[];
  for(let i =0; i< arr.length; i++){
    if(!Array.isArray(arr[i])){
        temp.push(arr[i]);
    }
    else{
    for(let j = 0; j < arr[i].length;j++){
      if(!Array.isArray(arr[i][j])){
        temp.push(arr[i][j]);
       }
       else{
         temp.push(rollArray(arr[i][j]));
       }
     }
    }
  }
  return temp;
}
console.log(steamrollArray([1, [2], [3, [[4]]]]));

//, [2], [3, [[4]]]
