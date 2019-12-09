<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>菜单管理</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.css" rel="stylesheet">
    <%--tree-grid--%>
    <link href="/vendors/jquery-treegrid/css/jquery.treegrid.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class>
    <div class="container body">
        <div class="main_container">
            <!-- page content -->
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_content">
                        <%--<br>--%>
                        <div class="nav navbar-right"><a class="btn btn-success" onclick="openEditPage('/menu/edit.do',null,800)">创建一级菜单</a></div>
                        <div class="">
                            <table class="tree table table-hover">
                                <thead>
                                <tr class="headings">
                                    <th class="column-title">菜单名称</th>
                                    <th class="column-title">菜单类型</th>
                                    <th class="column-title">URL</th>
                                    <th class="column-title">权限编码</th>
                                    <th class="column-title">图标</th>
                                    <th class="column-title">排序</th>
                                    <th class="column-title">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${menus}" varStatus="stat">
                                    <tr class="treegrid-${item.id} <c:if test='${!(empty item.parentMenu)}'>treegrid-parent-${item.parentMenu.id}</c:if>">
                                        <td>${item.name}</td>
                                        <td>${item.type}</td>
                                        <td>${item.url}</td>
                                        <td>${item.permission}</td>
                                        <td><i class="${item.image}"></i> ${item.image}</td>
                                        <td>${item.orderliness}</td>
                                        <td>
                                            <a href="javascript:;"
                                               onclick="openEditPage('/menu/edit.do?id=${item.id}',null,800)"
                                               class="edit-row btn btn-warning btn-xs">编辑</a>
                                            <a href="javascript:;" onclick="doDelete(${item.id});"
                                               class="delete-row btn btn-danger btn-xs">删除</a>
                                            <c:if test="${item.type=='folder'||item.type=='link'}">
                                                <a href="javascript:;" onclick="openEditPage('/menu/edit.do?parentMenuId=${item.id}',null,800)" class="add-row btn btn-success btn-xs">新增下级</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /page content -->
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="/build/js/Main.js"></script>
<%--treeGrid--%>
<script type="text/javascript" src="/vendors/jquery-treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="/vendors/jquery-treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<%--layui--%>
<script type="text/javascript" src="/vendors/layer/layer.js"></script>
<script>
    $('.tree').treegrid();

    function openEditPage(url, height, width) {
        var area;
        if (width == null && height == null) {
            area = "auto";
        } else {
            if (height == null) {
                area = [width + 'px'];
            } else {
                area = [width + 'px', height + 'px'];
            }
        }
        layer.open({
            type: 2,//frame类型
            skin: 'layui-layer-demo', //样式类名
            closeBtn: 1, //显示关闭按钮
            resize: false,//是否允许拉伸，默认true
            anim: 0, //动画类型 0~6  -1无动画 默认0
            area: area, //宽高
            fixed: true,//鼠标滚动时，是否固定
            success: function (layero, index) {
                layer.iframeAuto(index);
            },
            shadeClose: true, //开启遮罩关闭
            content: url //内容
        });
    }

    function doDelete(id) {
        layer.confirm('确认要删除该数据?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                cache: true,
                type: "POST",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                url: "/menu/delete.do?id=" + id,
//                async: false,
                success: function (data) {
                    layer.alert("删除成功");
                    top.location.reload();
                }
            });
            layer.close(index);
        });
    }
</script>
</body>
</html>
