$(document).ready(function(){
    $('.card .eBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function(country, status){
            $('.modalForm #id').val(country.id);
            $('.modalForm #name').val(country.name);
            $('.modalForm #capital').val(country.capital);
        });

        $('.modalForm #exampleModal').modal();
    });

    $('.cBtn').on('click', function(event){
            event.preventDefault();
            $('.modalForm #id').val('');
            $('modalForm #name').val('');
            $('modalForm #capital').val('');

            $('.modalForm #exampleModal').modal();
    });

    $('.dBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});