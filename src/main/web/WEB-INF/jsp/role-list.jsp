<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色列表</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link href="/build/css/custom.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="layui-row">
    <div class="layui-btn-group layui-col-xs6">
        <button class="layui-btn" onclick="openEditPage('/role/edit.do','460px','600px')"><i
                class="fa fa-plus"></i> 新增
        </button>
        <button class="layui-btn" onclick="reload()"><i class="fa fa-refresh"></i> 刷新</button>
    </div>

    <div class="layui-col-xs6">
        <div class="panel_toolbox">
            搜索ID：
            <div class="layui-inline">
                <input class="layui-input" name="id" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>
    </div>
</div>

<%--<div class="nav navbar-right"><a class="btn btn-success"--%>
<%--onclick="openEditPage('/user/edit.do',null,800)">创建新的用户</a>--%>
<%--</div>--%>
<table id="demo" lay-filter="test" lay-data="{id: 'idTest'}"></table>

<script src="/layui/layui.js"></script>
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<script>

    function openEditPage(url, height, width) {
        var area;
        if (width == null && height == null) {
            area = "auto";
        } else {
            if (height == null) {
                area = [width];
            } else {
                area = [width, height];
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


    function reload() {
        layui.use('table', function () {
            var table = layui.table;
            var form = layui.form;

            //第一个实例
            table.render({
                id:'tableId',
                elem: '#demo',  //指定 table
                height: null,    //高度   窗口高度-一个值
                width: null,    //默认铺满父元素，自带滚动条
                done: function () {
                },    //数据渲染后回调函数
                data: [],    //加载静态数据
                url: '/api/role/list', //数据接口
                page: true,     //开启分页，默认false
                limit: 10,//每页显示条数，默认10
                limits: [10, 20, 30],//允许分页的列表
                loading: true,//翻页时显示loading，默认true
                initSort: {field: 'id', type: 'asc'},//初始排序
                cols: [[        //表头
                    {field: 'id', title: 'ID', width: 80, sort: true},
                    {field: 'name', title: '角色'},
                    {field: 'code', title: '编码', sort: true},
                    {field: 'toolbar', title: '操作', toolbar: '#toolbar'}
                ]]
            });
        });
    };

    function doDelete(id) {
        layer.confirm('确认要删除该数据?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                cache: true,
                type: "POST",
                //dataType: 'json',
                contentType: "application/json; charset=utf-8",
                url: "/api/role/delete?id=" + id,
                //async: false,
                success: function (data) {
                    reload();
                    layer.alert("删除成功");
                }
            });
            layer.close(index);
        });
    }

    reload();

    $(window).resize(function () {
        layui.table.resize('tableId');
    });
</script>
<%--绑定工具组件--%>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="edit"
       onclick="openEditPage('/role/edit.do?id={{d.id}}','460px','600px')">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick="doDelete('{{d.id}}');">删除</a>
</script>
</body>
</html>