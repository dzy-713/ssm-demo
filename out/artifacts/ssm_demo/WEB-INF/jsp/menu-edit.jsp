<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rlzz-dev
  Date: 2017/7/19
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>菜单详情</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <%--select2--%>
    <link href="/vendors/select2/dist/css/select2.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.css" rel="stylesheet">

</head>
<body>
<div class="body col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel ">
        <div class="x_title">
            <h2>Form Design
                <small>different form elements</small>
            </h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <br>
            <form id="form" data-parsley-validate="" class="form-horizontal form-label-left" novalidate=""
                  action="/menu/save.do" method="post">
                <input type="hidden" id="id" name="id" value="${menu.id}">

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">上级菜单：
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="parentMenu.name" name="parentMenu.name"
                               class="form-control col-md-7 col-xs-12" value="${menu.parentMenu.name}"
                               readonly="readonly">
                        <input type="hidden" id="parentMenu" name="parentMenu.id" value="${menu.parentMenu.id}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">菜单名称：<span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="name" required="required" name="name"
                               class="form-control col-md-7 col-xs-12" value="${menu.name}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">菜单类型：<span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select class="form-control col-md-7 col-xs-12" id="type" required="required" name="type"
                                value="${menu.type}" onchange="changeType()">
                            <option value="link" <c:if test="${menu.type=='link'}">selected="selected"</c:if>>link
                            </option>
                            <option value="folder" <c:if test="${menu.type=='folder'}">selected="selected"</c:if>>
                                folder
                            </option>
                            <option value="function" <c:if test="${menu.type=='function'}">selected="selected"</c:if>>
                                function
                            </option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">菜单URL：<span class=""></span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="url" required="" name="url" class="form-control col-md-7 col-xs-12"
                               value="${menu.url}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">权限编码：<span class=""></span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="permission" required="" name="permission" class="form-control col-md-7 col-xs-12"
                               value="${menu.permission}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">图标：<span class=""></span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="image" required="" name="image" class="form-control col-md-7 col-xs-12"
                               value="${menu.image}" onclick="openIconsPage()" readonly="readonly">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">排序号：<span class=""></span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="orderliness" required="" name="orderliness"
                               class="form-control col-md-7 col-xs-12"
                               value="${menu.orderliness}">
                    </div>
                </div>

                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3" align="right">
                        <button class="btn btn-primary" type="button" onclick="parent.layer.closeAll()">关闭</button>
                        <button type="button" class="btn btn-success" onclick="save()">保存</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<script src="/vendors/select2/dist/js/select2.full.js"></script>
<script src="/vendors/validator/validator.js"></script>
<script src="/vendors/layer/layer.js"></script>
<script>
    /**
     *保存单据
     */
    function save() {
        validator.checkAll($('#form'));
        $.ajax({
            cache: true,
            type: "POST",
            url: "/menu/save.do",
            data: $('#form').serialize(),// 你的formid
            async: false,
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                parent.location.reload();
                top.layer.closeAll();
            }
        });
    }

    /**
     * 更改菜单类型样式
     */
    function changeType() {
        var type = $("#type").val();
        if (type == 'link' || type == 'function') {
            $("#url").removeAttr("readonly");
            $("#permission").removeAttr("readonly");
        } else {
            $("#url").attr("readonly", "readonly");
            $("#url").val("");
            $("#permission").attr("readonly", "readonly");
            $("#permission").val("");
        }
    }

    /**
     * 图标参照
     */
    function openIconsPage() {
        layer.open({
            type: 2,//frame类型
            closeBtn: 1, //显示关闭按钮
            resize: false,//是否允许拉伸，默认true
            anim: 0, //动画类型 0~6  -1无动画 默认0
            area: ['80%', '80%'], //宽高
            fixed: false,//鼠标滚动时，是否固定
            shadeClose: false, //开启遮罩关闭
            content: "/icons/view.do" //内容
        });
    }

    /**
     * 页面加载完成后执行
     */
    $(function () {
        changeType();
    });

</script>
</body>
</html>
