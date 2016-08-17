$("#queryCategoryLevel1").change(function(){
	var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
	if(queryCategoryLevel1 != '' && queryCategoryLevel1 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"categorylevellist.json",//请求的url
			data:{pid:queryCategoryLevel1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#queryCategoryLevel2").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].categoryName);
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel2").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载二级分类失败！");
			}
		});
	}else{
		$("#queryCategoryLevel2").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#queryCategoryLevel2").html(options);
	}
	
});

$("#queryCategoryLevel2").change(function(){
	var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
	if(queryCategoryLevel2 != '' && queryCategoryLevel2 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"categorylevellist.json",//请求的url
			data:{pid:queryCategoryLevel2},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#queryCategoryLevel3").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].categoryName);
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel3").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载三级分类失败！");
			}
		});
	}else{
		$("#queryCategoryLevel3").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#queryCategoryLevel3").html(options);
	}
});


$(".addVersion").on("click",function(){
	var obj = $(this);
	window.location.href="appversionadd/"+ obj.attr("appinfoid");
});
$(".modifyVersion").on("click",function(){
	var obj = $(this);
	window.location.href="appversionmodify/"+ obj.attr("appinfoid");
});
$(".modifyAppInfo").on("click",function(){
	var obj = $(this);
	window.location.href="appinfomodify/"+ obj.attr("appinfoid");
});
$(".viewApp").on("click",function(){
	var obj = $(this);
	window.location.href="appview/"+ obj.attr("appinfoid");
});

$(".deleteApp").on("click",function(){
	var obj = $(this);
	if(confirm("你确定要删除APP应用【"+obj.attr("appsoftwarename")+"】及其所有的版本吗？")){
		$.ajax({
			type:"GET",
			url:"delapp.json",
			data:{id:obj.attr("appinfoid")},
			dataType:"json",
			success:function(data){
				if(data.delResult == "true"){//删除成功：移除删除行
					alert("删除成功");
					obj.parents("tr").remove();
				}else if(data.delResult == "false"){//删除失败
					alert("对不起，删除AAP应用【"+obj.attr("appsoftwarename")+"】失败");
				}else if(data.delResult == "notexist"){
					alert("对不起，APP应用【"+obj.attr("appsoftwarename")+"】不存在");
				}
			},
			error:function(data){
				alert("对不起，删除失败");
			}
		});
	}
});

	
