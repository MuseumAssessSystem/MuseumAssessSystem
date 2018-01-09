/**
 * Created by Satan on 2018/1/7.
 */
/**
 * Created by Satan on 2018/1/6.
 */
(function($){
    $.fn.extend({
        "makeSortable3":function(){
            var table=$(this),
                headers=table.find('.table-head li');
            for(var i=0,len=headers.length;i<len;i++){
                (function(n){
                    var flag=false;
                    headers.eq(n).click(function() {
                        var tbody=table.children('.table-body').eq(0);
                        var rows=tbody.children('ul.body-item');
                        rows=Array.prototype.slice.call(rows,0);

                        rows.sort(function(row1,row2){
                            var val1=$(row1).children('.body-item li').eq(n).text();
                            var val2=$(row2).children('.body-item li').eq(n).text();
                            if (n>=1&&n<=3) {
                                if(val1>val2){
                                    return 1;
                                }else if(val1<val2){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                            else{
                                return val1-val2;
                            }
                        });

                        if(flag){
                            rows.reverse();
                        }

                        tbody.append(rows);
                        flag=!flag;
                    });
                }(i));
            }

            return this;
        }
    });
})(jQuery);

(function($){
    $.fn.extend({
        "makeSortable1":function(){
            var table=$(this),
                headers=table.find('.table-head li');
            for(var i=0,len=headers.length;i<len;i++){
                (function(n){
                    var flag=false;
                    headers.eq(n).click(function() {
                        var tbody=table.children('.table-body').eq(0);
                        var rows=tbody.children('ul.body-item');
                        rows=Array.prototype.slice.call(rows,0);

                        rows.sort(function(row1,row2){
                            var val1=$(row1).children('.body-item li').eq(n).text();
                            var val2=$(row2).children('.body-item li').eq(n).text();
                            if (n===1) {
                                if(val1>val2){
                                    return 1;
                                }else if(val1<val2){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                            else{
                                return val1-val2;
                            }
                        });

                        if(flag){
                            rows.reverse();
                        }

                        tbody.append(rows);
                        flag=!flag;
                    });
                }(i));
            }

            return this;
        }
    });
})(jQuery);
(function($){
    $.fn.extend({
        "makeSortable2":function(){
            var table=$(this),
                headers=table.find('.table-head li');
            for(var i=0,len=headers.length;i<len;i++){
                (function(n){
                    var flag=false;
                    headers.eq(n).click(function() {
                        var tbody=table.children('.table-body').eq(0);
                        var rows=tbody.children('ul.body-item');
                        rows=Array.prototype.slice.call(rows,0);

                        rows.sort(function(row1,row2){
                            var val1=$(row1).children('.body-item li').eq(n).text();
                            var val2=$(row2).children('.body-item li').eq(n).text();
                            if (n>=1&&n<=2) {
                                if(val1>val2){
                                    return 1;
                                }else if(val1<val2){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                            else{
                                return val1-val2;
                            }
                        });

                        if(flag){
                            rows.reverse();
                        }

                        tbody.append(rows);
                        flag=!flag;
                    });
                }(i));
            }

            return this;
        }
    });
})(jQuery);

$(function(){
    $(".dx_all_rank").makeSortable3();
    $(".dx_one_rank").makeSortable1();
    $(".dx_two_rank").makeSortable1();
    $(".dx1_one_type").makeSortable2();
    $(".dx1_one_level").makeSortable2();
    $(".dx2_two_type").makeSortable2();
    $(".dx2_two_level").makeSortable2();
});
$(function () {
    $(".dx_btn").click(function () {
        $(".museum_score,.calculate_rank").show();
    })
    $(".calculate_rank").click(function () {
        $(".second-nav,#tab-container").show();
    })
})