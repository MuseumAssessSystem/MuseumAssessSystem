$(function(){
    $(".link").click(function() {
        $(this).addClass("active")
            .parent("li").siblings().children("a")
            .removeClass("active");
        $(this).parent().find(".sub").toggle();
        $(this).parent().siblings().find(".sub").hide();
    });

    $(".close").click(function () {
        event.stopPropagation();
        $(".pop-up,.mask").hide();
    })
});
