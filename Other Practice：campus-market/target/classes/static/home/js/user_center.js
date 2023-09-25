function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); 
            return null; //返回参数值
        }
var userid = getUrlParam('id');

$(document).ready(function(){
	//inituser(userid);
	//inituserpros(userid);
})

function inituser(id){
	
}


function inituserpros(uid){
	$.ajax({
		type:"POST",
		url:"userServlet",
		dataType:"json",
		data:{"uid":uid,"flag":2},
		success:function(resp){
		var count = resp.length
		for(var i = 0;i<resp.length;i++){
			if(resp[i].state==1){
			var mypro1 = $('<div class="enshr_each" id="prolist">  ' +
					'<div class="enshr_info"><h2><a href="product_detail.jsp?pid='+resp[i].pid+'" '+
					'title="坚果pro">'+resp[i].pname+'</a></h2><p>'+resp[i].pdesc+'</p>'+
					'<div class="enshr_state"><span id="prostate">Status: On sell'+resp[i].state+'</span>' +
					'&nbsp;&nbsp;<span id="prostate">On shelf date: '+resp[i].creatTime+'</span>'+
					'<span class="enshrine_it" onclick="sellout('+resp[i].pid+');">Confirmed Sold</span>'+
					'<span class="enshrine_it make_edition" onclick="offshelf('+resp[i].pid+');">Off shelf</span>'+
					'<span class="enshrine_it make_edition" onclick="refresh('+resp[i].pid+');">Refresh</span>'+
	                '<a href="product_release.jsp?pid='+resp[i].pid+'" target="_top"><span class="enshrine_it  make_edition">Edit</span></a> '+
	                '</div></div><a href="product_detail.jsp?pid='+resp[i].pid+'">'+
	                '<img class="enshr_ph" src="'+resp[i].pimage+'" alt="'+resp[i].pname+'"></a></div>')
			}
	        if(resp[i].state==0){
			var mypro1 = $('<div class="enshr_each" id="prolist">  ' +
					'<div class="enshr_info"><h2><a href="product_detail.jsp?pid='+resp[i].pid+'" '+
					'title="坚果pro">'+resp[i].pname+'</a></h2><p>'+resp[i].pdesc+'</p>'+
					'<div class="enshr_state"><span id="prostate">Status:Sold'+resp[i].state+'</span>' +
					'&nbsp;&nbsp;<span id="prostate">On shelf date:'+resp[i].creatTime+'</span>'+
					'<span class="enshrine_it" style="color:yellow" );">Sold</span>'+
					'<span class="enshrine_it make_edition" style="color:red"  onclick="offshelf('+resp[i].pid+');">Delete</span>'+
	                '</div></div><a href="product_detail.jsp?pid='+resp[i].pid+'">'+
	                '<img class="enshr_ph" src="'+resp[i].pimage+'" alt="'+resp[i].pname+'"></a></div>')
			}
	       
	                
	                
			$("#onsale_pro").append(mypro1);
		}
		$("#procount").html('<p>'+count+'</p>')
		
		}
	});
}

function offshelf(id){
    if (!confirm('Please confirm whether to off shelf the item.')) {
        return;
    }
    ajaxRequest('update_status','post',{"id" : id,"status":2},function(){
    	alert("Off shelf success.");
        location.reload();
	});
}
function onshelf(id){
    ajaxRequest('update_status','post',{"id" : id,"status":1},function(){
    	alert("Please confirm whether to on shelf the item.");
        location.reload();
	});
}
function refresh(id,flag){
    
	ajaxRequest('update_flag','post',{"id" : id,"flag":flag},function(){
			if(flag == 1){
				alert("You have refresh the item.");
			}else{
				alert("You have cancelled to refresh the item.");
			}
	        location.reload();
		});
}


function sellout(id){
    if (!confirm('Please confirm to sold.')) {
        return;
    }
    ajaxRequest('update_status','post',{"id" : id,"status":3},function(){
    	alert("Sold success.");
        location.reload();
	});
}

