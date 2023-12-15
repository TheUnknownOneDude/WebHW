<#-- @ftlvariable name="colours" type="ru.itmo.web.hw4.model.UserColour[]" -->
<#-- @ftlvariable name="uri" type="String" -->
<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="stylesheet" href="/css/normalize.css">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="icon" href="/favicon.ico">
    </head>
    <body>
    <@header/>
    <div class="middle">
        <@sidebar/>
        <main>
            <#nested/>
        </main>
    </div>
    <@footer/>
    </body>
    </html>
</#macro>

<#macro header>
    <header>
        <a href="#" class="logo"><img alt="Codeforces" title="Codeforces"
                                      src="/img/codeforces-logo-with-telegram.png"></a>
        <div class="languages">
            <a href="#"><img alt="In English" title="In English"
                             src="/img/gb.png"></a>
            <a href="#"><img alt="In Russian" title="In Russian"
                             src="/img/ru.png"></a>
        </div>
        <div class="enter-or-register-box">
            <#if user??>
                <@userlink user "true"/>
                |
                <a href="/logout">Logout</a>
            <#else>
                <a href="/enter">Enter</a>
                |
                <a href="/register">Register</a>
            </#if>
        </div>
        <nav>
            <#assign items=[
            {"href": "/index", "name": "Home"},
            {"href": "/misc/help", "name": "Help"},
            {"href": "/contests", "name": "Contests"},
            {"href": "/users", "name": "Users"}
            ]/>
            <ul>
                <#list items as item>
                    <li>
                        <#if item["href"]?starts_with(uri)>
                            <a class="underlined" href="${item.href}">${item.name}</a>
                        <#else>
                            <a href="${item.href}">${item.name}</a>
                        </#if>
                    </li>
                </#list>
            </ul>
        </nav>
    </header>
</#macro>

<#macro sidebar>
    <aside>
        <section>
            <div class="header">Information</div>
            <div class="body">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores enim expedita facilis
                fugiat ipsum iste nobis reprehenderit tempore ut voluptatibus?
            </div>
            <div class="footer">
                <a href="#">View all</a>
            </div>
        </section>
        <section>
            <div class="header">Information</div>
            <div class="body">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores enim expedita facilis
                fugiat ipsum iste nobis reprehenderit tempore ut voluptatibus?
            </div>
            <div class="footer">
                <a href="#">View all</a>
            </div>
        </section>
        <section>
            <div class="header">Information</div>
            <div class="body">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores enim expedita facilis
                fugiat ipsum iste nobis reprehenderit tempore ut voluptatibus?
            </div>
            <div class="footer">
                <a href="#">View all</a>
            </div>
        </section>
    </aside>
</#macro>

<#macro footer>
    <footer>
        2010-2021 &copy; by Mike Mirzayanov
    </footer>
</#macro>

<#--<#macro userlink user>-->
<#--&lt;#&ndash; @ftlvariable name="user" type="ru.itmo.web.hw4.model.User" &ndash;&gt;-->
<#--    <a href="/user?handle=${user.handle}">${user.name}</a>-->
<#--</#macro>-->

<#macro userpage user>
    <#if user?has_content>
        <div class="userbox">
            <@userlink user "false"/>
            <img class="userimage" src="../../img/no-title.jpg" alt="no-title" title="No-title">
            <ul>
                <li>id: ${user.id}</li>
                <li>handle: ${user.handle}</li>
                <li>name: ${user.name}</li>
            </ul>
        </div>
        <div class="usernavigation">
            <#list users as cur>
                <#if cur.id == user.id>
                    <#if !(cur?is_first)>
                        <a href="/user?handle=${users[cur_index - 1].handle}">&larr;</a>
                    <#else>
                        &larr;
                    </#if>
                    <#if cur?has_next>
                        <a href="/user?handle=${users[cur_index + 1].handle}">&rarr;</a>
                    <#else>
                        &rarr;
                    </#if>
                    <#break>
                </#if>
            </#list>
        </div>
    <#else>
        No such user.
    </#if>
</#macro>

<#function getColour u>
    <#list colours as colour>
        <#if colour == u.colour>
            <#return colour.toCssClass()>
        </#if>
    </#list>
</#function>

<#macro userlink user nameOnly>
    <#if nameOnly == "true">
        <a class="userLink"
           href="/user?handle=${user.handle}">${user.handle}</a>
    <#else>
        <a class="userLink userLink${user.colour}" href="/user?handle=${user.handle}">${user.handle}</a>
    </#if>
</#macro>


<#function findBy items key value>
    <#list items as item>
        <#if item[key] == value>
            <#return item/>
        </#if>
    </#list>
</#function>
