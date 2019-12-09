<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户详情</title>
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
        <div class="layui-col-xs6">
            <h3>用户详情</h3>
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <input type="hidden" name="id" id="id" value="${user.id}">
                    <label class="layui-form-label">用户名称</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" name="name" placeholder="用户名称" class="layui-input" value="${user.name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账户</label>
                    <div class="layui-input-block">
                        <input type="text" name="account" id="account" placeholder="账户" class="layui-input" value="${user.account}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="password" id="password" placeholder="密码" class="layui-input" value="${user.password}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" id="email" placeholder="邮箱" class="layui-input" value="${user.email}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">允许登陆</label>
                    <div class="layui-input-block">
                        <input type="checkbox" id="allowLogin" <c:if test="${user.allowLogin=='true'}">checked</c:if> name="allowLogin" lay-skin="switch" lay-filter="switchTest" lay-text="允许|禁止">
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-xs1">
            <div></div>
        </div>
        <div class="layui-col-xs5">
            <h3>关联角色</h3>
            <input type="hidden" id="treeData" value='${treeData}'>
            <div class="layui-form-item ztree" id="ztree">树形组件</div>
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

    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = JSON.parse($("#treeData").val());
    $(document).ready(function () {
        zTreeObj = $.fn.zTree.init($("#ztree"), setting, zNodes);
    });

    /**
     * 提交保存
     */
    function save(){
        //获取复选框的值
        var checkedNodes = zTreeObj.getCheckedNodes(true);
        var roleList=[];
        if(checkedNodes.length>0){
            for(var i=0;i<checkedNodes.length;i++){
                roleList[i]=checkedNodes[i].id;
            }
        }
        //组装提交数据
        var data = {
            id:$("#id").val(),
            name:$("#name").val(),
            account:$("#account").val(),
            password:$("#password").val(),
            email:$("#email").val(),
            allowLogin:$("#allowLogin")[0].checked,
            roleList:roleList
        }
        //提交
        $.ajax({
            type: "POST",
            url: "/api/user/save.do",
            //dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            async: false,
            success: function (data) {
                if(data.state=="1"){
                    top.layer.alert("保存成功");
                    parent.location.reload();
                }else{
                    top.layer.alert("保存异常:"+data.msg);
                }
            }
        });
    }

    layui.use(['form'], function(){});
</script>

</body>
</html>