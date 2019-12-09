/**
 * Created by rlzz-dev on 2017/7/18.
 */
/**
 * 关闭页签
 * @param model
 */
function closeNavTab(model) {
    //全体样式清除
    $('#myTab').find('li').removeClass("active");
    //打开临近页签
    $(model).parent().prev().addClass('active');
    var prevDiv = $('#myTabContent').find('div.active').prev();
    //删掉当前页签
    $(model).parent().remove();
    $('#myTabContent').find('div.active').remove();
    //打开临近页签
    prevDiv.addClass('active').addClass('in');

}

/**
 * 打开菜单
 * @param url 访问地址
 * @param tabName 页签名称
 */
function openMenu(url, tabName, menuId) {
    //清除所有菜单li标签active样式
    $("#sidebar-menu").find("li").removeClass('active');
    //如果菜单已打开，则跳转到目标页面
    if ($('#' + menuId + '')[0] != null) {
        //全体样式清除
        $('#myTab').find('li').removeClass("active");
        //清除div样式
        $('#myTabContent').find('div.active').removeClass('active').removeClass('in');
        //选中目标页签
        $('#myTab').find('a[href="#' + menuId + '"]').parent().addClass("active");
        $('#' + menuId + '').addClass('active').addClass('in');
    } else {
        //全体样式清除
        $('#myTab').find('li').removeClass("active");
        //添加新的页签
        $('#myTab').append('<li role="presentation" class="active">' +
            '<a href="#' + menuId + '" role="tab" data-toggle="tab"' +
            'aria-expanded="false" >' + tabName + '</a>' +
            '<i title="关闭" class="fa fa-minus-square" onclick="closeNavTab(this)"></i></li>');
        //清除div样式
        $('#myTabContent').find('div.active').removeClass('active').removeClass('in');
        //新增iframe
        $('#myTabContent').append('<div role="tabpanel" class="tab-pane fade active in" ' +
            'id="' + menuId + '" aria-labelledby="profile-tab"><iframe name="frame" ' +
            'src="' + url + '" frameborder="0" style="width: 100%"></iframe></div>');
    }
    //高度计算
    var bodyHeight = $BODY.outerHeight(),
        footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
        leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
        contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;
    // normalize content
    contentHeight -= $NAV_MENU.height() + footerHeight;
    //修改iframe 高度
    $('iframe').css('height', contentHeight - 24 - 90);
}

/**
 * 打开参照页面
 * @param url 参照数据地址
 * @param jsPath 参照页面js路径
 * @param multiSelect 是否多选 true、false
 */
function openReference(url, jsPath, multiSelect) {
    var content = "/reference?url=" + url;
    if (jsPath != null && jsPath != "") {
        content = content + "&jsPath=" + jsPath;
    }
    if (multiSelect != null && multiSelect) {
        content = content + "&multiSelect=" + multiSelect;
    }
    top.layer.open({
        type: 2,//frame类型
        closeBtn: 1, //显示关闭按钮
        resize: false,//是否允许拉伸，默认true
        anim: 0, //动画类型 0~6  -1无动画 默认0
        area: [], //宽高
        fixed: true,//鼠标滚动时，是否固定
        success: function (layero, index) {
            //layer.iframeAuto(index);
        },
        shadeClose: true, //开启遮罩关闭
        content: content //内容
    });
}