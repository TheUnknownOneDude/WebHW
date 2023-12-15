<#-- @ftlvariable name="login" type="java.lang.String" -->
<#-- @ftlvariable name="password" type="java.lang.String" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="form-box">
        <div class="header">Article</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="postArticle"/>
                <div class="field">
                    <div class="name">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input id="title" name="title" value=""/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="text">Text</label>
                    </div>
                    <div class="value">
                        <input id="text" name="text" value=""/>
                    </div>
                </div>

                <div class="error"></div>

                <div class="button-field">
                    <input type="submit" value="Enter">
                </div>
            </form>
        </div>
    </div>


    <script>
        $(function () {
            $(".registration form").submit(function () {
                const title = $(this).find("input[name='title']").val();
                const text = $(this).find("input[name='text']").val();
                const $error = $(this).find("error")

                ajax($(this), {action: "postArticle", title: title, text: text}, $error)

                // $.ajax({
                //     type: "POST",
                //     dataType: "json",
                //     data: {
                //         action: "enter",
                //         login: login,
                //         password: password
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
