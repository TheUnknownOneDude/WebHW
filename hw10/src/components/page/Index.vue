<template>
    <div>
<!--    <article v-for="post in posts" :key="post.id">-->
<!--        <div class="title"><a href="#" @click.prevent="changePageWithId('Post', post.id)">{{post.title}}</a></div>-->
<!--        <div class="information">By user with id: {{post.userId}}</div>-->
<!--        <div class="body">{{post.text}}</div>-->
<!--&lt;!&ndash;        <ul class="attachment">&ndash;&gt;-->
<!--&lt;!&ndash;            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>&ndash;&gt;-->
<!--&lt;!&ndash;        </ul>&ndash;&gt;-->
<!--        <div class="footer">-->
<!--            <div class="left">-->
<!--                <img src="" title="Vote Up" alt="Vote Up"/>-->
<!--                <span class="positive-score">+173</span>-->
<!--                <img src="" title="Vote Down" alt="Vote Down"/>-->
<!--            </div>-->
<!--            <div class="right">-->
<!--                <img src="" title="Publish Time" alt="Publish Time"/>-->
<!--                    long ago-->
<!--                <img src="" title="Comments" alt="Comments"/>-->
<!--                <a href="#"></a>-->
<!--            </div>-->
<!--        </div>-->
<!--    </article>-->

        <ArticleTemplate v-for="post in posts" :key="post.id" :post="post" :with-href="true"/>
    </div>
</template>

<script>
import ArticleTemplate from "@/components/page/article/ArticleTemplate.vue";

export default {
    name: "Index",
    components: {ArticleTemplate},

    props: ["posts", "comments"],

    methods: {
        changePage: function (page) {
            this.$root.$emit("onChangePage", page);
        },

    }
}
</script>

<style scoped>

</style>
