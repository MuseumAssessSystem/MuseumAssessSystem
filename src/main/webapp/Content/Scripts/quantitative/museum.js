$(function(){
    $(".museum-details").click(function () {
        $('#museumDetails,.mask').show();
    });
    $(".museum-alt").click(function () {
        $('#museumAlt,.mask').show();
    });
    $(".museum-add").click(function () {
        $('#museumAdd,.mask').show();
    });

    $(".close").click(function () {
        event.stopPropagation();
        $(".pop-up,.mask").hide();
    })
});