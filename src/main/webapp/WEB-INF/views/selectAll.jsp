<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/21
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery-1.7.2.js"></script>
</head>
<body>
    <h1>房产信息查询</h1>
    <form action="/selectAll.do" method="post">
        查询类型：<select name="card">
                    <option value="0" <c:if test="${card == 0}">selected</c:if>>--请选择--</option>
                    <option value="1" <c:if test="${card == 1}">selected</c:if> >用户名</option>
                    <option value="2" <c:if test="${card == 2}">selected</c:if> >身份证</option>
                    </select>
        <input type="text" name="realEs" value="${realEs}">
        <input type="submit" value="查找">
    </form>
    <table>
        <tr>
            <th>序号</th>
            <th>项目名称</th>
            <th>产权人</th>
            <th>身份证号</th>
            <th>房屋类型</th>
            <th>使用面积</th>
            <th>建造时间</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.projectName}</td>
                <td>${list.user.name}</td>
                <td>${list.cardId}</td>
                <td>${list.houseType}</td>
                <td>${list.area}</td>
                <td>${list.buildTime}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="selectAll.do?pageNum=${pageInfo.firstPage}&card=${card}&realEs=${realEs}">首页</a>
        <c:if test="${pageInfo.hasPreviousPage}">
            <a href="selectAll.do?pageNum=${pageInfo.prePage}&card=${card}&realEs=${realEs}">上一页</a>
        </c:if>

        <c:forEach items="${pageInfo.navigatepageNums}" var="i">
            <c:if test="${i==pageInfo.pageNum}">
                <a href="selectAll.do?pageNum=${i}&card=${card}&realEs=${realEs}">【${i}】</a>
            </c:if>
            <c:if test="${i!=pageInfo.pageNum}">
                <a href="selectAll.do?pageNum=${i}&card=${card}&realEs=${realEs}">${i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${pageInfo.hasNextPage}">
            <a href="selectAll.do?pageNum=${pageInfo.nextPage}&card=${card}&realEs=${realEs}">下一页</a>
        </c:if>
        <a href="selectAll.do?pageNum=${pageInfo.lastPage}&card=${card}&realEs=${realEs}">末页</a>
        共${ pageInfo.pages }页，${ pageInfo.total}条记录到第<input name="pn" id="pn_input" />页 <input onclick="pageBtn()" id="pag" type="button" value="确定">
    </div>
</body>
<script type="text/javascript">
    function pageBtn() {
        var pageNum = document.getElementById("pn_input").value;
        window.location.href = "selectAll.do?pageNum="+pageNum+"&card=${card}&realEs=${realEs}";
    }
</script>
</html>
