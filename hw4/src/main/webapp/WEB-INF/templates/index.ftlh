
<#import "./common.ftlh" as c>

<@c.page>
    <ul>
        <#list posts as post>
            <article>
                <div class="title">${post.title}</div>
                <#assign u = c.findBy(users, "id", post.user_id)!/>
                <div class="posted">${u.name}</div>
                <div class="body">
                    <p>${post.text}</p>
                </div>
                <div class="footer">
                    <div class="left">
                        <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                        <span class="positive-score">+tilt</span>
                        <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                    </div>
                    <div class="right">
                        <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                        today
                        <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                        <a href="#">+tilt</a>
                    </div>
                </div>
            </article>
        </#list>
    </ul>
</@c.page>
