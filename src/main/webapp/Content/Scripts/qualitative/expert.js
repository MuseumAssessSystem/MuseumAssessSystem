/**
 * Created by Satan on 2018/1/6.
 */
$(function () {
    //添加
    var $add_expert=$(".add_expert");
    $add_expert.click(function () {
        $("#insert_expert,.mask").show();
    });
//    修改
    var $expert_alter=$(".expert_alter");
    $expert_alter.click(function () {
        $("#alter_expert,.mask").show();
    })
// 详尽信息
    var $expert_details=$(".expert_details");
    $expert_details.click(function () {
        $("#detail_expert,.mask").show();
    })
//删除
    var $expert_delete=$(".expert_delete");
    $expert_delete.click(function () {
        if(confirm("确定是否删除?")){
            //调用后台函数重新刷新页面
        }else{
            //取消，保持页面不动
        }
    })
})