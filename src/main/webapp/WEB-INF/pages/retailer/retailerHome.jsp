<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <title>零售商管理</title>
    <style>
        *{margin:0; padding:0;} #menuContent a{text-decoration:none;color:#ffffff}
        .c{
          border-style: solid;width: 200px;height: 130px;
          margin: 4 23 0 23;border-radius:5;display:block;
          background:#fff;
          margin:10% auto;
        }
        .mask,.addMask{
        	width:100%;
        	height:100%;
        	position: absolute;
        	background:rgba(0,0,0,.3);
        	display: none;
        }
    </style>
        
    <script type="text/javascript" 
  		src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js">
	</script>

    <script type="text/javascript">
       function init(){
           var countNumber = document.getElementById("countNumber").value;
           var sumPage = document.getElementById("sumPageNumber").value;
           var currentPage = document.getElementById("currentPage").value;
           var info = "一共<font color='blue'>"+countNumber+"</font>条数据，"+
                      "共<font color='blue'>"+sumPage+"</font>页，"+
                      "当前第<font color='blue'>"+currentPage+"</font>页";
           document.getElementById("pageInfo").innerHTML=info;
       }
    
       function changeStatus(){
           var status = document.getElementById("indexStatus").value;
           document.getElementById("status").value=status;
       }
       
       function toPrePage(){
           var currentPageObject = document.getElementById("currentPage");
           var currentPage = parseInt(currentPageObject.value);
           if(currentPage==1){
               alert("数据已到顶！");
           }else{
               currentPageObject.value = currentPage-1;
               var pageSize = parseInt(document.getElementById("pageSize").value);
               var startPageObject =document.getElementById("startPage");
               startPageObject.value = parseInt(startPageObject.value)-pageSize;
               document.getElementById("listForm").submit();
           }
       }
       
       function toNextPage(){
           var currentPageObject = document.getElementById("currentPage");
           var currentPage = parseInt(currentPageObject.value);
           var sumPage = parseInt(document.getElementById("sumPageNumber").value);
           if(currentPage>=sumPage){
               alert("数据已到底！");
           }else{
               currentPageObject.value = currentPage+1;
               var pageSize = parseInt(document.getElementById("pageSize").value);
               var startPageObject =document.getElementById("startPage");
               startPageObject.value = parseInt(startPageObject.value)+pageSize;
               document.getElementById("listForm").submit();
           }
       }
       
       function toLocationPage(){
           //获取要跳转到的页码
           var pageNumber = document.getElementById("pageNumber").value;
           //获取当前页码这个对象
           var currentPageObject = document.getElementById("currentPage");
           //取出当前页码的值
           var currentPage = currentPageObject.value;
           //进行非空校验
           if(pageNumber==null||pageNumber==""){
               alert("请输入要跳转的页数！");
           }else{
        	   pageNumber = parseInt(pageNumber);
        	   //取出总页码数
               var sumPage = parseInt(document.getElementById("sumPageNumber").value);
	           if(pageNumber<1){
	               alert("数据已到顶！");
	           }else if(pageNumber>sumPage){
	               alert("数据已到底！");
	           }else{
	               var pageSize = parseInt(document.getElementById("pageSize").value);
                   // 取出开始的数据下标，默认进入第一面时为0
                   var startPageObject =document.getElementById("startPage");
                   // 如果要跳转的页码大于当前页码，逻辑如下【注意：currentPage不同于currentPageObject.value，currentPage为1】
                   if(pageNumber>=currentPage){
                       //开始的下标+页码差*每页的条数
                       startPageObject.value = parseInt(startPageObject.value)+pageSize*(pageNumber-currentPage);
                   }else if(pageNumber<currentPage){
                       startPageObject.value = parseInt(startPageObject.value)-pageSize*(currentPage-pageNumber);
                   }
                   // 变更当前页码对象的值为要跳转到的页面，相当于公共的变量值，以后后续使用
                   currentPageObject.value = pageNumber;
	               document.getElementById("listForm").submit();
	           }
           }
       }

       //编辑经销商的信息，成功后弹出编辑窗口
       function editRetailer(id){
             var message="{'id':'"+id+"'}";
       		 $.ajax({  
                type:'post',  
                url:'${pageContext.request.contextPath}/retailer/editRetailer.action',  
                contentType:'application/json;charset=utf-8',     
                data:message,//数据格式是json串  
                success:function(data){//返回json结果 
                    $("#editName").val(data["name"]);
                    $("#editTelphone").val(data["telphone"]);
                    $("#editAddress").val(data["address"]);
                    $("#retailerid").val(data["retailerid"]);
                    $("#editStatus").val(data["status"]);
                    $("#eStatus").val(data["status"]);
                    //显示弹出框
                    $(".mask").css("display","block");
                    //引入分页信息至该form表单
                    $("#eStartPage").val($("#startPage").val());
                    $("#eCurrentPage").val($("#currentPage").val());
                    $("#ePageSize").val($("#pageSize").val());
                }   
            });  
       }

       function cancelEdit(){
    	   $(".mask").css("display","none");
       }

       function changeEditStatus(){
           //修改悬浮窗的值时，将修改的内容取出，显示到要显示的input中
    	   var status = document.getElementById("eStatus").value;
           document.getElementById("eStatus").val=status;
       }

       function deleteRetailer(id,name){
    	   if(window.confirm("你确定要删除用户"+name+"吗？")){
    		   $("#dRetailerid").val(id);//向form中引入id
        	   //引入分页信息至该form表单
               $("#dStartPage").val($("#startPage").val());
               $("#dCurrentPage").val($("#currentPage").val());
               $("#dPageSize").val($("#pageSize").val());
               $("#deleteForm").submit();//提交表单
            }
       }

	   function showAddMask(flag){
		    if(flag=="true"){
		 	   $(".addMask").css("display","block");
		    }else{
		 	   $(".addMask").css("display","none");
		    }
	   }

	   function checkAddRetailer(event){
           if($("#addName").val()==null||$("#addName").val()==""){
               alert("用户名不能为空！");
               return false;
           }
           if($("#addTelphone").val()==null||$("#addTelphone").val()==""){
               alert("手机号不能为空！");
               return false;
           }
           // var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
           // if(!myreg.test($("#addTelphone").val()))
           // {
           //     alert("请输入有效的手机号码！");
           //     return false;
           // }
           if($("#addAddress").val()==null||$("#addAddress").val()==""){
               alert("地址不能为空！");
               return false;
           }
           return true;
	   }
    </script>
  </head>
  <body onload="init()">
      <%@ include file="../menu.jsp" %><br/>
   <div class="addMask">
	   <div class="c">
	     <div style="background-color:#173e65;height:20px;color:#fff;font-size:12px;padding-left:7px;">
	     	添加信息<font style="float:right;padding-right: 10px;" onclick="showAddMask('false')">x</font>
	     </div>
	     <form id="addForm" action="add.action" method="post" onsubmit="checkAddRetailer()">
		        姓名：<input type="text" id="addName" name="name" style="width:120px"/> <br/>
		        手机：<input type="text" id="addTelphone" name="telphone" style="width:120px"/><br/>
		        地址：<input type="text" id="addAddress" name="address" style="width:120px"/><br/>
		     <input type="hidden" name="status" value="1"/>
		     <input type="submit" value="添加" style="background-color:#173e65;color:#ffffff;width:70px;"/>
	     </form>
	    </div>
   </div>
	  <%--修改经销商信息的窗口--%>
   <div class="mask">
	   <div class="c">
	     <div style="background-color:#173e65;height:20px;color:#fff;font-size:12px;padding-left:7px;">
	     	修改信息<font style="float:right;padding-right: 10px;" onclick="cancelEdit()">x</font>
	     </div>
	     <form id="editForm" action="edit.action" method="post">
		        姓名：<input type="text" id="editName" name="name" style="width:120px"/> <br/>
		        手机：<input type="text" id="editTelphone" name="telphone" style="width:120px"/><br/>
		        地址：<input type="text" id="editAddress" name="address" style="width:120px"/><br/>
		        状态：<select id="eStatus" onchange="changeEditStatus()">
			 	<option value="-1">全部</option>
			 	<option value="1">启用</option>
		        <option value="0">停用</option>
		     </select><br/>
		     <input type="hidden" name="retailerid" id="retailerid"/>
		     <input type="hidden" name="status" id="editStatus"/>
		     <input type="hidden" name="startPage" id="eStartPage"/>
			 <input type="hidden" name="currentPage" id="eCurrentPage"/>
			 <input type="hidden" name="pageSize" id="ePageSize"/>
		     <input type="submit" value="提交" style="background-color:#173e65;color:#ffffff;width:70px;"/>
	     </form>
	    </div>
  </div>

  <form id="listForm" action="list.action" method="post">
        姓名：<input type="text" name="name" style="width:120px"/> 
        手机：<input type="text" name="telphone" style="width:120px"/>
        地址：<input type="text" name="address" style="width:120px"/><br/><br/>
        状态：<select id="indexStatus" onchange="changeStatus()">
        <option value="-1" selected="selected">全部</option>
        <option value="1">启用</option>
        <option value="0">停用</option>
     </select>
     <input type="hidden" name="status" id="status" value="-1">
        创建日期：<input type="text" name="createtime"/>
     <input type="submit" value="搜索" style="background-color:#173e65;color:#ffffff;width:70px;"/> <br/>
     <!-- 显示错误信息 -->  
	 <c:if test="${errorMsg}">   
	     <font color="red">${errorMsg}</font><br/>
	 </c:if> 
	 <input type="hidden" name="startPage" id="startPage" value="${startPage}"/>
	 <input type="hidden" name="currentPage" id="currentPage" value="${currentPage}"/>
	 <input type="hidden" name="pageSize" id="pageSize" value="${pageSize}"/>
	 <input type="hidden" name="sumPageNumber" id="sumPageNumber" value="${sumPageNumber}"/>
	 <input type="hidden" name="countNumber" id="countNumber" value="${countNumber}"/>
  </form>

  <hr style="margin-top: 10px;"/> 
  <button onclick="showAddMask('true')" style="background-color:#173e65;color:#ffffff;width:70px;">添加</button>
  <c:if test="${list!=null}">
	  <table style="margin-top: 10px;width:700px;text-align:center;" border=1>  
	    <tr>  
	      <td>序号</td><td>姓名</td><td>手机号</td><td>地址</td>
	      <td>状态</td><td>创建日期</td><td>操作</td>
	   </tr>  
      <c:forEach items="${list}" var="item" varStatus="status">  
	     <tr>  
	       <td>${status.index+1}</td><td>${item.name }</td>
	       <td>${item.telphone}</td><td>${item.address }</td>
	       <td>
	           <c:if test="${item.status==1}">
	               <font color="blue">启用</font>
	           </c:if>
	           <c:if test="${item.status==0}">
	               <font color="red">停用</font>
	           </c:if>
	       </td>
			 <td>${item.createtime}</td>

		 <%--<fmt:parseDate value="${item.createtime}" var="date" pattern="yyyyMMddHHmmss"/>--%>
			   <%--<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></td>--%>

	       <td>
	       		<a onclick="editRetailer('${item.retailerid}')">编辑</a>|
	       		<a onclick="deleteRetailer('${item.retailerid}','${item.name }')">删除</a>
	       		<form id="deleteForm" action="delete.action" method="post">
	       		   <input type="hidden" name="retailerid" id="dRetailerid"/>
	       		   <input type="hidden" name="startPage" id="dStartPage"/>
			       <input type="hidden" name="currentPage" id="dCurrentPage"/>
			       <input type="hidden" name="pageSize" id="dPageSize"/>
	       		</form>
	       </td>
	     </tr>  
	    </c:forEach>  
	    </table> 
   </c:if>
   <c:if test="${list.size()<0 or list==null}">
       <b>搜索结果为空！</b>
   </c:if>
   <div style="margin-top: 10px;">
       <a onclick="toPrePage()">上一页</a><a onclick="toNextPage()">下一页</a>
       <input type="text" id="pageNumber" style="width:50px">
       <button onclick="toLocationPage()">go</button>
       <div id="pageInfo"></div>
   </div>
  </body>
</html>
