//Menu
$('#main-menu').smartmenus({});

$('.ic-toggler').click(function(){
    $(this).parent().find('.menu').toggleClass('show');
    $(this).toggleClass('active');
});