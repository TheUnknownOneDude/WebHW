<#import "commons.ftlh" as c>

<@c.page>
    <div class="registration form-box">
        <div class="header">Register</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value=""/>
                <div class="field">
                    <div class="name">
                        <label for="login">Login</label>
                    </div>
                    <div class="value">
                        <input id="login" name="login" value=""/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="email">Email</label>
                    </div>
                    <div class="value">
                        <input id="email" name="email" type="email" value=""/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="password">Password</label>
                    </div>
                    <div class="value">
                        <input id="password" name="password" type="password" value=""/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="passwordConfirmation">Password Confirmation</label>
                    </div>
                    <div class="value">
                        <input id="passwordConfirmation" name="passwordConfirmation" type="password" value=""/>
                    </div>
                </div>


                <div class="error"></div>

                <div class="button-field">
                    <input type="submit" value="Register">
                </div>
            </form>
        </div>
    </div>

<#--    <script>-->
<#--        $(function () {-->
<#--            $(".registration form").submit(function () {-->
<#--                const login = $(this).find("input[name='login']").val();-->
<#--                const email = $(this).find("input[name='email']").val();-->
<#--                const password = $(this).find("input[name='password']").val();-->
<#--                const passwordConfirmation = $(this).find("input[name='passwordConfirmation']").val();-->
<#--                const $error = $(this).find(".error");-->

<#--                $.ajax({-->
<#--                    type: "POST",-->
<#--                    url: "",-->
<#--                    dataType: "json",-->
<#--                    data: {-->
<#--                        action: "register",-->
<#--                        login: login,-->
<#--                        email: email,-->
<#--                        password: password,-->
<#--                        passwordConfirmation: passwordConfirmation-->
<#--                    },-->
<#--                    success: function (response) {-->
<#--                        if (response["error"]) {-->
<#--                            $error.text(response["error"]);-->
<#--                        } else {-->
<#--                            location.href = response["redirect"];-->
<#--                        }-->
<#--                    }-->
<#--                });-->

<#--                return false;-->
<#--            });-->
<#--        })-->
<#--    </script>-->

    <script>
        $(function () {
            $(".registration form").submit(function () {
                const login = $(this).find("input[name='login']").val();
                const email = $(this).find("input[name='email']").val();
                const password = $(this).find("input[name='password']").val();
                const passwordConfirmation = $(this).find("input[name='passwordConfirmation']").val();
                const $error = $(this).find(".error")

                ajax($(this), {action: "register", login: login, password: password, email: email, passwordConfirmation: passwordConfirmation}, $error)

                // $.ajax({
                //     type: "POST",
                //     dataType: "json",
                //     data: {
                //         action: "register",
                //         login: login,
                //         password: password,
                //         email: email,
                //         passwordConfirmation: passwordConfirmation
                //     },
                //     success: function (response) {
                //         if (response["error"]) {
                //             $error.text(response["error"]);
                //         } else {
                //             location.href = response["redirect"];
                //         }
                //     }
                // });

                return false;
            });
        })
    </script>
</@c.page>
