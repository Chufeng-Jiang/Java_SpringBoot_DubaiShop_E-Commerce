<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, goodsCategory-scalable=no" />
<title>${siteName!""}|Item Review Management-${title!""}</title>
<#include "../common/header.ftl"/>
<style>
td{
	vertical-align:middle;
}
</style>
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="/admin/images/logo-sidebar.png" title="${siteName!""}" alt="${siteName!""}" /></a>
      </div>
      <div class="lyear-layout-sidebar-scroll"> 
        <#include "../common/left-menu.ftl"/>
      </div>
      
    </aside>
    <!--End 左侧导航-->
    
    <#include "../common/header-menu.ftl"/>
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-toolbar clearfix">
                <form class="pull-right search-bar" method="get" action="list" role="form">
                  <div class="input-group">
                    <div class="input-group-btn">
                      <button class="btn btn-default dropdown-toggle" id="search-btn" data-toggle="dropdown" type="button" aria-haspopup="true" aria-expanded="false">
                      	<#if name??>Item Name<#elseif sn??>Student No.<#elseif content??>Review Content<#else>Search criteria</#if> <span class="caret"></span>
                      </button>
                      <ul class="dropdown-menu">
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="content">Review Content</a> </li>
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="student.sn">Student No.</a> </li>
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="goods.name">Item Name</a> </li>
                      </ul>
                    </div>
                    <input type="text" class="form-control" value="${content!sn!name!""}" id="search-value" name="<#if name??>goods.name<#elseif sn??>student.sn<#else>content</#if>" placeholder="Please input your wanted goods">
                  	<span class="input-group-btn">
                      <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                  </div>
                </form>
                <#include "../common/third-menu.ftl"/>
              </div>
              <div class="card-body">
                
                <div class="table-responsive">
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" id="check-all"><span></span>
                          </label>
                        </th>
                        <th>Item Picture</th>
                        <th>Item Name</th>
                        <th>Reviewer</th>
                        <th style="width:256px;">Review Content</th>
                        <th style="width:200px;">Respondent</th>
                        <th>Time Stamp</th>
                      </tr>
                    </thead>
                    <tbody>
                      <#if pageBean.content?size gt 0>
                      <#list pageBean.content as comment>
                      <tr>
                        <td style="vertical-align:middle;">
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" name="ids[]" value="${comment.id}"><span></span>
                          </label>
                        </td>
                        <td style="vertical-align:middle;">
                        	<a href="/home/goods/detail?id=${comment.goods.id}" target="_blank">
                        	<img src="/photo/view?filename=${comment.goods.photo}" width="30px" height="30px">
                       		</a>
                        </td>
                        <td style="vertical-align:middle;">
                        	<a href="/home/goods/detail?id=${comment.goods.id}" target="_blank">${comment.goods.name}</a>
                        </td>
                        <td style="vertical-align:middle;">
                        	${comment.student.sn}
                        </td>
                        <td style="vertical-align:middle;">
                        ${comment.content}
                        </td>
                        <td style="vertical-align:middle;">
                        ${comment.replyTo!""}
                        </td>
                        <td style="vertical-align:middle;" style="vertical-align:middle;"><font class="text-success">${comment.createTime}</font></td>
                      </tr>
                    </#list>
                    <#else>
                    <tr align="center"><td colspan="7">There is empty.</td></tr>
					</#if>
                    </tbody>
                  </table>
                </div>
                <#if pageBean.total gt 0>
                <ul class="pagination ">
                  <#if pageBean.currentPage == 1>
                  <li class="disabled"><span>«</span></li>
                  <#else>
                  <li><a href="list?<#if name??>goods.name<#elseif sn??>student.sn<#else>content</#if>=${name!sn!content!""}&currentPage=1">«</a></li>
                  </#if>
                  <#list pageBean.currentShowPage as showPage>
                  <#if pageBean.currentPage == showPage>
                  <li class="active"><span>${showPage}</span></li>
                  <#else>
                  <li><a href="list?<#if name??>goods.name<#elseif sn??>student.sn<#else>content</#if>=${name!sn!content!""}&currentPage=${showPage}">${showPage}</a></li>
                  </#if>
                  </#list>
                  <#if pageBean.currentPage == pageBean.totalPage>
                  <li class="disabled"><span>»</span></li>
                  <#else>
                  <li><a href="list?<#if name??>goods.name<#elseif sn??>student.sn<#else>content</#if>=${name!sn!content!""}&currentPage=${pageBean.totalPage}">»</a></li>
                  </#if>
                  <li><span>Total ${pageBean.totalPage} Pages,${pageBean.total} Items</span></li>
                </ul>
                </#if>
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>
<#include "../common/footer.ftl"/>
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".dropdown-menu li a").click(function(){
		$("#search-btn").html($(this).text() + '<span class="caret"></span>');
		$("#search-value").attr('name',$(this).attr('data-field'));
	});
});
function del(url){
	if($("input[type='checkbox']:checked").length != 1){
		showWarningMsg('Please select a data item to delete.');
		return;
	}
	var id = $("input[type='checkbox']:checked").val();
	$.confirm({
        title: 'Confirm to delete?',
        content: 'Data cannot be recovered after deletion.',
        buttons: {
            confirm: {
                text: 'Confirm',
                action: function(){
                    deleteReq(id,url);
                }
            },
            cancel: {
                text: 'Close',
                action: function(){
                    
                }
            }
        }
    });
}

//调用删除方法
function deleteReq(id,url){
	$.ajax({
		url:url,
		type:'POST',
		data:{id:id},
		dataType:'json',
		success:function(data){
			if(data.code == 0){
				showSuccessMsg('Item review deletion successful.',function(){
					$("input[type='checkbox']:checked").parents("tr").remove();
				})
			}else{
				showErrorMsg(data.msg);
			}
		},
		error:function(data){
			alert('Network Error.');
		}
	});
}
</script>
</body>
</html>