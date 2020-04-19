/**
 * 前端页面查询
 */
var lists = document.querySelectorAll('.li');
var filter = document.getElementById('filter');

filter.addEventListener('blur',dofilter);
filter.addEventListener('focus',doclear);

function doclear() {
	filter.value='';  
    lists.forEach((item,index)=>{
    	
     item.parentElemet.parentElement.style = 'block';   
       
    })
};

function dofilter() {
    var value = filter.value;
   
    	lists.forEach((item,index)=>{
            
        	var str = item.children[1].textContent.toString();

           if (str.indexOf(value) != -1) {
               item.parentElement.parentElement.style.display= 'block';
           
           }else{
            item.parentElement.parentElement.style.display = 'none';
           }
           
       })
    
   }