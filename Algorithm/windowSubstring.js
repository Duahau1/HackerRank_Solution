function MinWindowSubstring(strArr) { 
//store K in hashtable then loop through N to with substring length>= K to find
let map = new Map();
let retVal={
  start:0,
  end: strArr[0].length-1,
  leng:strArr[0].length
};
[...strArr[1]].forEach(val=>{
  if(map.get(val)==undefined){
    map.set(val,1);
  }
  else{
    map.set(val,map.get(val)+1);
  }
})
for(let i = 0; i<strArr[0].length;i++){
  let temp = new Map(map);
  for(let j = i;j<strArr[0].length;j++){
      
      if(temp.get(strArr[0].charAt(j))!=undefined && temp.get(strArr[0].charAt(j))==1 ){
          temp.delete(strArr[0].charAt(j));
      }
      else if(temp.get(strArr[0].charAt(j))!=undefined && temp.get(strArr[0].charAt(j))>1 ){
          temp.set(strArr[0].charAt(j),temp.get(strArr[0].charAt(j))-1);
      }
      if(temp.size==0 && retVal.leng>j-i+1){
        retVal={
         start:i,
         end:j,
         leng:j-i+1
        };
        break;
      }
  }
  
}
  return strArr[0].substring(retVal.start,retVal.end+1); 

}
   
// keep this function call here 
console.log(MinWindowSubstring(readline()));
