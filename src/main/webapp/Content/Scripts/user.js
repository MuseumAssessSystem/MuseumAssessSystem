/**
 * Created by Satan on 2018/1/5.
 */
//添加
$(function(){
    var $insert_user=$(".insert_user");
    $insert_user.click(function() {
        $("#insert_user,.mask").show();
    });
});
//修改的弹窗：提交函数没写,感觉这个应该this
$(function(){
    var $alter=$(".alter");
    $alter.click(function() {
        $("#alter_user,.mask").show();
    });
});
//删除
$(function(){
    var $delete=$(".delete");
    $delete.click(function() {
        if(confirm("确定是否删除?")){
            //调用后台函数重新刷新页面
        }else{
            //取消，保getUserById持页面不动
        }
    });
});
//查看权限
$(function(){
    var $search_power=$(".search_power");
    $search_power.click(function() {
        $("#searcher_power,.mask").show();
    });
});
//修改权限
$(function(){
    var $edit_power=$(".edit_power");
    $edit_power.click(function() {
        $("#editor_power,.mask").show();
    });
});
