import React,{useState,useEffect} from 'react';
let Articles =()=>{

  const [results,setResults] = useState([]);
  const [pages,setPages] = useState([]);
  const [pageContent,setContent] = useState(0);
  console.log('re')
  useEffect(()=>{
    (async()=>{
    let url ="https://jsonmock.hackerrank.com/api/articles?page=1";
    let data = await fetch(url).then(res=>res.json());
    let total =data.total_pages;
    let pageNum =[];
    let tempObj =[];
    for(let i = 1; i<=total;i++){
      let tempUrl =`https://jsonmock.hackerrank.com/api/articles?page=${i}`
      let tempData = await fetch(tempUrl).then(res=>res.json());
      tempObj.push(tempData.data);
      pageNum.push(i);
    }
    console.log('render');
    setResults(tempObj);
    setPages(pageNum);
  })();
  
},[])
function handleClick(e){
  setContent(e.target.innerHTML-1);

}
    return (
      <React.Fragment>
        <div className="pagination">
          { pages.map((cur)=>{
           return <button onClick={handleClick} data-testid="page-button" key={`page-button-${cur}`}>{cur}</button>})}
        </div>
        <ul className="results">
        {results.length >0 ?
        results[pageContent].map((cur,i)=>{
            if(cur.title!=null&&cur.title.length>2){
              return <li key={`title-${i}`}data-testid="result-row">{cur.title}</li>
            }
            return '';
          }) :null
          
        }
        </ul>
      </React.Fragment>
    );
  
}

export default Articles;
