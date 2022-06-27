<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${siteName!""}|Student Management-${title!""}</title>
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
                      Student No.<span class="caret"></span>
                      </button>
                      <ul class="dropdown-menu">
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="title">Student No.</a> </li>
                      </ul>
                    </div>
                    <input type="text" class="form-control" value="${sn!""}" name="sn" placeholder="Please input the Student No.">
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
                        </th>Photo</th>
                        <th>Student No.</th>
                        <th>Nick Name</th>
                        <th>Password</th>
                        <th>Status</th>
                        <th>Mobile</th>
                        <th>QQ</th>
                        <th>University</th>
                        <th>Department</th>
                        <th>Grade Level</th>
                        <th>Enrollement Time</th>
                      </tr>
                    </thead>
                    <tbody>
                      <#if pageBean.content?size gt 0>
                      <#list pageBean.content as student>
                      <tr>
                        <td style="vertical-align:middle;">
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" name="ids[]" value="${student.id}"><span></span>
                          </label>
                        </td>
                        <td style="vertical-align:middle;">
                    		<#if student.headPic??>
                    		<img src="/photo/view?filename=${student.headPic}" width="60px" height="60px">
                    		<#else>
                    		<img src="/home/imgs/avatar1.png" width="60px" height="60px">
                    		</#if>
                        </td>
                        <td style="vertical-align:middle;">${student.sn}</td>
                        <td style="vertical-align:middle;">${student.nickname!""}</td>
                        <td style="vertical-align:middle;">${student.password}</td>
                        <td style="vertical-align:middle;">
                        	<#if student.status == 1>
                        	<font class="text-success">Regular</font>
                        	<#else>
                        	<font class="text-warning">Freeze</font>
                        	</#if>
                        </td>
                        <td style="vertical-align:middle;">${student.mobile!""}</td>
                        <td style="vertical-align:middle;">${student.qq!""}</td>
                        <td style="vertical-align:middle;">${student.school!""}</td>
                        <td style="vertical-align:middle;">${student.academy!""}</td>
                        <td style="vertical-align:middle;">${student.grade!""}</td>
                        <td style="vertical-align:middle;" style="vertical-align:middle;"><font class="text-success">${student.createTime}</font></td>
                      </tr>
                    </#list>
                    <#else>
                    <tr align="center"><td colspan="12">There is empty.</td></tr>
					</#if>
                    </tbody>
                  </table>
                </div>
                <#if pageBean.total gt 0>
                <ul class="pagination ">
                  <#if pageBean.currentPage == 1>
                  <li class="disabled"><span>«</span></li>
                  <#else>
                  <li><a href="list?sn=${sn!""}&currentPage=1">«</a></li>
                  </#if>
                  <#list pageBean.currentShowPage as showPage>
                  <#if pageBean.currentPage == showPage>
                  <li class="active"><span>${showPage}</span></li>
                  <#else>
                  <li><a href="list?sn=${sn!""}&currentPage=${showPage}">${showPage}</a></li>
                  </#if>
                  </#list>
                  <#if pageBean.currentPage == pageBean.totalPage>
                  <li class="disabled"><span>»</span></li>
                  <#else>
                  <li><a href="list?sn=${sn!""}&currentPage=${pageBean.totalPage}">»</a></li>
                  </#if>
                  <li><span>Total ${pageBean.totalPage} Pages, ${pageBean.total} Items</span></li>
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
	
});
function del(url){
	if($("input[type='checkbox']:checked").length != 1){
		showWarningMsg('Please select a piece of data to delete.');
		return;
	}
	var id = $("input[type='checkbox']:checked").val();
	$.confirm({
        title: 'Sure to delete?',
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
//冻结
function freeze(url){
	if($("input[type='checkbox']:checked").length != 1){
		showWarningMsg('Please select a piece of data to freeze.！');
		return;
	}
	var id = $("input[type='checkbox']:checked").val();
	ajaxRequest('update_status','post',{id:id,status:0},function(){
		alert('Freeze successfully');
		window.location.reload();
	});
}
//激活
function openStudent(url){
	if($("input[type='checkbox']:checked").length != 1){
		showWarningMsg('Please select a piece of data to activate');
		return;
	}
	var id = $("input[type='checkbox']:checked").val();
	ajaxRequest('update_status','post',{id:id,status:1},function(){
		alert('Activate successfully');
		window.location.reload();
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
				showSuccessMsg('Delete successfully',function(){
					$("input[type='checkbox']:checked").parents("tr").remove();
				})
			}else{
				showErrorMsg(data.msg);
			}
		},
		error:function(data){
			alert('Network Error');
		}
	});
}
</script>
</body>
</html>