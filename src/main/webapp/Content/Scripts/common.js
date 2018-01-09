$(function(){

    //导航
    $(".link").hover(function() {
        $(this).addClass("active")
            .parent("li").siblings().children("a")
            .removeClass("active");
        $(this).parent().find(".sub").stop().slideDown();
        $(this).parent().siblings().find(".sub").stop().slideUp();
    });

    //返回
    $('.close').on('click', function(){
        layer.confirm('确认返回？', {
            btn: ['确认','取消'],
            yes:function(index){
                layer.close(index);
                $(".pop-up,.mask").hide();
            }
        })
    });
    //删除
    $(".delete").on('click', function(){
        if(confirm("确定是否删除?")){

        }else{

        }
    });

    //tab切换
    $(".tab").click(function(){

        $clicked = $(this);

        if ($clicked.css("opacity") == "1" && $clicked.is(":not(animated)")) {

            $clicked.animate({
                opacity: 0.5
            }, 600 );

            var idToLoad = $clicked.attr("id").split('-');

            $("#tab-container").children("div:visible").fadeOut("fast", function(){
                $(this).parent().children("#"+idToLoad[0]).fadeIn();
            })
        }

        $clicked.siblings(".tab").animate({
            opacity: 1
        }, 600 );

    });
    //表格 tab切换
    $(".table-tab").click(function(){

        $clicked = $(this);

        if ($clicked.css("opacity") == "1" && $clicked.is(":not(animated)")) {

            $clicked.animate({
                opacity: 0.6,
                borderWidth: 2
            }, 600 );

            var idToLoad = $clicked.attr("id").split('-');

            $(".table-tab-container").children("div:visible").fadeOut("fast", function(){
                $(this).parent().children("#"+idToLoad[0]).fadeIn();
            })
        }

        $clicked.siblings(".table-tab").animate({
            opacity: 1,
            borderWidth: 0
        }, 600 );

    });
});
