

var flag=true;  //标记位





function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	
	//console.log($(obj).val());
	switch($(obj).attr('name')) {
		case "userName":
			if(obj.value == "") {
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else { //验证用户名唯一性 把名字传出去并转码防止中文出错 防止有缓存 去  usernamecheck
				var url="susernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
			
				
				// "false"数据库有此名字不能传入 "true"数据库没有此名字 可以传入
				//get请求url 请求的有返回执行function(data)函数把返回的数据给data
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html('用户名不能使用！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}
					
				});
				
			}
		
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.html('用户名密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "repassWord":
			if(obj.value == "") {
				msgBox.html('用户名确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val() !=$('input[name="passWord"]').val() ){
				msgBox.html('两次输入的密码不一致');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
	
			
	
	}
	
}

function CheckNews(obj) {
	var msgBox = $(obj).next('span');
	
	//console.log($(obj).val());
	switch($(obj).attr('name')) {
		case "newsid":
			if(obj.value == "") {
				msgBox.html('新闻id不能为空必须为数字');
				msgBox.addClass('error');
				flag=false;
			}else { //验证用户名唯一性 把名字传出去并转码防止中文出错 防止有缓存 去  usernamecheck
				var url="newsnamecheck?id="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
			
				
				// "false"数据库有此名字不能传入 "true"数据库没有此名字 可以传入
				//get请求url 请求的有返回执行function(data)函数把返回的数据给data
				$.get(url, function(data){
			//	alert(data);
					
					if(data == "false") {
						msgBox.html('新闻id不能使用！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html();
						flag=true;
					}
					
				});
				
			}
		
			break;
		
	
	}
	
}


function checkForm(frm) {//frm是传过来的表单 由于input有男女有提交所以要准确定位到需要验证的input
	//需要验证的input都有onblur属性 所以定向到onblur 的 input进行循环验证
	
	var els = frm.getElementsByTagName('input');
	
	// onblur 这个属性的才是需要验证
	
	for(var i=0; i<els.length; i++) {
		
		if(els[i] !=null ){
			if(els[i].getAttribute("onblur")) {
				CheckItem(els[i]);
			}
		}
	}
	
	return flag; //返回标记位
	
}