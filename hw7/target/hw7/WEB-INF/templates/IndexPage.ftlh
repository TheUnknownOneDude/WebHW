<#import "commons.ftlh" as c>

<@c.page>
    <div class="articles datatable">
        <div class="caption">Article</div>
        <table>
            <thead>
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Text</th>
            </tr>
            </thead>
            <tbody>
            <template>
                <tr>
                    <td class="article-author"></td>
                    <td class="article-title"></td>
                    <td class="article-text"></td>
                </tr>
            </template>
            <tr class="noData">
                <td colspan="2">
                    No data
                </td>
            </tr>
            </tbody>
        </table>
    </div>


    <script>
        $(function () {
            const $noData = $(".articles .noData");
            $noData.find("td").text("Loading...");

            $.ajax({
                dataType: "json",
                data: {
                    action: "findAllArticles"
                },
                success: function(response) {
                    response["articles"].forEach(function(article) {
                        $noData.hide();
                        const $tr = $($(".articles template").prop("content")).clone();
                        let item = Object.values(response["users"]).find(el => el.id === article["userId"])
                        $tr.find(".article-author").text(item["login"]);
                        $tr.find(".article-title").text(article["title"]);
                        $tr.find(".article-text").text(article["text"]);
                        // $tr.find("tr").attr("data-userId", user["id"]);
                        $(".articles tbody").append($tr);
                    });
                    // $(".users tr").click(function() {
                    //     $.ajax({
                    //         dataType: "json",
                    //         data: {
                    //             action: "findUser",
                    //             userId: $(this).attr("data-userId")
                    //         },
                    //         success: function (response) {
                    //             notify(response["user"].creationTime);
                    //         },
                    //         type: "POST"
                    //     })
                    // });
                },
                type: "POST"
            });
        })
    </script>
</@c.page>
