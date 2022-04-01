<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工展示</title>
    <link rel="stylesheet"
          href="../bootstrap/css/bootstrap.css">
    <style>
        #container {
            width: 800px;
            margin: 10px auto;
        }

        #container .selected {
            background: #337ab7
        }
    </style>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {

            $("#add").click(function () {
                $("#modalBody").html("");
                $("#modalBody").load("showAdd");
                $("#modalLabel").text("新增")
                $("#modal").modal("show");
            })
            var id = -1;
            $(document).on("click",".data",function () {
                $(".data").removeClass("selected");
                $(this).addClass("selected");
                id = $(this).data("id");
            })
            $("#update").click(function () {
                if (id >= 0) {
                    location.href = "showUpdate?id=" + id;
                } else {
                    alert("请选中数据");
                }
            })
            $("#delete").click(function () {
                if (id >= 0) {
                    location.href = "delete?id=" + id;
                } else {
                    alert("请选中数据");
                }
            })
            $("#search").click(function () {
                $.ajax({
                    url: "searchByCondition",
                    type: "post",
                    data: $("#searchForm").serialize(),
                    dataType: "json",
                    success: function (data) {
                        $(".data").remove();
                        for (var i = 0; i < data.length; i++) {
                            var tr = "<tr class='data' data-id=" + data[i].id + ">" +
                                "<td>" + data[i].number +
                                "</td><td>" + data[i].name +
                                "</td><td>" + data[i].gender +
                                "</td><td>" + data[i].age +
                                "</td><td>" + data[i].dep.name +
                                "</td>< /tr>"
                            $("table").append(tr);
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>

<div id="container">
    <form id="searchForm" class="form-horizontal">
        <div class="form-group">
            <div class="col-sm-2">
                <input type="text" class="form-control" name="number"
                       placeholder="编号" value=${c.number}>
            </div>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="name"
                       placeholder="姓名" value=${c.name}>
            </div>
            <div class="col-sm-2 ">
                <select name="gender" class="form-control">
                    <option value="">性别</option>
                    <option value="男" <c:if test="${c.gender =='男'}"> selected</c:if>>男</option>
                    <option value="女" <c:if test="${c.gender =='女'}"> selected</c:if>>女</option>
                </select>
            </div>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="age" placeholder="年龄"
                       value=${c.age!=null?c.age:''}>
            </div>

            <div class="col-sm-2 ">
                <select name="dep.id" class="form-control">
                    <option value="">部门</option>
                    <c:forEach items="${depList}" var="dep">
                        <option value="${dep.id }"
                                <c:if test="${dep.id ==c.dep.id}"> selected</c:if>>${dep.name }</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-2">
                <button type="button" class="btn btn-primary" id="search">搜索</button>
            </div>
        </div>
    </form>
    <table class="table table-striped table-bordered table-hover">
        <tr>
            <th>编号</th>
            <th>名字</th>
            <th>性别</th>
            <th>年龄</th>
            <th>部门</th>
        </tr>

        <c:forEach items="${list}" var="data">
            <tr class="data" data-id="${data.id }">
                <td>${data.number }</td>
                <td>${data.name }</td>
                <td>${data.gender }</td>
                <td>${data.age }</td>
                <td>${data.dep.name }</td>
            </tr>
        </c:forEach>
    </table>
    <button type="button" class="btn btn-primary" id="add">新增</button>
    <button type="button" class="btn btn-primary" id="update">修改</button>
    <button type="button" class="btn btn-danger" id="delete">删除</button>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="modal" tabindex="-1" role="dialog"
         aria-labelledby="modalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×</button>
                    <h4 class="modal-title" id="modalLabel"></h4>
                </div>
                <div class="modal-body" id="modalBody">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>