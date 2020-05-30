$(document).ready(function () {

    $("#registrationForm").validate({
        rules: {
            firstName: {
                required: true
            },

            lastName: {
                required: true
            },

            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                phone: true
            }
        },

        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        },

        messages: {

            firstName: {
                required: "Обязательно для заполнения"
            },

            lastName: {
                required: "Обязательно для заполнения"
            },

            email: {
                required: "Обязательно для заполнения",
                email: "Некорректный email адресс"
            },

            phone: {
                required: "Обязательно для заполнения",
                phone: "Некорректный номер телефона"
            }

        },

    })



})