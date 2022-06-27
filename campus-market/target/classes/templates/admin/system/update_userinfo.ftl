<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>${siteName!""}CMS Home</title>
<#include "../common/header.ftl"/>

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
              <div class="card-body">
                
                <div class="edit-avatar">
                  <#if ylrc_user.headPic??>
	            		<#if ylrc_user.headPic?length gt 0>
	            		<img src="/photo/view?filename=${ylrc_user.headPic}" id="show-img" class="img-avatar">
	            		<#else>
	            		<img src="/admin/images/default-head.jpg" id="show-img" class="img-avatar">
	            		</#if>
	              </#if>
                  <input type="file" id="select-file" style="display:none;" onchange="upload('show-img','headPic')">
                  <div class="avatar-divider"></div>
                  <div class="edit-avatar-content">
                    <button class="btn btn-default" id="add-pic-btn">Edit Photo</button>
                    <p class="m-0">Select a picture with size no more than 1M</p>
                  </div>
                </div>
                <hr>
                <form method="post" action="update_userinfo" class="site-form">
                  <input type="hidden" name="headPic" id="headPic" value="${ylrc_user.headPic!""}">
                  <div class="form-group">
                    <label for="username">Name</label>
                    <input type="text" class="form-control" name="username" id="username" value="${ylrc_user.username}" disabled="disabled" />
                  </div>
                  <div class="form-group">
                    <label for="nickname">Mobile</label>
                    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="Please input your mobile" value="${ylrc_user.mobile!""}">
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Please input your email in correct format" value="${ylrc_user.email!""}">
                  </div>
                  <button type="submit" class="btn btn-primary">Save</button>
                </form>
       
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
	//监听上传图片按钮
	$("#add-pic-btn").click(function(){
		$("#select-file").click();
	});
});

</script>
</body>
</html>