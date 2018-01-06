$(function () {

    $.supersized({

        slide_interval: 4000,
        transition: 1,
        transition_speed: 1000,
        performance: 1,

        min_width: 0,
        min_height: 0,
        vertical_center: 1,
        horizontal_center: 1,
        fit_always: 0,
        fit_portrait: 1,
        fit_landscape: 0,

        slide_links: 'blank',
        slides: [
            {image: '/Content/Images/login-bg1.jpg'},
            {image: '/Content/Images/login-bg2.jpg'},
            {image: '/Content/Images/login-bg3.jpg'}
        ]

    });

    $('.page-container form').submit(function () {
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if (username == '') {
            $(this).find('.error').text("请输入账号").fadeOut('fast', function () {
                $(this).css('top', '40px');
            });
            $(this).find('.error').text("请输入账号").fadeIn('fast', function () {
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if (password == '') {
            $(this).find('.error').text("请输入密码").fadeOut('fast', function () {
                $(this).css('top', '110px');
            });
            $(this).find('.error').text("请输入密码").fadeIn('fast', function () {
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function () {
        $(this).parent().find('.error').fadeOut('fast');
    });

});
