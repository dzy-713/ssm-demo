<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>综合数据查询</title>
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
                <input class="layui-input" name="barcode" id="barcode" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload" onclick="reload()">搜索</button>
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


    layui.use('table', function () {});

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
                url: '/api/pickData/list?barcode='+$("#barcode").val(), //数据接口
                page: true,     //开启分页，默认false
                limit: 10,//每页显示条数，默认10
                limits: [10, 20, 30],//允许分页的列表
                loading: true,//翻页时显示loading，默认true
                initSort: {field: 'id', type: 'asc'},//初始排序
                cols: [[        //表头
                    //{type: 'checkbox'},//复选框
                    {field: 'type', title: '数据类型',width:120},
                    {field: 'barcode', title: '条码',width:200},
                    {field: 'qty', title: '采集数据总数',width:200},
                    {field: 'toolbar', title: '详情', toolbar: '#toolbar',width:120}
                ]]
            });

        });
    };

    reload();

    $(window).resize(function () {
        layui.table.resize('tableId');
    });

    function openDetail(type,barcode) {
        var urlParam="";
        switch (type){
            case "烧录校验":urlParam="burn";break;
            case "外观检测":urlParam="exterior";break;
            case "功能测试":urlParam="fun";break;
            case "压力测试":urlParam="pressure";break;
            case "称重检查":urlParam="weight";break;
            default:break;
        }
        if(urlParam!=""){
            layer.open({
                type: 2,
                title: type,
                closeBtn: 1, //显示关闭按钮
                shade: [0],
                area: ['80%', '80%'],
                maxmin: true, //开启最大化最小化按钮
                anim: 2,
                content: ['/'+urlParam+'/list.do?barcode='+barcode, 'yes'], //iframe的url，yes代表不显示滚动条
            });
        }

    }
</script>

<%--绑定工具组件--%>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-success layui-btn-xs" lay-event="del" onclick="openDetail('{{d.type}}','{{d.barcode}}');">打开详情</a>
</script>
</body>
</html>