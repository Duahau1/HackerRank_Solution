class Node {
  constructor(value){
    this.parent=null;
    this.child=[];
    this.value=value;
  }
  setParent(parent){
    this.parent=parent;
  }
  addChild(val){
    this.child.push(val);
  }
}
function TreeConstructor(strArr) { 
//Check if a node has more than 1 parent
//Check if a node has more than 2 children
let parent = {};
let children={};
for(let i =0;i<strArr.length ;i++){
  let value = strArr[i];
  let arr= value.match(/\d+/g);
  if(!children[arr[0]]){
    children[arr[0]]= new Node(arr[0]);
    if(!parent[arr[1]]){
      parent[arr[1]]= new Node(arr[1]);
      children[arr[0]].setParent(parent[arr[1]]);
      parent[arr[1]].addChild(children[arr[0]]);
    }
    else if(parent[arr[1]] &&  parent[arr[1]].child.length>=2){
      return false;
    }
    else{
      children[arr[0]].setParent(parent[arr[1]]);
      parent[arr[1]].addChild(children[arr[0]]);
    }
  }
  else if(children[arr[0]]){
    return false;
  }
 
}  
  return true; 

}
   
// keep this function call here 
console.log(TreeConstructor(readline()));
