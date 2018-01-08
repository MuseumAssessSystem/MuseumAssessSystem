/**
 * Created by Satan on 2018/1/6.
 */
$(function () {
    //上传的打分表
    var $upload_option=$("#upload_option")
    $upload_option.click(function () {
        $("#upload_sheet,.mask").show();
    });

    //显示详尽信息
    var $detail=$(".sheet_detail")
    $detail.click(function () {
        $("#detail_file,mask").show();
    });

    //删除
    var $delete=$(".sheet_delete");
    $delete.click(function() {
        if(confirm("确定是否删除?")){
            //调用后台函数重新刷新页面
        }else{
            //取消，保持页面不动
        }
    });
})