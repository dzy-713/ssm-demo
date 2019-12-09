<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>称重检查列表</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link href="/build/css/custom.css" rel="stylesheet">
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="layui-row">
    <div class="layui-btn-group layui-col-xs6">
        <button class="layui-btn" onclick="reload()"><i class="fa fa-refresh"></i> 刷新</button>
    </div>

    <div class="layui-col-xs6">
        <div class="panel_toolbox">
            条码：
            <div class="layui-inline">
                <input class="layui-input" name="barcode" id="barcode" autocomplete="off" value="${barcode}">
            </div>
            <button class="layui-btn" data-type="reload" onclick="reload()">搜索</button>
        </div>
    </div>
</div>
<%--<div class="nav navbar-right"><a class="btn btn-success"--%>
<%--onclick="openEditPage('/user/edit.do',null,800)">创建新的用户</a>--%>
<%--</div>--%>
<shiro:hasPermission name="weight-edit">
    <input type="hidden" id="editPermission">
</shiro:hasPermission>
<table id="demo" lay-filter="test" lay-data="{id: 'idTest'}"></table>

<script src="/layui/layui.js"></script>
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<script>


    layui.use('table', function () {});

    function reload() {
        layui.use('table', function () {
            var table = layui.table;
            var form = layui.form;

            var option={
                id:'tableId',
                elem: '#demo',  //指定 table
                height: null,    //高度   窗口高度-一个值
                width: null,    //默认铺满父元素，自带滚动条
                done: function () {
                },    //数据渲染后回调函数
                data: [],    //加载静态数据
                url: '/api/weight/list?barcode='+$("#barcode").val(), //数据接口
                page: true,     //开启分页，默认false
                limit: 10,//每页显示条数，默认10
                limits: [10, 20, 30],//允许分页的列表
                loading: true,//翻页时显示loading，默认true
                initSort: {field: 'id', type: 'asc'},//初始排序
                cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                cols: [[        //表头
                    //{type: 'checkbox'},//复选框
                    {field: 'id', title: 'ID'},
                    {field: 'barcode', title: '条码'},
                    {field: 'worker', title: '工号'},
                    {field: 'testTime', title: '测试时间',templet:'<div>{{ layui.util.toDateString(d.testTime, "yyyy-MM-dd HH:mm:ss") }}</div>'},
                    {field: 'weight', title: '重量'},
                    {field: 'station', title: '工站'},
                    {field: 'pass', title: '测试通过'}
                ]]
            };
            //编辑权限
            if($("#editPermission").length>0){
                option.cols[0].push({field: 'toolbar', title: '操作', toolbar: '#toolbar'});
            }
            //第一个实例
            table.render(option);

        });
    };

    function doDelete(id) {
        layer.confirm('确认要删除该数据?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                cache: true,
                type: "POST",
                //dataType: 'json',
                contentType: "application/json; charset=utf-8",
                url: "/api/weight/delete?id=" + id,
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

    /*$(window).resize(function () {
        layui.table.resize('tableId');
    });*/
</script>

<%--绑定工具组件--%>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick="doDelete('{{d.id}}');">删除</a>
</script>
</body>
</html>