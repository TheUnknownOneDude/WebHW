<script setup>

</script>

<template>
    <article>
        <div class="title">
<!--            <a v-if="withHref" href="#" @click.prevent="changePageWithId('Post', post.id)">{{post.title}}</a>-->
<!--            <a v-else>{{post.title}}</a>-->
            <a >{{post.title}}</a>
        </div>
        <div class="information">By user with id: {{post.user.id}}</div>
        <div class="body">{{post.text}}</div>
        <!--        <ul class="attachment">-->
        <!--            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>-->
        <!--            <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>-->
        <!--        </ul>-->
        <div class="footer">
            <div class="left">
                <img src="../../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
                <span class="positive-score">+173</span>
                <img class="vote" src="../../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
            </div>
            <div class="right">
                <img src="../../../assets/img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                long ago
                <img src="../../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
<!--                <a v-if="!withHref">{{ commentsCount }}</a>-->
<!--                <a v-else>Look into post to see amount of comments</a>-->
                <a>Look into post to see amount of comments</a>
            </div>
        </div>
    </article>
</template>

<script>
export default {
    name: 'ArticleTemplate',

    props: ["post", "commentsCount", "withHref"],

    methods: {
        changePageWithId: function (page, postId) {
            this.$root.$emit("onChangePageWithId", page, postId);
        }
    }
}
</script>

<style scoped>

</style>