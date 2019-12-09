<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>邮箱设置</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link href="/build/css/custom.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vendors/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
    <style>
        .ztree {
            border: 1px solid #d2d6d6;
            height: 300px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>
</head>
<body>
<div class="layui-container body">
    <div class="layui-row layui-col-space1">
        <div class="layui-col-xs12">
            <h3>邮箱设置</h3>
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱服务地址</label>
                    <div class="layui-input-block">
                        <input type="text" id="host" name="host" placeholder="" class="layui-input" value="${emailSetting.host}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">绑定发送邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="fromEmail" id="fromEmail" placeholder="" class="layui-input" value="${emailSetting.fromEmail}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">绑定邮箱授权码</label>
                    <div class="layui-input-block">
                        <input type="text" name="passWord" id="passWord" placeholder="" class="layui-input" value="${emailSetting.passWord}">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="layui-row layui-col-space1">
        <div class="layui-col-xs6">
        </div>
        <div class="layui-col-xs1">
        </div>
        <div class="layui-col-xs5">
            <div class="layui-form-item panel_toolbox">
                <button class="layui-btn layui-btn-danger" onclick="parent.layer.closeAll()">关闭</button>
                <button class="layui-btn" onclick="save()">保存</button>
            </div>
        </div>
    </div>
</div>

<script src="/vendors/jquery/dist/jquery.min.js" charset="utf-8"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/vendors/zTree/js/jquery.ztree.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    /**
     * 提交保存
     */
    function save(){
        //组装提交数据
        var data = {
            host:$("#host").val(),
            fromEmail:$("#fromEmail").val(),
            passWord:$("#passWord").val()
        };
        //提交
        $.ajax({
            type: "POST",
            url: "/api/email-setting/save",
            //dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            async: false,
            success: function (data) {
                top.layer.alert("保存成功");
            }
        });
    }
</script>

</body>
</html>