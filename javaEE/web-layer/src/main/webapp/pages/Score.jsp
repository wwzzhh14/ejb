<%--
  Created by IntelliJ IDEA.
  User: wzh
  Date: 29/12/2016
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="user" uri="/WEB-INF/tlds/user.tld" %>
<user:checkSession></user:checkSession>
<jsp:useBean id="UserNumBean" scope="application" type="bean.UserNumBean"></jsp:useBean>
<jsp:useBean id="ScoreBean" scope="session" type="bean.ScoreBean"></jsp:useBean>
<jsp:useBean id="CourseBean" scope="page" class="bean.CourseBean"></jsp:useBean>
<jsp:useBean id="ExamResult" scope="page" class="bean.ExamResult"></jsp:useBean>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成绩</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.css">
</head>

<body>

<div style="padding-right: 10px;height: 20px">
    <button type="button" class="btn btn-link" href="www.baidu.com"><a href="/logout">退出</a></button>
    <span class="label label-default"style="float: right;margin-left: 10px">登录人数:
        <jsp:getProperty name="UserNumBean" property="user"></jsp:getProperty>
    </span>
    <span class="label label-default" style="float: right;margin-left: 10px">游客人数:
        <jsp:getProperty name="UserNumBean" property="visitor"></jsp:getProperty>
    </span>
    <span class="label label-default" style="float: right;margin-left: 10px">总人数:
        <jsp:getProperty name="UserNumBean" property="sum"></jsp:getProperty>
    </span>
</div>
<div style="width: 80%;margin-left: 10% ;margin-top: 20px" >
    <div class="list-group">
        <%for(int i=0;i<ScoreBean.getCourseList().size();i++){
            pageContext.setAttribute("CourseBean",ScoreBean.getCourseList().get(i));
            if(ScoreBean.getCourseList().get(i).getScore()>=60){
        %>
        <div class="list-group-item list-group-item-success">
            <h4 class="list-group-item-heading"><jsp:getProperty name="CourseBean" property="name"></jsp:getProperty> <jsp:getProperty name="CourseBean" property="teacher"></jsp:getProperty></h4>
            <%
                for(int j=0;j<ScoreBean.getCourseList().get(i).getExamResultList().size();j++){
                pageContext.setAttribute("ExamResult",ScoreBean.getCourseList().get(i).getExamResultList().get(j));
            %>
            <p class="list-group-item-text"><jsp:getProperty name="ExamResult" property="name"></jsp:getProperty> | <jsp:getProperty name="ExamResult" property="date"></jsp:getProperty> | <jsp:getProperty name="ExamResult" property="place"></jsp:getProperty> |
                <%if(ScoreBean.getCourseList().get(i).getExamResultList().get(j).getGrade()>0){ %>
                <jsp:getProperty name="ExamResult" property="grade"></jsp:getProperty>
                <% }else{%>缺考<% }%></p>
            <%}%>
            <p class="list-group-item-text">总评  <jsp:getProperty name="CourseBean" property="score"></jsp:getProperty></p>
        </div>
            <%}else {%>
        <div class="list-group-item list-group-item-danger">

            <h4 class="list-group-item-heading"><jsp:getProperty name="CourseBean" property="name"></jsp:getProperty> <jsp:getProperty name="CourseBean" property="teacher"></jsp:getProperty></h4>
            <%
                for(int j=0;j<ScoreBean.getCourseList().get(i).getExamResultList().size();j++){
                    pageContext.setAttribute("ExamResult",ScoreBean.getCourseList().get(i).getExamResultList().get(j));
            %>
            <p class="list-group-item-text"><jsp:getProperty name="ExamResult" property="name"></jsp:getProperty> | <jsp:getProperty name="ExamResult" property="date"></jsp:getProperty> | <jsp:getProperty name="ExamResult" property="place"></jsp:getProperty> |
                <%if(ScoreBean.getCourseList().get(i).getExamResultList().get(j).getGrade()>0){ %>
                <jsp:getProperty name="ExamResult" property="grade"></jsp:getProperty>
                <% }else{%>缺考<% }%></p>
            <%}%>
            <p class="list-group-item-text">总评  <jsp:getProperty name="CourseBean" property="score"></jsp:getProperty></p>
        </div>
        <%}%>
        <%}%>

    </div>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
