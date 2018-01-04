$(function () {

    $.supersized({

        // Functionality
        slide_interval: 4000,    // Length between transitions
        transition: 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed: 1000,    // Speed of transition
        performance: 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width: 0,    // Min width allowed (in pixels)
        min_height: 0,    // Min height allowed (in pixels)
        vertical_center: 1,    // Vertically center background
        horizontal_center: 1,    // Horizontally center background
        fit_always: 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
        fit_portrait: 1,    // Portrait images will not exceed browser height
        fit_landscape: 0,    // Landscape images will not exceed browser width

        // Components
        slide_links: 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides: [    // Slideshow Images
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