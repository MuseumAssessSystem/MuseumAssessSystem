$(function () {
    var i = 1;
    $(".upload-application").click(function () {
        $('#upload,.mask').show();
    });
    $(".file-manage").click(function () {
        $('#file,.mask').show();
    });
    $(".add-files").click(function () {
        var content = "<li><input type='file' accept='application/msword,aplication/zip,application/x-rar-compressed'>" +
            "<button class='delete-input'>删除</button></li>";

        $(".upload-input").append(content);
        $(".upload-input :last-child input").attr("name","file"+i);
        i++;
    });
    $(".delete-input").click(function (e) {
        if(i > 1){
            $(this).parent().remove();
            i--;
        }
        else{
            // alert()
        }
        return false;
    })
});