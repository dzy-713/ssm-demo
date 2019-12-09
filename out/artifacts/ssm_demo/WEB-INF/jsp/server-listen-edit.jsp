<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>服务监听详情</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link href="/build/css/custom.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/vendors/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="layui-container body">
    <div class="layui-row layui-col-space1">
        <div class="layui-col-xs12">
            <h3>服务监听详情</h3>
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <input type="hidden" name="id" id="id" value="${serverListen.id}">
                    <label class="layui-form-label">服务名称</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" name="name" placeholder="服务名称" class="layui-input" value="${serverListen.name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="url" id="url" placeholder="地址" class="layui-input" value="${serverListen.url}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">请求方式</label>
                    <div class="layui-input-block">
                        <input type="text" name="method" id="method" placeholder="请求方式" class="layui-input" value="${serverListen.method}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">请求间隔(s)</label>
                    <div class="layui-input-block">
                        <input type="text" name="reqCycle" id="reqCycle" placeholder="请求间隔(s)" class="layui-input" value="${serverListen.reqCycle}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开启监控</label>
                    <div class="layui-input-block">
                        <input type="checkbox" id="isListen" <c:if test="${serverListen.isListen=='true'}">checked</c:if> name="isListen" lay-skin="switch" lay-filter="switchTest" lay-text="开启|关闭">
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
            id:$("#id").val(),
            name:$("#name").val(),
            url:$("#url").val(),
            method:$("#method").val(),
            reqCycle:$("#reqCycle").val(),
            isListen:$("#isListen")[0].checked
        };
        //提交
        $.ajax({
            type: "POST",
            url: "/api/server-listen/save.do",
            //dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            async: false,
            success: function (data) {
                top.layer.alert("保存成功");
                parent.location.reload();
            }
        });
    }

    layui.use(['form'], function(){});
</script>

</body>
</html>