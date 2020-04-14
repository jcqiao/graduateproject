function change(img) {
		//用户点一下获取下地址getcode生成新的 由于浏览器有缓存机制所以
	//img.src="getcode"无效 因此加上时间 每次src变了就可以
	img.src="getcode?"+new Date().getTime();
}


var flag=true;  //标记位


function FocusItem(obj) {
	
	//表单name值判断下是不是表单
	if($(obj).attr('name') == 'veryCode') {
		//验证码
		$(obj).next().next().html('').removeClass('error');
		
	}else {
		//去除span标签的文本内容和类
		$(obj).next('span').html('').removeClass('error');
		
	}
	

	
}

function CheckItem(obj) {
	var regpassWord = /^(?![^a-zA-Z]+$)(?!\D+$)/;
	var regMobile = /^1[3456789]\d{9}$/;
	var msgBox = $(obj).next('span');
	
	//console.log($(obj).val());
	switch($(obj).attr('name')) {
		case "userName":
			if(obj.value == "") {
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else { //验证用户名唯一性 把名字传出去并转码防止中文出错 防止有缓存 去  usernamecheck
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				console.log(url);
				
			
				
				// "false"数据库有此名字不能传入 "true"数据库没有此名字 可以传入
				//get请求url 请求的有返回执行function(data)函数把返回的数据给data
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html('用户名不能使用！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.removeClass('error');
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
			}else if(regpassWord.test(obj.value) && obj.value.length >= 6) {
				
				flag=true;
			}else{
				msgBox.html('用户密码必须是字母数字组合至少6位');
				msgBox.addClass('error');
				flag=false;
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
		case "mobile":
			console.log($(obj));
			if(obj.value == "") {
				msgBox.html('手机号不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if(regMobile.test(obj.value) ) {
				
				flag=true;
			}else{
				msgBox.html('手机号输入错误');
				msgBox.addClass('error');
				flag=false;
			}
			break;
		case "veryCode":
			var  numshow = $(obj).next().next();
			
			if(obj.value == "") {
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag=false;
			}else {
			
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				$.get(url, function(data){
					if(data=="false") {
						numshow.html('验证码输入有误');
						numshow.addClass('error');
						flag=false;
					}else{
						numshow.removeClass('error');
						flag=true;
					}
					
				});
			
			}
			break;
			
	
	}
	
}
var flagg=true;
function Check(obj) {
	var msgBox = $(obj).next('span');
	
	//console.log($(obj).val());
	switch($(obj).attr('name')) {
		case "userName":
			console.log(obj.value);
			if(obj.value == "") {
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flagg=false;
			}else { //验证用户名唯一性 把名字传出去并转码防止中文出错 防止有缓存 去  usernamecheck
				var url="susernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
			
				
				// "false"数据库有此名字不能传入 "true"数据库没有此名字 可以传入
				//get请求url 请求的有返回执行function(data)函数把返回的数据给data
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html('用户名不能使用！');
						msgBox.addClass('error');
						flagg=false;
					}else{
						msgBox.html().removeClass('error');
						flagg=true;
					}
					
				});
				
			}
		
			break;
		case "code":
			 var format = /^(([1][1-5])|([2][1-3])|([3][1-7])|([4][1-6])|([5][0-4])|([6][1-5])|([7][1])|([8][1-2]))\d{4}(([1][9]\d{2})|([2]\d{3}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))\d{3}[0-9xX]$/;
//			console.log(obj.value);
//			console.log(format.test(obj.value));
			 if(obj.value == ""){
				 msgBox.html('身份证不能为空！');
					msgBox.addClass('error');
					flagg=false;
			 }else if(!obj.value.match(format)){
				 msgBox.html('身份证输入错误！');
					msgBox.addClass('error');
					flagg=false;
			 }else{
					msgBox.html().removeClass('error');
					flagg=true;
				}
			 break;
			
		case "email":
			var isemail=/^\w+([-\.]\w+)*@\w+([\.-]\w+)*\.\w{2,4}$/;
			if(obj.value ==''){
				 msgBox.html('邮箱不能为空');
				 msgBox.addClass('error');
					flagg=false;
				 }else if(!obj.value.match(isemail)){
					 msgBox.html('邮箱格式错误！');
						msgBox.addClass('error');
						flagg=false;
				 }else{msgBox.html().removeClass('error');
					flagg=true;}
			break;
		case "mobile":
			var ismobile=/^1[^12]\d{9}$/;
			if(obj.value ==''){
				 msgBox.html('电话不能为空');
				 msgBox.addClass('error');
					flagg=false;
				 }else if(!obj.value.match(ismobile)){
					 msgBox.html('手输入错误！');
						msgBox.addClass('error');
						flagg=false;
				 }else{msgBox.html().removeClass('error');
					flagg=true;}
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