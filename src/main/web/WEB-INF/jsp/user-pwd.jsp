<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link href="/build/css/custom.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vendors/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
    <style>

    </style>
</head>
<body>
<div class="layui-container body">
    <div class="layui-row layui-col-space1">
        <div class="layui-col-xs12">
            <h3>修改密码</h3>
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <input type="hidden" name="id" id="id" value="${user.id}">
                    <label class="layui-form-label">用户名称</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" name="name" placeholder="用户名称" class="layui-input" value="${user.name}" readonly="readonly">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账户</label>
                    <div class="layui-input-block">
                        <input type="text" name="account" id="account" placeholder="账户" class="layui-input" value="${user.account}" readonly="readonly">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="oldPwd" id="oldPwd"  class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newPwd" id="newPwd"  class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newPwd2" id="newPwd2"  class="layui-input" >
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
        var oldPwd = $("#oldPwd").val();
        if(oldPwd==null||oldPwd==""){
            layer.alert("旧密码不能为空");
            return;
        }
        var newPwd = $("#newPwd").val();
        if(newPwd==null||newPwd==""){
            layer.alert("新密码不能为空");
            return;
        }
        var newPwd2 = $("#newPwd2").val();
        if(newPwd2==null||newPwd2==""){
            layer.alert("确认密码不能为空");
            return;
        }
        if(newPwd!=newPwd2){
            layer.alert("两次密码输入不一致，请检查");
            return;
        }
        //组装提交数据
        var data = {
            account:$("#account").val(),
            oldPwd:$("#oldPwd").val(),
            password:$("#newPwd").val()
        };
        //提交
        $.ajax({
            type: "POST",
            url: "/api/user/updatePwd",
            //dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            async: false,
            success: function (data) {
                if(data.state=="1"){
                    top.layer.alert("修改成功，确认后退到登陆界面",null,function () {
                        top.location="/logout";
                    });
                }else{
                    top.layer.alert("异常:"+data.msg);
                }
            }
        });
    }

    layui.use(['form'], function(){});
</script>

</body>
</html>