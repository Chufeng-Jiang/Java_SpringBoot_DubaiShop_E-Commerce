<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<title>${siteName!""}-Edit Wanted Goods</title>
<link rel="icon" href="/home/imgs/favicon.ico" type="image/x-icon">
<link media="all" href="/home/css/release_product.css" type="text/css" rel="stylesheet">
<link media="all" href="/home/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
  <#include "../common/top_header.ftl"/>
   <div class="container">
            <div class="main center">
                <img class="release-icon-main" src="/home/imgs/release-icon.png" alt="">
                <div class="wave-fluid"></div>
                <div class="wantInfo-release-title">Edit Wanted Goods</div>
                <form action="publish" id="publish-form" method="post">
                <input type="hidden" name="id" value="${wantedGoods.id}">
                <div class="form-wr">
                    <div class="form-must-wr">
                        <div class="form-item l goods-title">
                            <div class="form-key">
                                <span>Goods Name: </span></div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input id="name" name="name" placeholder="No more than 18 words" maxlength="18" value="${wantedGoods.name}" type="text" class="required" tips="Goods Name"></div>
                            </div>
                        </div>
                        
                        <div class="form-item xl goods-desc">
                            <div class="form-key">
                                <span>Description: </span></div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <textarea name="content" id="desc" placeholder="Goods Description" class="required" tips="Goods Description">${wantedGoods.content}</textarea>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="form-item l goods-title">
                            <div class="form-key">
                                <span>Place: </span></div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input class="required" id="tradePlace" name="tradePlace" value="${wantedGoods.tradePlace}" type="text" tips="Ecpected Trading Location"></div>
                            </div>
                        </div>
                        <div class="form-item l goods-price">
                            <div class="form-key">
                                <span>Expected Price: </span></div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input class="price required" id="sellPrice" name="sellPrice" value="${wantedGoods.sellPrice}" type="number" tips="Expected Price"></div>
                            </div>
                        </div>
                    </div>
                   	<input class="form-submit" id="submit-btn" type="button" value="Post" />
                  </div>
                  </form>
            </div>
        </div>
 	<#include "../common/right_menu.ftl"/>
	<#include "../common/bottom_footer.ftl"/> 
<script  src="/home/js/jquery-3.1.1.min.js"></script>
<script src="/home/js/common.js"></script>
<script src="/home/js/add.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $("#submit-btn").click(function(){
   		var flag = true;
   		$(".required").each(function(i,e){
   			if($(e).val() == ''){
   				alert($(e).attr('tips'));
   				flag = false;
   				return false;
   			}
   		});
   		if(flag){
   			if($("#desc").val().length < 15){
	   			alert('Description should more than 15 words');
	   			return;
	   		}
	   		if(parseFloat($("#sellPrice").val()) == 'NaN'){
	   			alert('Only numbers');
	   			return;
	   		}
	   		//全部符合，准备提交表单
	   		ajaxRequest('edit_wanted_goods','post',$("#publish-form").serialize(),function(){
	   			window.location.href="index";
	   		});
   		}
   });

});

</script>	
</html>