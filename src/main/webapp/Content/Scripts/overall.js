/**
 * Created by Satan on 2018/1/7.
 */
/**
 * Created by Satan on 2018/1/6.
 */
(function($){
    $.fn.extend({
        "makeSortable":function(){
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
                            var val1=$(row1).children('ul.body-item li').eq(n).text();
                            var val2=$(row2).children('ul.body-item li').eq(n).text();
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

$(function(){
    $(".table").makeSortable();
    $(".rank_type").makeSortable();
    $(".rank_area").makeSortable();
});
$(function () {
    $(".all_btn").click(function () {
        $(".museum_score,.calculate_rank").show();
    })
    $(".calculate_rank").click(function () {
        $(".second-nav,#tab-container").show();
    })
})
