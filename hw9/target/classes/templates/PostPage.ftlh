<#-- @ftlvariable name="curPost" type="ru.itmo.wp.domain.Post" -->
<#-- @ftlvariable name="enterForm" type="ru.itmo.wp.form.UserCredentials" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <@c.post post=curPost/>
    <#if user??>
        <div class="Post form-box">
            <div class="header">Write Comment</div>
            <div class="body">
                <form method="post" action="writeComment">
                    <div class="field">
                        <input type="hidden" name="postId" value="${curPost.getId()}">
                        <div class="name">
                            <label for="text">Comment</label>
                        </div>
                        <div class="value">
                            <textarea id="text" name="text"></textarea>
                        </div>
                        <@c.error "commentForm.text"/>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Write">
                    </div>
                </form>
            </div>
        </div>
    </#if>
    <#list curPost.comments as comment>
        <@c.comment comment=comment/>
    </#list>
</@c.page>
